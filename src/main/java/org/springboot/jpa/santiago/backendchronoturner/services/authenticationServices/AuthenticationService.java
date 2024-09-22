package org.springboot.jpa.santiago.backendchronoturner.services.authenticationServices;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springboot.jpa.santiago.backendchronoturner.dto.authenticationDTO.AuthenticationRequest;
import org.springboot.jpa.santiago.backendchronoturner.dto.authenticationDTO.AuthenticationResponse;
import org.springboot.jpa.santiago.backendchronoturner.dto.authenticationDTO.RegistrationRequest;
import org.springboot.jpa.santiago.backendchronoturner.email.EmailService;
import org.springboot.jpa.santiago.backendchronoturner.email.EmailTemplateName;
import org.springboot.jpa.santiago.backendchronoturner.entities.Token;
import org.springboot.jpa.santiago.backendchronoturner.entities.User;
import org.springboot.jpa.santiago.backendchronoturner.repositories.RoleRepository;
import org.springboot.jpa.santiago.backendchronoturner.repositories.TokenRepository;
import org.springboot.jpa.santiago.backendchronoturner.repositories.UserRepository;
import org.springboot.jpa.santiago.backendchronoturner.security.JSWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
        //Atributos de AuthenticationService
    @Autowired
    private RoleRepository repoRole;
    @Autowired
    private TokenRepository repoToken;
    @Autowired
    private UserRepository repoUser;

    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;
    private final AuthenticationManager authenticationManager;
    private final JSWTService jwtService;
    @Value("${spring.mailing.frontend.activation-url}")
    private String activationUrl;

    //Constructores de AuthenticationService
    //Asignadores de atributos de AuthenticationService (setters)
    //Lectores de atributos de AuthenticationService (getters)
        //Métodos de AuthenticationService
    public void register(RegistrationRequest request) throws MessagingException {
        var userRole = this.repoRole.findByName("USER")
                .orElseThrow(() -> new IllegalStateException("ROLE USER was not initialised"));
        var user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .accountLocked(false)
                .roles(List.of(userRole))
                .build();
        this.repoUser.save(user);
        sendValidationEmail(user);
    }

    private void sendValidationEmail(User user) throws MessagingException {
        var newToken = generateAndSaveActivationToken(user);
        this.emailService.sendEmail(
                user.getEmail(),
                user.getName(),
                EmailTemplateName.ACTIVATE_ACCOUNT,
                activationUrl,
                newToken,
                "Account activation"
        );
        //Send email
    }

    private String generateAndSaveActivationToken(User user) {
        // generate a token
        String generatedToken = generateActivationCode(6);
        var token = Token.builder()
                .token(generatedToken)
                .createdAt(LocalDateTime.now())
                .expiresAt(LocalDateTime.now().plusMinutes(15))
                .user(user)
                .build();
        this.repoToken.save(token);
        return generatedToken;
    }

    private String generateActivationCode(int length) {
        String characters = "0123456789";
        StringBuilder codeBuilder = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        for (int i = 0; i < length; i++){
            int randomIndex = secureRandom.nextInt(characters.length());
            codeBuilder.append(characters.charAt(randomIndex));
        }
        return codeBuilder.toString();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        var auth = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    request.getEmail(),
                    request.getPassword()
            )
        );
        var claims = new HashMap<String, Object>();
        var user = ((User)auth.getPrincipal());
        claims.put("fullName", user.getName());
        var jwtToken = jwtService.generateToken(claims, user);
        return AuthenticationResponse.builder()
            .token(jwtToken).build();
    }

        //@Transactional
    public void activateAccount(String token) throws MessagingException {
        Token savedToken = this.repoToken.findByToken(token)
                .orElseThrow(
                    () -> new RuntimeException("Invalid token")
                );
        if(LocalDateTime.now().isAfter(savedToken.getExpiresAt())) {
            sendValidationEmail(savedToken.getUser());
            throw new RuntimeException("Activation token has expired. A new token has been sent to the same email address");
        }
        var user = this.repoUser.findById(savedToken.getUser().getId())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        user.setEnabled(true);
        this.repoUser.save(user);
        savedToken.setValidatedAt(LocalDateTime.now());
        this.repoToken.save(savedToken);
    }
}

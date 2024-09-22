package org.springboot.jpa.santiago.backendchronoturner.security;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springboot.jpa.santiago.backendchronoturner.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
        //Atributos de UserDetailsServiceImpl
    @Autowired
    private final UserRepository repoUser;

    //Constructores de UserDetailsServiceImpl
    //Asignadores de atributos de UserDetailsServiceImpl (setters)
    //Lectores de atributos de UserDetailsServiceImpl (getters)
        //Métodos de UserDetailsServiceImpl
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return (UserDetails) this.repoUser.findByEmail(email)
                .orElseThrow(
                        () -> new UsernameNotFoundException("User not found")
                );
    }

}

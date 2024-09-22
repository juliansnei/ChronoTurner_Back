package org.springboot.jpa.santiago.backendchronoturner.services.serviceImplementations;

import org.springboot.jpa.santiago.backendchronoturner.entities.User;
import org.springboot.jpa.santiago.backendchronoturner.repositories.UserRepository;
import org.springboot.jpa.santiago.backendchronoturner.services.entityServices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
        //Atributos de UserServiceImpl
    @Autowired
    private UserRepository repoUser;

    //Constructores de UserServiceImpl
    //Asignadores de atributos de UserServiceImpl (setters)
    //Lectores de atributos de UserServiceImpl (getters)
        //Métodos de UserServiceImpl
    @Override
    public Optional<User> findById(String id) {
        return this.repoUser.findById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return this.repoUser.findByEmail(email);
    }

    @Override
    public User save(User user) {
        return this.repoUser.save(user);
    }

    @Override
    public void delete(User user) {
        this.repoUser.delete(user);
    }

    @Override
    public void deleteById(String id) {
        this.repoUser.findById(id).ifPresentOrElse(
                u -> {this.repoUser.deleteById(id);},
                () -> System.out.println("The user you're trying to delete hasn't been found")  //Aquí también se puede arrojar una excepción bien poderosa
        );
    }
}

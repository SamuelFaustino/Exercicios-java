package me.dio.service.impl;

import me.dio.domain.model.User;
import me.dio.domain.repository.UserRepository;
import me.dio.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        /*
        if (userToCreate.getId() != null && userRepository.existsById(userToCreate.getId())) {
            throw new IllegalArgumentException("This user ID already exists!");
        }
        */
        if(userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            // Utiliza acesso a uma tabela secundária a qual o de usuários se relaciona, poara fazer a verificação
            // Utilizando uma simples assinatura de metodo na interface de Repository do userRepository
            throw new IllegalArgumentException("This Account number already exists!");
        }
        return userRepository.save(userToCreate);
    }
}

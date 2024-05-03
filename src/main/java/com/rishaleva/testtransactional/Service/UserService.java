package com.rishaleva.testtransactional.Service;

import com.rishaleva.testtransactional.Entity.User;
import com.rishaleva.testtransactional.UserReposiory.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserService userService;

    public UserService(UserRepository userRepository, @Lazy UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public void save() {
        User user = User.builder().id( 1L).name("SAVE USER").email("SAVE EMAIL").build();
        try {
            userService.method1();
        } catch (RuntimeException e) {
            log.error("Ошибка");
        }
        userRepository.save(user);
    }

    @Transactional
    public void method1 () {
        throw new RuntimeException();
    }
}

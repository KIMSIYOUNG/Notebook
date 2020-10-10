package com.example.osivexample.transaction;

import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public User create(User user) {
        return userRepository.save(user);
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
    public User findById(Long id) {
        return userRepository.findById(id)
            .orElseThrow(IllegalArgumentException::new);
    }

    public User findOrCreate(Long id) {
        try {
            System.out.println(TransactionSynchronizationManager.getCurrentTransactionName() + " 111111111");
            return findById(id);
        } catch (IllegalArgumentException e) {
            System.out.println(TransactionSynchronizationManager.getCurrentTransactionName() + " 2222222222222");
            User user = create(new User("asdasd"));
            System.out.println(TransactionSynchronizationManager.getCurrentTransactionName() + " \333333333333");
            User findUser = userRepository.findById(user.getId())
                .orElseThrow(IllegalArgumentException::new);
            System.out.println(TransactionSynchronizationManager.getCurrentTransactionName() + " 44444444444444" );
            return findUser;
        }
    }

    public User findOrCreate2(Long id) {
        return userRepository.findById(id)
            .orElse(userRepository.save(new User(1L, "TEST____USER")));
    }

    public User update(User user) {
        user.setName("BBBBBBBBBBBBBBBB");

        return user;
    }
}

package com.example.osivexample.lock;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Savepoint;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
class OptimisticMemberRepositoryTest {

    @Autowired
    OptimisticMemberRepository optimisticMemberRepository;

    @Autowired EntityManager entityManager;

    @Test
    void create() {
        OptimisticMember savedMember = optimisticMemberRepository.save(new OptimisticMember("AAA"));
        entityManager.flush();
        entityManager.clear();
        OptimisticMember hello = optimisticMemberRepository.findById(savedMember.getId()).orElseThrow(IllegalAccessError::new);


        OptimisticMember findMember = entityManager.find(OptimisticMember.class, savedMember.getId(),
            LockModeType.OPTIMISTIC_FORCE_INCREMENT);

        System.out.println(findMember.getVersion());
        entityManager.flush();
        entityManager.clear();
        OptimisticMember findMember2 = entityManager.find(OptimisticMember.class, savedMember.getId(),
            LockModeType.OPTIMISTIC_FORCE_INCREMENT);
        System.out.println(findMember2.getVersion());
    }

    @Rollback(false)
    @Test
    void name() {
        OptimisticMember aaa = new OptimisticMember("aaa");
        entityManager.persist(aaa);
        Book book = new Book("AAAA", aaa);
        entityManager.persist(book);

        entityManager.flush();
        entityManager.clear();

        OptimisticMember find = entityManager.find(OptimisticMember.class, aaa.getId(),
            LockModeType.OPTIMISTIC_FORCE_INCREMENT);
        entityManager.persist(new Book("BBB", aaa));
        System.out.println(find.getVersion());
    }
}
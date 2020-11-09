package com.example.osivexample.lock;

import java.util.Optional;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.QueryHints;

public interface OptimisticMemberRepository extends JpaRepository<OptimisticMember, Long> {
    @Override
    @Lock(value = LockModeType.PESSIMISTIC_READ)
    @QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value = "3000")})
    Optional<OptimisticMember> findById(Long aLong);
}

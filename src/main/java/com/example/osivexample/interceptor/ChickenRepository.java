package com.example.osivexample.interceptor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChickenRepository extends JpaRepository<Chicken, Long> {
}

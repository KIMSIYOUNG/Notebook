package com.example.osivexample.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyRepository extends JpaRepository<Study, Long> {

    List<Study> findByName(String name);

}

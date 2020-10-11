package com.example.osivexample.jpa;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@DataJpaTest
class StudyRepositoryTest {
    @Autowired StudyRepository studyRepository;
    @Autowired VersionRepository versionRepository;
    @Autowired EntityManager em;

    @Rollback(false)
    @Test
    void name() {
        Study none = new Study("AAA");
        Study savedStudy = studyRepository.save(none);

        Optional<Study> first = studyRepository.findById(savedStudy.getId());
        System.out.println("=====================");
        studyRepository.delete(savedStudy);
        System.out.println("=====================");
        Optional<Study> study = studyRepository.findById(savedStudy.getId());

        System.out.println("삭제 쿼리가 나갈까?");


        System.out.println("이 때 나가나?");
    }

    @Test
    void asd() {
        Study study = new Study();
        Study savedStudy = studyRepository.save(study);

        Version version = new Version();
        version.setStudy(savedStudy);
        Version savedVersion = versionRepository.save(version);

        em.flush();
        em.clear();

        Version findVersion = em.createQuery("select v from Version v join fetch v.study", Version.class)
            .getSingleResult();

        Optional<Version> byId = versionRepository.findById(findVersion.getId());

        assertThat(findVersion.getStudy()).isEqualTo(savedStudy);
    }

    @Test
    void qwewqe() {
        Study study = new Study();
        Study savedStudy = studyRepository.save(study);

        Study study2 = new Study();
        Study savedStudy2 = studyRepository.save(study2);

        Study study3 = new Study();
        Study savedStudy3 = studyRepository.save(study3);

        Version version = new Version();
        version.setStudy(savedStudy);

        Version version2 = new Version();
        version2.setStudy(savedStudy2);

        Version version3 = new Version();
        version3.setStudy(savedStudy3);

        versionRepository.save(version);
        versionRepository.save(version2);
        versionRepository.save(version3);

        em.flush();
        em.clear();

        // List<Study> select_s_from_study_s = em.createQuery("select s from Study s", Study.class)
        //     .getResultList();
        Version version4 = versionRepository.findById(version.getId()).get();
        // List<Version> all = versionRepository.findAll();
        // for (Version version1 : all) {
        //     System.out.println(version1.getStudy().getName());
        // }
    }
}
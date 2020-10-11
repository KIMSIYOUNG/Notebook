package com.example.osivexample.jpa;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class StudyService {
    private final StudyRepository studyRepository;
    private final VersionRepository versionRepository;

    public void hello() {
        Study study = new Study();
        Version version = new Version();
        studyRepository.save(study);


        version.setStudy(study);
        Version save = versionRepository.save(version);

        versionRepository.findById(save.getId());
    }
}

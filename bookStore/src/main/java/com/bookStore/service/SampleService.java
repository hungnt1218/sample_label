package com.bookStore.service;

import com.bookStore.entity.Label;
import com.bookStore.entity.Sample;
import com.bookStore.repository.LabelRepo;
import com.bookStore.repository.SampleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SampleService {
    @Autowired
    private SampleRepo sampleRepo;

    public void save(Sample b) {
        sampleRepo.save(b);
    }

    public List<Sample> getAllSample(){
        return sampleRepo.findAll();
    }

    public Sample getSampleById(Long id) {
        return sampleRepo.findById(id).get();
    }
    public void deleteById(Long id) {
        sampleRepo.deleteById(id);
    }
}

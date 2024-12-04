package com.bookStore.service;

import com.bookStore.entity.Label;
import com.bookStore.repository.LabelRepo;
import com.bookStore.request.SearchLabelRequest;
import com.bookStore.specification.SearchLabelSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabelService {
    @Autowired
    private LabelRepo labelRepo;

    public void save(Label b) {
        labelRepo.save(b);
    }

    public List<Label> getAllLabel(SearchLabelRequest request) {
        List<Label> labelList = labelRepo.getByUsername(request.getName());
        return labelList;
    }

    public Label getLabelById(Long id) {
        return labelRepo.findById(id).get();
    }
    public void deleteById(Long id) {
        labelRepo.deleteById(id);
    }
}

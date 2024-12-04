package com.bookStore.specification;

import com.bookStore.entity.Label;
import org.hibernate.sql.ordering.antlr.CollationSpecification;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class SearchLabelSpecification extends CollationSpecification {
    public static Specification<Label> searchLabel(String keyword) {
        return (root, cq, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            Predicate predicate = cb.like(root.get("name"), "%" + keyword + "%");
            predicates.add(predicate);
            return cb.and(predicates.toArray(Predicate[]::new));
        };
    }
}

package com.bookStore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Label {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Boolean isActive;
    private Date createAt;
    private Date updateAt;
    private String updateBy;
    private String createBy;

    public Label(String name, Boolean isActive) {
        this.name = name;
        this.isActive = isActive;
    }


    public void setActive(Boolean active) {
        isActive = active;
    }
}

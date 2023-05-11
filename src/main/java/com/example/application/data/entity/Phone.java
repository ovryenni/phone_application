package com.example.application.data.entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Phone extends AbstractEntity{
    @NotEmpty
    private String code;

    private String name;
    private String category;
    private String brand;
    private String type;
    private String description;

}

package com.petmgmt.PetManagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Table(name="domestic_pet_info")
@Entity
public class DomesticPet extends Pet{
    @Column(name = "date_of_birth",nullable = false)
    private LocalDate birthDate;
}

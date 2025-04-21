//package com.petmgmt.PetManagement.repositry.impl;
//
//import com.petmgmt.PetManagement.entity.DomesticPet;
//import com.petmgmt.PetManagement.entity.Pet;
//import com.petmgmt.PetManagement.repositry.PetRepositry;
//import jakarta.persistence.*;
//import jakarta.transaction.TransactionManager;
//import org.springframework.stereotype.Repository;
//
//import java.time.LocalDate;
//import java.time.Period;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//import java.util.Optional;
//
//@Repository
//public class PetRespositryImpl implements PetRepositry {
//
//    private List<Pet> petDTOList;
//    @PersistenceUnit//primary caache
//    private EntityManagerFactory entityManagerFactory;
//
//    public PetRespositryImpl() {
//        this.petDTOList = new ArrayList<>();
//    }
//
////    @PostConstruct
////    public void init() {
////        DomesticPetDTO domesticPetDTO = new DomesticPetDTO();
////        domesticPetDTO.setId(1);
////        domesticPetDTO.setName("Max");
////        domesticPetDTO.setGender(Gender.M);
////        domesticPetDTO.setType(PetType.DOG);
////        domesticPetDTO.setBirthDate(LocalDate.of(2018, 7, 26));
////        OwnerDTO ownerDTO = new OwnerDTO();
////        ownerDTO.setId(1);
////        ownerDTO.setFirstName("John");
////        ownerDTO.setLastName("Doe");
////        ownerDTO.setGender(Gender.M);
////        ownerDTO.setCity("Hyderabad");
////        ownerDTO.setState("Andhra Pradesh");
////        ownerDTO.setMobileNumber("9009009001");
////        ownerDTO.setEmailId("john.doe@abhishekvermaa10.com");
////        domesticPetDTO.setOwnerDTO(ownerDTO);
////        petDTOList.add(domesticPetDTO);
////        WildPetDTO wildPetDTO = new WildPetDTO();
////        wildPetDTO.setId(2);
////        wildPetDTO.setName("Fluffy");
////        wildPetDTO.setGender(Gender.F);
////        wildPetDTO.setType(PetType.CAT);
////        wildPetDTO.setBirthPlace("Jim Corbett National Park");
////        ownerDTO = new OwnerDTO();
////        ownerDTO.setId(2);
////        ownerDTO.setFirstName("Jane");
////        ownerDTO.setLastName("Smith");
////        ownerDTO.setGender(Gender.F);
////        ownerDTO.setCity("Vishakhapatnam");
////        ownerDTO.setState("Andhra Pradesh");
////        ownerDTO.setMobileNumber("9009009002");
////        ownerDTO.setEmailId("jane.smith@abhishekvermaa10.com");
////        wildPetDTO.setOwnerDTO(ownerDTO);
////        petDTOList.add(wildPetDTO);
////    }
//
//    @Override
//    public Optional<Pet> findById(int petId) {
//        try(EntityManager em = entityManagerFactory.createEntityManager()) {
//            EntityTransaction tr = em.getTransaction();
//            Pet p = em.find(Pet.class,petId);
//            return Optional.ofNullable(p);
//        }
//
//    }
//
////    @Override
////    public Optional<Double> findAverageAgeOfPet() {
////        try(EntityManager em = entityManagerFactory.createEntityManager()){
////            EntityTransaction transaction = em.getTransaction();
////            petDTOList = em.createQuery("from Pet").getResultList();
////        }
////        return petDTOList.stream()
////                .filter(pet -> pet instanceof DomesticPet)
////                .map(pet -> ((DomesticPet) pet).getBirthDate())
////                .mapToDouble(birthDate -> Period.between(birthDate, LocalDate.now()).getYears())
////                .average()
////                .stream()
////                .boxed()
////                .findFirst();
////    }
//}

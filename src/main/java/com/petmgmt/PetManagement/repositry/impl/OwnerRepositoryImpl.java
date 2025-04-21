//package com.petmgmt.PetManagement.repositry.impl;
//
//import com.petmgmt.PetManagement.entity.Owner;
//import com.petmgmt.PetManagement.entity.Pet;
//import com.petmgmt.PetManagement.repositry.OwnerRepository;
//import jakarta.persistence.*;
//import org.hibernate.Hibernate;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Objects;
//import java.util.Optional;
//
//@Repository
//public class OwnerRepositoryImpl implements OwnerRepository {
//    @PersistenceUnit//primary caache
//    private EntityManagerFactory entityManagerFactory;
//
//    @Override
//    public void save(Owner owner) {
//        try(EntityManager em = entityManagerFactory.createEntityManager()){
//            EntityTransaction tr = em.getTransaction();
//            tr.begin();
//            em.persist(owner);
//            tr.commit();
//        }
////        ownerDTOList.add(owner);
//    }
//
//    @Override
//    public Optional<Owner> findById(int ownerId) {
//        try(EntityManager em = entityManagerFactory.createEntityManager()) {
//            Owner owner = em.find(Owner.class, ownerId);
//            if(Objects.nonNull(owner)){
//                Pet pet = Hibernate.unproxy(owner.getPet(), Pet.class);
//                owner.setPet(pet);
//            }
//
//            return Optional.ofNullable(owner);
//        }
//    }
//
//    @Override
//    public void updatePetDetails(int ownerId, String petName) {
//        try(EntityManager em = entityManagerFactory.createEntityManager()) {
//            EntityTransaction tr = em.getTransaction();
//            tr.begin();
//            Owner owner = em.find(Owner.class, ownerId);
//            if (Objects.nonNull(owner)) {
//                owner.getPet().setName(petName);
//            }
//            tr.commit();
//        }
//    }
//
//    @Override
//    public void deleteById(int ownerId) {
//        try(EntityManager em = entityManagerFactory.createEntityManager()) {
//            EntityTransaction tr = em.getTransaction();
//            tr.begin();
//            Owner owner = em.find(Owner.class,ownerId);
//            if(Objects.nonNull(owner)){
//                em.remove(owner);
//            }
//            tr.commit();
//        }
//    }
//
//    @Override
//    public List<Owner> findAll() {
//        String jpql="select o from Owner o join o.pet ";
//        try(EntityManager em = entityManagerFactory.createEntityManager()){
//            return em.createQuery(jpql,Owner.class).getResultList();
//        }    }
//
////    @Override
////    public List<Object[]> findIdAndFirstNameAndLastNameAndPetName(int pageNumber, int pageSize) {
////        String jpql="select id,first_name from owner";
////        try(EntityManager em = entityManagerFactory.createEntityManager()){
////           return em.createQuery(jpql).getResultList();
////        }
////    }
//}

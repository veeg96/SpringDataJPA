package com.petmgmt.PetManagement.service;

import com.petmgmt.PetManagement.dto.OwnerDTO;
import com.petmgmt.PetManagement.exception.DuplicateOwnerIdException;
import com.petmgmt.PetManagement.exception.OwnerNotFoundException;

import java.util.List;

public interface OwnerService {
    void saveOwner(OwnerDTO ownerDTO) throws DuplicateOwnerIdException;

    OwnerDTO findOwner(int ownerId) throws OwnerNotFoundException;

//    void updatePetDetails(int ownerId, String petName) throws OwnerNotFoundException;

    void deleteOwner(int ownerId) throws OwnerNotFoundException;

    List<OwnerDTO> findAllOwners();

//    List<Object[]> findIdAndFirstNameAndLastNameAndPetNameOfPaginatedOwners(int i, int pageSize);

//    List<Object[]> findIdAndFirstNameAndLastNameAndPetNameOfPaginatedOwners(int pageNumber, int numberOfRecordsPerPage);


}

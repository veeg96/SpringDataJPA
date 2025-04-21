package com.petmgmt.PetManagement;

import com.petmgmt.PetManagement.Util.InputUtils;
import com.petmgmt.PetManagement.dto.OwnerDTO;
import com.petmgmt.PetManagement.dto.PetDTO;
import com.petmgmt.PetManagement.service.OwnerService;
import com.petmgmt.PetManagement.service.PetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
@PropertySource("classpath:messages.properties")
public class PetManagementApplication implements CommandLineRunner {
	private final OwnerService ownerService;
	private final PetService petService;

    public PetManagementApplication(OwnerService ownerService, PetService petService) {
        this.ownerService = ownerService;
        this.petService = petService;
    }

    public static void main(String[] args) {
		SpringApplication.run(PetManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try (Scanner scanner = new Scanner(System.in)) {
			do {
				System.out.println("Welcome to Petistaan->");
				OwnerDTO o = new OwnerDTO();
				o.getPetDTO();
				int menuOption = InputUtils.acceptMenuOption(scanner);

				switch (menuOption) {
					case 1:
						OwnerDTO ownerDTO = InputUtils.acceptOwnerDetailsToSave(scanner);
						PetDTO petDTO = InputUtils.acceptPetDetailsToSave(scanner);
						ownerDTO.setPetDTO(petDTO);
						ownerService.saveOwner(ownerDTO);
						System.out.println("Saved owner successfully.");
						break;
					case 2:
						int ownerId = InputUtils.acceptOwnerIdToOperate(scanner);
						ownerDTO = ownerService.findOwner(ownerId);
						System.out.println(String.format("Found owner with ownerId %s.", ownerId));
						System.out.println(ownerDTO);
						break;
//					case 3:
//						ownerId = InputUtils.acceptOwnerIdToOperate(scanner);
//						String petName = InputUtils.acceptPetDetailsToUpdate(scanner);
//						ownerService.updatePetDetails(ownerId, petName);
//						System.out.println(
//								String.format("Updated petName to %s for owner with ownerId %s.", petName, ownerId));
//						break;
					case 4:
						ownerId = InputUtils.acceptOwnerIdToOperate(scanner);
						ownerService.deleteOwner(ownerId);
						System.out.println(String.format("Deleted owner with ownerId %s.", ownerId));
						break;
					case 5:
						List<OwnerDTO> ownerDTOList = ownerService.findAllOwners();
						System.out.println(String.format("There are %s owners.", ownerDTOList.size()));
						ownerDTOList.forEach(System.out::println);
						break;
					case 6:
						int petId = InputUtils.acceptPetIdToOperate(scanner);
						petDTO = petService.findPet(petId);
						System.out.println(String.format("Found pet with petId %s.", petId));
						System.out.println(petDTO);
						break;
//					case 7:
//						double averageAge = petService.findAverageAgeOfPet();
//						System.out.println(String.format("Average age of pet is %s years.", averageAge));
//						break;
//					case 8:
//						int pageNumber = InputUtils.acceptPageNumberToOperate(scanner);
//						int pageSize = InputUtils.acceptPageSizeToOperate(scanner);
//						List<Object[]> detailsList = ownerService
//								.findIdAndFirstNameAndLastNameAndPetNameOfPaginatedOwners(pageNumber - 1, pageSize);
//						System.out.println(
//								String.format("Showing %s records on page number %s.", detailsList.size(), pageNumber));
//						detailsList.forEach(details -> System.out
//								.println(String.format("ownerId: %s, firstName: %s, lastName: %s, petName: %s", details[0],
//										details[1], details[2], details[3])));
//						break;
					default:
						System.out.println("Invalid option entered.");
				}
			} while (InputUtils.wantToContinue(scanner));
		}
	}
}

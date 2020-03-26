package pl.silnepalce.petclinic.bootstrap;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.silnepalce.petclinic.model.*;
import pl.silnepalce.petclinic.services.*;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final PetService petService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, PetService petService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.petService = petService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }


    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if(count == 0){
            loadData();
        }
    }

    private void loadData() {
        System.out.println("Loading start......");

        PetType petType1 = new PetType();
        petType1.setName("Dog");
        PetType dogPetType = petTypeService.save(petType1);

        Owner.builder().address("asd").id(1L).build();

        Owner owner1 = new Owner();
        owner1.setFirstName("Krystian");
        owner1.setLastName("Tokarz");
        owner1.setAddress("Krystian address");
        owner1.setCity("Wrocław");
        owner1.setTelephone("608 343 111");

        Pet mikesPet = new Pet();
        mikesPet.setName("Pet puppy");
        mikesPet.setPetType(dogPetType);
        mikesPet.setBirthDay(LocalDate.now().minusYears(3));
        mikesPet.setOwner(owner1);
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        PetType petType2 = new PetType();
        petType2.setName("Cat");
        PetType catPetType = petTypeService.save(petType2);
        Owner owner2 = new Owner();
        owner2.setFirstName("Kasia");
        owner2.setLastName("Sobierajska");
        owner2.setAddress("Kasia address");
        owner2.setCity("Kielce");
        owner2.setTelephone("123 345 123");

        Pet kasiaPet = new Pet();
        kasiaPet.setName("Kasia puppy");
        kasiaPet.setPetType(catPetType);
        kasiaPet.setBirthDay(LocalDate.now());
        kasiaPet.setOwner(owner2);

        owner2.getPets().add(kasiaPet);

        Visit catVisit = new Visit();
        catVisit.setPet(kasiaPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("First visit");
        ownerService.save(owner2);
        visitService.save(catVisit); //todo maybe add visit to pet ??

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality radiologyWithId = specialtyService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality surgeryWithId = specialtyService.save(surgery);

        Speciality dentist = new Speciality();
        dentist.setDescription("Dentist");
        Speciality dentistWithId = specialtyService.save(dentist);

        Vet vet1 = new Vet();
        vet1.setFirstName("Vet1");
        vet1.setLastName("Vet1LasName");
        vet1.getSpecialities().add(surgeryWithId);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Vet2");
        vet2.setLastName("Vet2LasName");
        vet2.getSpecialities().add(dentistWithId);
        vet2.getSpecialities().add(radiologyWithId);

        vetService.save(vet2);
        System.out.println("Loading end.....");
    }

}

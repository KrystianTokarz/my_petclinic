package pl.silnepalce.petclinic.services;

import pl.silnepalce.petclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findByLastName(String lastName);

    Pet findById(Long id);

    Pet save(Pet Pet);

    Set<Pet> findAll();
}

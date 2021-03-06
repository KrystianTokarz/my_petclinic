package pl.silnepalce.petclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.silnepalce.petclinic.model.Owner;
import pl.silnepalce.petclinic.model.Pet;
import pl.silnepalce.petclinic.services.OwnerService;
import pl.silnepalce.petclinic.services.PetService;
import pl.silnepalce.petclinic.services.PetTypeService;

import java.util.Set;

//todo cascade type
//todo inheritance (join table, blablabla)


@Service
@Profile({"default","map"})
public class OwnerMapService extends AbstractMapService<Owner,Long> implements OwnerService {


    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner obj) {
        super.delete(obj);
    }

    @Override
    public Owner save(Owner obj) {
        if(obj != null ){
            if(obj.getPets() != null){
                obj.getPets().forEach(pet -> {
                    if(pet.getPetType() != null){
                        if(pet.getPetType().getId() == null){
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    }else{
                        throw new RuntimeException("Pet Type is required");
                    }
                    if(pet.getId() == null){
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(obj);
        }else{
            return null;
        }
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return super.map.values()
                .stream()
                .filter(e -> e.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);
    }
}

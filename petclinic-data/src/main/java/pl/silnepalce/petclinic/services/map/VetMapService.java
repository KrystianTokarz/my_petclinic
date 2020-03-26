package pl.silnepalce.petclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.silnepalce.petclinic.model.Speciality;
import pl.silnepalce.petclinic.model.Vet;
import pl.silnepalce.petclinic.services.SpecialtyService;
import pl.silnepalce.petclinic.services.VetService;

import java.util.Set;

@Service
@Profile({"default","map"})
public class VetMapService extends AbstractMapService<Vet,Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetMapService(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet obj) {
        super.delete(obj);
    }

    @Override
    public Vet save(Vet obj) {
        if(obj.getSpecialities().size() > 0){
            obj.getSpecialities().forEach(speciality -> {
                if(speciality.getId() == null){
                    Speciality savedSpeciality = specialtyService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }else{
            return null;
        }
        return super.save(obj);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}

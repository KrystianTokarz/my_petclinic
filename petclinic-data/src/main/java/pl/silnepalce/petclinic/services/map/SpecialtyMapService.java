package pl.silnepalce.petclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.silnepalce.petclinic.model.Speciality;
import pl.silnepalce.petclinic.services.SpecialtyService;

import java.util.Set;

@Service
@Profile({"default","map"})
public class SpecialtyMapService extends AbstractMapService<Speciality,Long> implements SpecialtyService {

    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Speciality obj) {
        super.delete(obj);
    }

    @Override
    public Speciality save(Speciality obj) {
        return super.save(obj);
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }
}

package pl.silnepalce.petclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.silnepalce.petclinic.model.Speciality;
import pl.silnepalce.petclinic.repositories.SpecialityRepository;
import pl.silnepalce.petclinic.services.SpecialtyService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialitySDJpaService implements SpecialtyService {

    private final SpecialityRepository specialityRepository;

    public SpecialitySDJpaService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> pets = new HashSet<>();
        specialityRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Speciality findById(Long id) {
        return specialityRepository.findById(id).orElse(null);
    }

    @Override
    public Speciality save(Speciality obj) {
        return specialityRepository.save(obj);
    }

    @Override
    public void delete(Speciality obj) {
        specialityRepository.delete(obj);
    }

    @Override
    public void deleteById(Long id) {
        specialityRepository.deleteById(id);
    }
}

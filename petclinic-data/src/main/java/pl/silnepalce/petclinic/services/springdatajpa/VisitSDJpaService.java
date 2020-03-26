package pl.silnepalce.petclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.silnepalce.petclinic.model.Visit;
import pl.silnepalce.petclinic.repositories.VisitRepository;
import pl.silnepalce.petclinic.services.VisitService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VisitSDJpaService implements VisitService {

    private final VisitRepository visitRepository;

    public VisitSDJpaService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> vets = new HashSet<>();
        visitRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Visit findById(Long id) {
        return visitRepository.findById(id).orElse(null);
    }

    @Override
    public Visit save(Visit obj) {
        return visitRepository.save(obj);
    }

    @Override
    public void delete(Visit obj) {
        visitRepository.delete(obj);
    }

    @Override
    public void deleteById(Long id) {
        visitRepository.deleteById(id);
    }
}

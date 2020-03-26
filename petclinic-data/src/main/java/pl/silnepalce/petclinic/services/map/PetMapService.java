package pl.silnepalce.petclinic.services.map;

import pl.silnepalce.petclinic.model.Owner;
import pl.silnepalce.petclinic.services.CrudService;

import java.util.Set;

public class OwnerMapService extends AbstractMapService<Owner,Long> implements CrudService<Owner,Long> {
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
        return super.save(obj.getId(),obj);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }
}

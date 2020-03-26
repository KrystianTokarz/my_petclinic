package pl.silnepalce.petclinic.services;

import pl.silnepalce.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}

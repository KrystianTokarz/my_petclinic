package pl.silnepalce.petclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.silnepalce.petclinic.model.Owner;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    public static final long ID = 1L;
    public static final String LAST_NAME = "TEST-LAST-NAME";
    OwnerMapService ownerMapService;


    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(
                new PetTypeMapService(),
                new PetMapService()
        );

        ownerMapService.save(Owner.builder().lastName(LAST_NAME).id(ID).build());
    }

    @Test
    void findAll() {
        Set<Owner> result = ownerMapService.findAll();
        assertEquals(1, result.size());
    }

    @Test
    void findById() {
        Owner byId = ownerMapService.findById(ID);
        assertEquals(ID, byId.getId());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ID);
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ID));
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void saveExistingId() {
        long id = 2L;
        Owner owner2 = ownerMapService.save(Owner.builder().id(id).build());
        assertEquals(id, owner2.getId());
    }

    @Test
    void saveNoId() {
        Owner result = ownerMapService.save(Owner.builder().build());
        assertNotNull(result);
        assertNotNull(result.getId());
    }

    @Test
    void findByLastName() {
        Owner byLastName = ownerMapService.findByLastName(LAST_NAME);
        assertEquals(ID, byLastName.getId());
    }

    @Test
    void findByLastNameNotFound() {
        Owner byLastName = ownerMapService.findByLastName("foo");
        assertNull(byLastName);
    }
}
package pl.silnepalce.petclinic.services.springdatajpa;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.silnepalce.petclinic.model.Owner;
import pl.silnepalce.petclinic.repositories.OwnerRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerSDJpaService sut;

//    @BeforeEach
//    void setUp() {
//        ownerSDJpaService = new OwnerSDJpaService(ownerRepository);
//    }

    @Test
    void findByLastName() {
        System.out.println(sut);

        Owner owne = Owner.builder().id(1L).lastName("Smith").build();
        when(ownerRepository.findByLastName(any())).thenReturn(owne);
        Owner result = sut.findByLastName("Smith");

        assertEquals(owne, result);

        verify(ownerRepository, times(1)).findByLastName(any());
    }

    @Test
    void findAll() {
        System.out.println(sut);
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }
}
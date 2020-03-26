package pl.silnepalce.petclinic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
//implements Serializable

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass //we do not need specific class mapped to table in database -> do not do anything with this class
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}

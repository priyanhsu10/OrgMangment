package education.io.educationapi.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass

public abstract  class CommonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  int id ;
}

package education.io.educationapi.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@MappedSuperclass
public abstract  class CommonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "auto_gen")
    private  int id ;

    public int getId()   {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

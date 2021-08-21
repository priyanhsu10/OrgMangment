package education.io.educationapi.entities.org;

import education.io.educationapi.common.CommonEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name ="tblsubjects",schema = "public")

public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  int id ;

    public int getId()   {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(length = 50)
    @NotNull
    private  String name;

    public Subject() {
    }

    @Column(length = 200)
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

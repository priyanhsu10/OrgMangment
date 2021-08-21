package education.io.educationapi.entities.org;

import education.io.educationapi.common.CommonEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name ="tblclasses",schema = "public")

public class StandardsClass {
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
    @Column(length = 50)
    @NotNull
    private  String name;

    public StandardsClass() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Standard getStandard() {
        return standard;
    }

    public void setStandard(Standard standard) {
        this.standard = standard;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "standardid")
    private  Standard standard ;
}

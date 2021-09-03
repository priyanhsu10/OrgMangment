package education.io.educationapi.entities.org;

import education.io.educationapi.common.CommonEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity
@Table(name ="tblstandards",schema = "public")
public class Standard   {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  int id ;

    public int getId()   {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public Standard() {
    }

    @Column(length = 50,unique = true)
    @NotNull
    private  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Collection<Subject> subjects) {
        this.subjects = subjects;
    }

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable (name = "lnkstandardsubject",schema = "public",
            joinColumns = @JoinColumn(name = "standardid"),
            inverseJoinColumns = @JoinColumn(name = "subjectid"))
    private Collection<Subject> subjects;
}

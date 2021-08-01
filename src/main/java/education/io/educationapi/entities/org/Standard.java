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
public class Standard  extends CommonEntity {
    public Standard() {
    }

    @Column(length = 50)
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

    @OneToMany
    @JoinTable (name = "lnkstandardsubject",schema = "public",
            joinColumns = @JoinColumn(name = "standardid"),
            inverseJoinColumns = @JoinColumn(name = "subjectid"))
    private Collection<Subject> subjects;
}

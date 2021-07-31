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
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Standard  extends CommonEntity {
    @Column(length = 50)
    @NotNull
    private  String name;
    @OneToMany
    @JoinTable (name = "lnkstandardsubject",schema = "public",
            joinColumns = @JoinColumn(name = "standardid"),
            inverseJoinColumns = @JoinColumn(name = "subjectid"))
    private Collection<Subject> subjects;
}

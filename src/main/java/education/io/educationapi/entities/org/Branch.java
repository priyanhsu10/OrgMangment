package education.io.educationapi.entities.org;

import education.io.educationapi.common.CommonEntity;
import education.io.educationapi.entities.org.Organization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tblbraches",schema = "public")
public class Branch extends CommonEntity {
    @NotNull
    private String name;
    @Column(length = 200)
    private String description;
    @ManyToOne
    @JoinColumn(name = "organizationid")
    private Organization organization;
}

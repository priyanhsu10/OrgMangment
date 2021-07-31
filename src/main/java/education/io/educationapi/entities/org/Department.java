package education.io.educationapi.entities.org;

import education.io.educationapi.common.CommonEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name ="tbldepartments",schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department extends CommonEntity {
    @NotNull
    private String name;
    @Column(length = 200)
    private String description;
    @ManyToOne
    @JoinColumn(name = "branchid")
    private Branch branch;
    @ManyToOne
    @JoinColumn(name = "organizationid")
    private Organization organization;
}

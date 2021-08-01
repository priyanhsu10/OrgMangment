package education.io.educationapi.entities.org;

import education.io.educationapi.common.CommonEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name ="tbldepartments",schema = "public")
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

    public Department(String name, String description, Branch branch, Organization organization) {
        this.name = name;
        this.description = description;
        this.branch = branch;
        this.organization = organization;
    }

    public Department() {
    }

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

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}

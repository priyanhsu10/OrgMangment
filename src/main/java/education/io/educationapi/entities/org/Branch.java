package education.io.educationapi.entities.org;

import education.io.educationapi.common.CommonEntity;
import education.io.educationapi.entities.org.Organization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tblbraches",schema = "public")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  int id ;

    public int getId()   {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @NotNull
    private String name;
    @Column(length = 200)
    private String description;

    public Branch() {
    }

    public Branch(String name, String description, Organization organization) {
        this.name = name;
        this.description = description;
        this.organization = organization;
    }

    @ManyToOne
    @JoinColumn(name = "organizationid",referencedColumnName ="id")
    private Organization organization;

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

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}

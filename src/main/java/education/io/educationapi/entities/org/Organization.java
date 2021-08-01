package education.io.educationapi.entities.org;

import education.io.educationapi.common.CommonEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tblorganizations", schema = "public")

public class Organization extends CommonEntity {
    @Column(length = 100)
    @NotNull
    private String name;
    @Column(length = 200)
    private String description;
    @Column(length = 400)
    private String address;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Organization() {
    }

    public Organization(String name, String description, String address) {
        this.name = name;
        this.description = description;
        this.address = address;
    }
}

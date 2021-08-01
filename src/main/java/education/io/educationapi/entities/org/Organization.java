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

    public Organization() {
    }

    public Organization(String name, String description, String address) {
        this.name = name;
        this.description = description;
        this.address = address;
    }
}
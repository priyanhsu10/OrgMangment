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
@Table(name ="tblsubjects",schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subject extends CommonEntity {
    @Column(length = 50)
    @NotNull
    private  String name;
    @Column(length = 200)
    private String description;
}

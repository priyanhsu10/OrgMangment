package education.io.educationapi.entities.org;

import education.io.educationapi.common.CommonEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name ="tblclasses",schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StandardsClass extends CommonEntity {
    @Column(length = 50)
    @NotNull
    private  String name;
    @ManyToOne
    @JoinColumn(name = "standardid")
    private  Standard standard ;
}

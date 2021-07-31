package education.io.educationapi.entities.infra;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "tblrolepermisions", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
public class RolePermission {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name = "name", length = 50)
    @NotNull
    private String name;
    @OneToOne
    @JoinColumn(name = "roleid")
    private Role role;
}

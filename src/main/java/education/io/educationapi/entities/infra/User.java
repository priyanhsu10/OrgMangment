package education.io.educationapi.entities.infra;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity
@Table(name = "tblusers", schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;
    @Column(name = "name", length = 50)
    String name;
    @NotNull
    @Column(name = "username", length = 30)
    String userName;
    @NotNull
    @Column(name = "password", length = 30)
    String password;
    @NotNull
    @Email
    @Column(name = "email", length = 50)
    String email;
    @OneToMany
    @JoinTable(name = "tbluserroles",schema = "public" ,
            joinColumns = @JoinColumn(name = "userid"),inverseJoinColumns = @JoinColumn(name =  "roleid" ))
    Collection<Role> roles;
}

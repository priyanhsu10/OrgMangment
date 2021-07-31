package education.io.educationapi.entities.org;

import education.io.educationapi.common.CommonConstants;
import education.io.educationapi.common.CommonEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name ="tblstudents",schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Students extends CommonEntity {
    @Column(length = 50)
    @NotNull
    private String firstName;
    @Column(length = 50)
    private String  middleName;
    @Column(length = 50)
    @NotNull
    private String lastName;
    private long salary;
    private String  address ;
    @NotNull
    private Date birthdate;
    private int age;
    private  int gender= CommonConstants.Gender.MALE;
    @ManyToOne
    @JoinColumn(name ="currentstandardid" )
    private  Standard standard ;
    @ManyToOne
    @JoinColumn(name ="currentclassId" )
    private  StandardsClass standardsClass;
    @ManyToOne
    @JoinColumn(name ="organizationId" )
    private  Organization organization;
}

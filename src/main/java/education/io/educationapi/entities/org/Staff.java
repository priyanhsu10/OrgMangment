package education.io.educationapi.entities.org;

import education.io.educationapi.common.CommonConstants;
import education.io.educationapi.common.CommonEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.Collection;


@Entity
@Table(name ="tblstaffs",schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Staff extends CommonEntity {
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
    private  Date birthdate;
    private int age;
    private  int staffType= CommonConstants.StaffType.TEACHER;
    private  int gender= CommonConstants.Gender.MALE;
    @ManyToOne
    @JoinColumn(name = "departmentid")
    private  Department department;
    @ManyToOne
    @JoinColumn(name = "organizationId")
    private  Organization organization;
    @ManyToMany
    @JoinTable(name = "lnkstaffsubjects", schema = "public",joinColumns = @JoinColumn(name ="staffid" ),inverseJoinColumns = @JoinColumn(name = "subjectid"))
 private Collection<Subject> subjects;
}

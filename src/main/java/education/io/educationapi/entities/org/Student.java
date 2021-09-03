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

public class Student  {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  int id ;

    public int getId()   {
        return id;
    }
    @Column(length = 50)
    @NotNull
    private String firstName;
    @Column(length = 50)
    private String  middleName;

    @Column(length = 50)
    @NotNull
    private String lastName;
    private String  address ;
    @NotNull
    private Date birthdate;
    private int age;
    private  int gender= CommonConstants.Gender.MALE;
    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name ="currentstandardid",referencedColumnName = "id")
    private  Standard standard ;
    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name ="currentclassId",referencedColumnName = "id" )
    private  StandardsClass standardsClass;
    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name ="organizationId",referencedColumnName = "id" )
    private  Organization organization;

    public Student() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Standard getStandard() {
        return standard;
    }

    public void setStandard(Standard standard) {
        this.standard = standard;
    }

    public StandardsClass getStandardsClass() {
        return standardsClass;
    }

    public void setStandardsClass(StandardsClass standardsClass) {
        this.standardsClass = standardsClass;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

}

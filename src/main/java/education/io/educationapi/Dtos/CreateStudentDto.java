package education.io.educationapi.Dtos;

import education.io.educationapi.common.CommonConstants;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

public class CreateStudentDto {
    @Size(max = 50)
    @NotNull
    private String firstName;
    @Size(max = 50)
    private String  middleName;
    @Size(max = 50)
    @NotNull
    private String lastName;
    private String  address ;
    @NotNull
    private Date birthdate;
    private int age;

    private  int gender= CommonConstants.Gender.MALE;
    @NotNull
    private int standardId ;
    @NotNull
    private int standardsClassId;
    @NotNull

    private int organizationId;

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

    public int getStandardId() {
        return standardId;
    }

    public void setStandardId(int standardId) {
        this.standardId = standardId;
    }

    public int getStandardsClassId() {
        return standardsClassId;
    }

    public void setStandardsClassId(int standardsClassId) {
        this.standardsClassId = standardsClassId;
    }

    public int getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }
}

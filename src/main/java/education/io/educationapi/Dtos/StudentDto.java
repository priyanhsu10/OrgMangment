package education.io.educationapi.Dtos;

import java.sql.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import education.io.educationapi.common.CommonConstants;
import education.io.educationapi.common.CommonEntityDto;

public class StudentDto extends CommonEntityDto {
    @Size(max = 50)
    @NotNull
    private String firstName;

    @Size(max = 50)
    private String middleName;
    @Size(max = 50)
    @NotNull
    private String lastName;
    private long salary;
    private String address;
    @NotNull
    private Date birthdate;
    private int age;
    private int gender = CommonConstants.Gender.MALE;
    private StandardDto standard;
    private StandardsClassDto standardsClass;
    private OrganizationDto organization;

    public StudentDto() {
    }

    public StudentDto(String firstName, String middleName, String lastName, String address, Date birthdate, int age,
            int gender, StandardDto standard, StandardsClassDto standardsClass, OrganizationDto organization) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.address = address;
        this.birthdate = birthdate;
        this.age = age;
        this.gender = gender;
        this.standard = standard;
        this.standardsClass = standardsClass;
        this.organization = organization;
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

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
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

    public StandardDto getStandard() {
        return standard;
    }

    public void setStandard(StandardDto standard) {
        this.standard = standard;
    }

    public StandardsClassDto getStandardsClass() {
        return standardsClass;
    }

    public void setStandardsClass(StandardsClassDto standardsClass) {
        this.standardsClass = standardsClass;
    }

    public OrganizationDto getOrganization() {
        return organization;
    }

    public void setOrganization(OrganizationDto organization) {
        this.organization = organization;
    }
}

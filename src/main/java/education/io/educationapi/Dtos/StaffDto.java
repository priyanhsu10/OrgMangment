package education.io.educationapi.Dtos;

import education.io.educationapi.common.CommonEntityDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.Collection;



public class StaffDto extends CommonEntityDto {
    @Size(max = 50)
    @NotNull
    private String firstName;
    @Column(length = 50)
    private String middleName;

    public StaffDto() {
    }

    @Size(max = 50)
    @NotNull
    private String lastName;
    private long salary;

    public StaffDto(String firstName, String middleName, String lastName, long salary, String address, Date birthdate, int age, int staffType, int gender, DepartmentDto department, OrganizationDto organization, Collection<SubjectDto> subjects) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.salary = salary;
        this.address = address;
        this.birthdate = birthdate;
        this.age = age;
        this.staffType = staffType;
        this.gender = gender;
        this.department = department;
        this.organization = organization;
        this.subjects = subjects;
    }

    private String address;

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

    public int getStaffType() {
        return staffType;
    }

    public void setStaffType(int staffType) {
        this.staffType = staffType;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public DepartmentDto getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDto department) {
        this.department = department;
    }

    public OrganizationDto getOrganization() {
        return organization;
    }

    public void setOrganization(OrganizationDto organization) {
        this.organization = organization;
    }

    public Collection<SubjectDto> getSubjects() {
        return subjects;
    }

    public void setSubjects(Collection<SubjectDto> subjects) {
        this.subjects = subjects;
    }

    @NotNull
    private Date birthdate;
    private int age;
    private int staffType;
    private int gender;

    private DepartmentDto department;
    private OrganizationDto organization;
    private Collection<SubjectDto> subjects;
}

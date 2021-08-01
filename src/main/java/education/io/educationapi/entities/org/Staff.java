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
public class Staff extends CommonEntity {
    @Column(length = 50)
    @NotNull
   private String firstName;

 public Staff() {
 }

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

 public Department getDepartment() {
  return department;
 }

 public void setDepartment(Department department) {
  this.department = department;
 }

 public Organization getOrganization() {
  return organization;
 }

 public void setOrganization(Organization organization) {
  this.organization = organization;
 }

 public Collection<Subject> getSubjects() {
  return subjects;
 }

 public void setSubjects(Collection<Subject> subjects) {
  this.subjects = subjects;
 }

 @ManyToOne
    @JoinColumn(name = "organizationId")
    private  Organization organization;
    @ManyToMany
    @JoinTable(name = "lnkstaffsubjects", schema = "public",joinColumns = @JoinColumn(name ="staffid" ),inverseJoinColumns = @JoinColumn(name = "subjectid"))
 private Collection<Subject> subjects;
}

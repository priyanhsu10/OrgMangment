package education.io.educationapi.mappers;

import education.io.educationapi.Dtos.*;
import education.io.educationapi.entities.org.*;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IMapper {
    OrganizationDto organizationToOrganizationDto(Organization organization);
    Organization  organizationDtoToOrganization(OrganizationDto organization);
    List<OrganizationDto>  organizationToOrganizationDto(Iterable<Organization> organizationList);

    BranchDto toBranchDto(Branch branch);
    Branch toBranch( BranchDto branchDto);
    List<BranchDto> toBranchDto(List<Branch> BranchList);

    StandardDto standardToStandardDto( Standard standard);
    Standard  standardDtoToStandard( StandardDto standardDto);
    List<StandardDto> standardsToStandardDto(Iterable<Standard> list);

    StandardsClassDto standardsClassToStandardsClassDto( StandardsClass standardsClass);
    StandardsClass  standardDtoClassToStandardsClass( StandardsClassDto standardsClassDto);
    List<StandardsClassDto> StandardsClassToStandardsClassDto(Iterable<StandardsClass> list);

    DepartmentDto departmentToDepartmentDto(Department department);
    Department  toDepartment(DepartmentDto departmentDto);
    List<DepartmentDto> departmentToDepartmentDto(Iterable<Department> departmentList);

    SubjectDto subjectToSubjectDto(Subject subject);
    Subject subjectDtoToSubject(SubjectDto subjectDto);
    List<SubjectDto> subjectsToSubjectDto(Iterable<Subject> departmentList);

    StaffDto staffToStaffDto( Staff staff);
    List<StaffDto> staffToStaffDto(Iterable<Staff> list);

    StudentDto studentToStudentDto(Student student);
    List<StudentDto> studentsToStudentDto(List<Student> students);
    //Page<StudentDto> pageStudentToPageStudentDot(Page<Student>  students);
}
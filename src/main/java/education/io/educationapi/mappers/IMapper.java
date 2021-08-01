package education.io.educationapi.mappers;

import education.io.educationapi.Dtos.*;
import education.io.educationapi.domain.services.org.OrganizationDomainService;
import education.io.educationapi.entities.org.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IMapper {
    OrganizationDto organizationToOrganizationDto(Organization organization);
    Organization  organizationDtoToOrganization(OrganizationDto organization);
    List<OrganizationDto>  organizationToOrganizationDto(Iterable<Organization> organizationList);

    BranchDto branchToBranchDto(Branch organization);
    List<BranchDto> toBranchDto(List<BranchDto> BranchList);

    StandardDto standardToStandardDto( Standard standard);
    List<StandardDto> standardsToStandardDto(Iterable<Standard> list);

    StandardsClassDto standardsClassToStandardsClassDto( StandardsClass standardsClass);
    List<StandardsClassDto> StandardsClassToStandardsClassDto(Iterable<StandardsClass> list);

    DepartmentDto departmentToDepartmentDto(Department department);
    List<DepartmentDto> departmentToDepartmentDto(Iterable<Department> departmentList);

    SubjectDto subjectToSubjectDto(Subject subject);
    List<SubjectDto> subjectsToSubjectDto(Iterable<Subject> departmentList);

    StaffDto staffToStaffDto( Staff staff);
    List<StaffDto> staffToStaffDto(Iterable<Staff> list);

    StudentDto subjectToStudentDto(Student student);
    List<StudentDto> studentsToStudentDto(Iterable<Student> students);
}
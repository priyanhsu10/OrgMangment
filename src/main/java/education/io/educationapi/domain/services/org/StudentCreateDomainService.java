package education.io.educationapi.domain.services.org;

import education.io.educationapi.Dtos.CreateStudentDto;
import education.io.educationapi.Dtos.StudentDto;
import education.io.educationapi.domain.interfaces.org.IStudentCreateDomainService;
import education.io.educationapi.entities.org.Student;
import education.io.educationapi.mappers.IMapper;
import education.io.educationapi.repositories.org.OrganizationRepository;
import education.io.educationapi.repositories.org.StandardClassRepository;
import education.io.educationapi.repositories.org.StandardRepository;
import education.io.educationapi.repositories.org.StudentRepository;
import org.springframework.beans.BeanUtils;

import java.util.concurrent.CompletableFuture;

public class StudentCreateDomainService implements IStudentCreateDomainService
{
    private final StudentRepository studentRepository;
    private final OrganizationRepository organizationRepository;
    private final StandardClassRepository standardClassRepository;
    private final StandardRepository standardRepository;
    private final IMapper mapper;

    public StudentCreateDomainService(StudentRepository studentRepository,
                                      OrganizationRepository organizationRepository,
                                      StandardClassRepository standardClassRepository,
                                      StandardRepository standardRepository,
                                      IMapper mapper) {
        this.studentRepository = studentRepository;
        this.organizationRepository = organizationRepository;
        this.standardClassRepository = standardClassRepository;
        this.standardRepository = standardRepository;
        this.mapper = mapper;
    }

    @Override
    public CompletableFuture<StudentDto> create(CreateStudentDto dto) {

       return CompletableFuture.supplyAsync(()->organizationRepository.existsById(dto.getOrganizationId()))
                .thenApply(isOrgExist->{
                   if( !isOrgExist){
                       throw new RuntimeException("InvalidOrganizationId");
                   }
                   return standardRepository.existsById(dto.getStandardId());
                })
                .thenApply(isStandardExist->{
                    if( !isStandardExist){
                        throw new RuntimeException("InvalidStandardId");
                    }
                    return standardClassRepository.existsById(dto.getStandardsClassId());
                })
                .thenApply(isClassExist->{
                    if( !isClassExist){
                        throw new RuntimeException("InvalidClassId");
                    }
                    //create student
                    Student student =new Student();
                    BeanUtils.copyProperties(dto,student);
                    student.setOrganization(organizationRepository.getById(dto.getOrganizationId()));
                    student.setStandardsClass(standardClassRepository.getById(dto.getStandardsClassId()));
                    student.setStandard(standardRepository.getById(dto.getStandardId()));
                    return studentRepository.save(student);
                }).thenApply(x->mapper.studentToStudentDto(x));

    }
}

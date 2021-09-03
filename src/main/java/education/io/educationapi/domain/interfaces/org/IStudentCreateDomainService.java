package education.io.educationapi.domain.interfaces.org;

import education.io.educationapi.Dtos.CreateStudentDto;
import education.io.educationapi.Dtos.StudentDto;

import java.util.concurrent.CompletableFuture;

public interface IStudentCreateDomainService {

    CompletableFuture<StudentDto> create(CreateStudentDto dto);

}

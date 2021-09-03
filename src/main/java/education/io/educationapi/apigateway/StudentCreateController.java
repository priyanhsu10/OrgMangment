package education.io.educationapi.apigateway;

import education.io.educationapi.Dtos.CreateStudentDto;
import education.io.educationapi.Dtos.StudentDto;
import education.io.educationapi.domain.interfaces.org.IStudentCreateDomainService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.concurrent.CompletableFuture;

@RequestMapping("/api/students/")
public class StudentCreateController {
    private final IStudentCreateDomainService iStudentCreateDomainService;

    public StudentCreateController(IStudentCreateDomainService iStudentCreateDomainService) {
        this.iStudentCreateDomainService = iStudentCreateDomainService;
    }
@PostMapping
    public CompletableFuture<ResponseEntity<StudentDto>> CreateStudent(@Valid @RequestBody CreateStudentDto createStudentDto){
        return iStudentCreateDomainService.create(createStudentDto).thenApply(x->ResponseEntity.ok(x));
    }
}

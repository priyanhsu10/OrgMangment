package education.io.educationapi.apigateway;

import education.io.educationapi.Dtos.StudentDto;
import education.io.educationapi.domain.interfaces.org.IStudentDomainService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/students")

public class StudentController {

    private final IStudentDomainService iStudentDomainService;

    public StudentController(IStudentDomainService iStudentDomainService) {
        this.iStudentDomainService = iStudentDomainService;
    }

    @GetMapping("/organization/{orgId}")
    public CompletableFuture<ResponseEntity<List<StudentDto>>> getByOrganizationId(int orgId) {

        return iStudentDomainService.getByOrganizationId(orgId).thenApply(x-> ResponseEntity.ok().body(x));
    }

    @GetMapping("/class/{classId}")
    public CompletableFuture<ResponseEntity<List<StudentDto>>> getByClassId(int classId) {
        return iStudentDomainService.getByClassId(classId).thenApply(x-> ResponseEntity.ok().body(x));
    }

    @GetMapping("/standard/{standardId}")
    public CompletableFuture<ResponseEntity<List<StudentDto>>> getByStandardId(@PathVariable int standardId) {
        return iStudentDomainService.getByStandardId(standardId).thenApply(x-> ResponseEntity.ok().body(x));
    }

    @GetMapping("/")
    public CompletableFuture<ResponseEntity<Page<StudentDto>>> getAll(@RequestParam Optional<Integer> page,
                                                    @RequestParam Optional<String> sortBy) {
        PageRequest p = PageRequest
                .of(page.orElse(0), 10,
                        Sort.by(Sort.Direction.ASC, sortBy.orElse("name")));
        return iStudentDomainService.getAll(p).thenApply(x-> ResponseEntity.ok().body(x));
    }

    @GetMapping("/organization/{orgId}//count")
    public CompletableFuture<ResponseEntity<Integer>> getCountByOrganizationId(@PathVariable int orgId) {
        return iStudentDomainService.getCountByOrganizationId(orgId).thenApply(x-> ResponseEntity.ok().body(x));
    }

    @GetMapping("/standard/{standardId}/count")
    public CompletableFuture<ResponseEntity<Integer>> getCountByStandardId(@PathVariable int standardId) {
        return iStudentDomainService.getCountByStandardId(standardId).thenApply(x-> ResponseEntity.ok().body(x));
    }

    @GetMapping("/class/{classId}/count")
    public CompletableFuture<ResponseEntity<Integer>> getCountByClassId(@PathVariable int classId) {
        return iStudentDomainService.getCountByClassId(classId).thenApply(x-> ResponseEntity.ok().body(x));
    }

}

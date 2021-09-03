package education.io.educationapi.domain.services.org;

import education.io.educationapi.Dtos.StudentDto;
import education.io.educationapi.domain.interfaces.org.IStudentDomainService;
import education.io.educationapi.mappers.IMapper;
import education.io.educationapi.repositories.org.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class StudentDomainService implements IStudentDomainService {
    private final StudentRepository repository;
    private final IMapper mapper;

    public StudentDomainService(StudentRepository repository, IMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public CompletableFuture<List<StudentDto>> getByOrganizationId(int orgId) {
        return CompletableFuture.supplyAsync(() -> repository.getByOrganizationId(orgId))
                .thenApply(x -> mapper.studentsToStudentDto(x));
    }

    @Override
    public CompletableFuture<List<StudentDto>> getByClassId(int classId) {

        return CompletableFuture.supplyAsync(() -> repository.getByClassId(classId))
                .thenApply(x -> mapper.studentsToStudentDto(x));
    }

    @Override
    public CompletableFuture<List<StudentDto>> getByStandardId(int standardId) {
        return CompletableFuture.supplyAsync(() -> repository.getByStandardId(standardId))
                .thenApply(x -> mapper.studentsToStudentDto(x));
    }

    @Override
    public CompletableFuture<Page<StudentDto>> getAll(PageRequest p) {
        return CompletableFuture.supplyAsync(() -> repository.findAll(p))
                .thenApply(x -> x.map(std->mapper.studentToStudentDto(std)));

    }

    @Override
    public CompletableFuture<Integer> getCountByOrganizationId(int orgId) {
        return CompletableFuture.supplyAsync(() -> repository.getCountByOrganizationId(orgId)).thenApply(x -> x);
    }

    @Override
    public CompletableFuture<Integer> getCountByStandardId(int standardId) {
        return CompletableFuture.supplyAsync(() -> repository.getCountByStandardId(standardId)).thenApply(x -> x);
    }

    @Override
    public CompletableFuture<Integer> getCountByClassId(int classId) {
        return CompletableFuture.supplyAsync(() -> repository.getCountByClassId(classId)).thenApply(x -> x);
    }


}

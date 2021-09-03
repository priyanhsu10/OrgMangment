package education.io.educationapi.domain.interfaces.org;

import education.io.educationapi.Dtos.StudentDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public interface IStudentDomainService {
    CompletableFuture<List<StudentDto>> getByOrganizationId(int orgId);

    CompletableFuture<List<StudentDto>> getByClassId(int classId);

    CompletableFuture<List<StudentDto>> getByStandardId(int standardId);

    CompletableFuture<Page<StudentDto>> getAll(PageRequest p);

    CompletableFuture<Integer> getCountByOrganizationId(int orgId);

    CompletableFuture<Integer> getCountByStandardId(int standardId);

    CompletableFuture<Integer> getCountByClassId(int classId);


}

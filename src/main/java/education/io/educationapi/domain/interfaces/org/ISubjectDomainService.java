package education.io.educationapi.domain.interfaces.org;

import education.io.educationapi.Dtos.SubjectDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public interface ISubjectDomainService {
    CompletableFuture<List<SubjectDto>> getAll();

    CompletableFuture<SubjectDto> getById(int id);

    CompletableFuture<SubjectDto> create(SubjectDto subjectDto);

    CompletableFuture<SubjectDto> update(int id, SubjectDto subjectDto);
}

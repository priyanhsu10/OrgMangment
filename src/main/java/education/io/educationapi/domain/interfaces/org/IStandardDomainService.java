package education.io.educationapi.domain.interfaces.org;

import education.io.educationapi.Dtos.StandardDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public interface IStandardDomainService {
   CompletableFuture< List<StandardDto>> getAll();

    CompletableFuture<StandardDto> getById(int id);

    CompletableFuture<StandardDto> create(StandardDto standardsClassDto);

    CompletableFuture<StandardDto> update(int id, StandardDto subjectDto);

    CompletableFuture<StandardDto> addSubjects(int id, List<Integer> subjectIds);
}

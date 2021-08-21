package education.io.educationapi.domain.interfaces.org;

import education.io.educationapi.Dtos.StandardsClassDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public interface IStandardClassDomainService {
   CompletableFuture< StandardsClassDto> getById(int standardId, int id);

    CompletableFuture< StandardsClassDto> create(int standardId, StandardsClassDto standardDto);

    CompletableFuture< StandardsClassDto> update(int id, int standardId, StandardsClassDto standardDto);

    CompletableFuture<List<StandardsClassDto>> getAll(int standardId);
}

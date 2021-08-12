package education.io.educationapi.domain.interfaces.org;

import education.io.educationapi.Dtos.StandardsClassDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IStandardClassDomainService {
    StandardsClassDto getById(int standardId, int id);

    StandardsClassDto create(int standardId, StandardsClassDto standardDto);

    StandardsClassDto update(int id, int standardId, StandardsClassDto standardDto);

    List<StandardsClassDto> getAll(int standardId);
}

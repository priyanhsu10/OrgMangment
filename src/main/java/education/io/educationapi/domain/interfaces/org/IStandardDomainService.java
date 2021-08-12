package education.io.educationapi.domain.interfaces.org;

import education.io.educationapi.Dtos.StandardDto;
import education.io.educationapi.Dtos.StandardsClassDto;
import education.io.educationapi.Dtos.SubjectDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IStandardDomainService {
    List<StandardDto> getAll();

    StandardDto getById(int id);

    StandardDto create(StandardDto standardsClassDto);

    StandardDto update(int id, StandardDto subjectDto);
}

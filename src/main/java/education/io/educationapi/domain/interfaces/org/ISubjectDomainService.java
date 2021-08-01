package education.io.educationapi.domain.interfaces.org;

import education.io.educationapi.Dtos.SubjectDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ISubjectDomainService {
    List<SubjectDto> getAll();

    SubjectDto getById(int id);

    SubjectDto create(SubjectDto subjectDto);

    SubjectDto update(int id, SubjectDto subjectDto);
}

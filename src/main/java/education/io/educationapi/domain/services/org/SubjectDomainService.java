package education.io.educationapi.domain.services.org;

import education.io.educationapi.Dtos.SubjectDto;
import education.io.educationapi.domain.interfaces.org.ISubjectDomainService;
import education.io.educationapi.entities.org.Subject;
import education.io.educationapi.mappers.IMapper;
import education.io.educationapi.repositories.org.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectDomainService implements ISubjectDomainService {
    private final SubjectRepository _subjectRepository;
    private final IMapper mapper;

    public SubjectDomainService(SubjectRepository subjectRepository, IMapper iMapper ) {
        _subjectRepository = subjectRepository;
        this.mapper = iMapper;
    }

    @Override
    public List<SubjectDto> getAll() {
       return  mapper.subjectsToSubjectDto(_subjectRepository.findAll());
    }

    @Override
    public SubjectDto getById(int id) {
        Subject subject= _subjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OrganizationNotFound"));
        return  mapper.subjectToSubjectDto(subject);
    }

    @Override
    public SubjectDto create(SubjectDto subjectDto) {
        return mapper.subjectToSubjectDto(_subjectRepository.save( mapper.subjectDtoToSubject(subjectDto)));
    }

    @Override
    public SubjectDto update(int id, SubjectDto subjectDto) {
        Subject subject = _subjectRepository.findById(id).orElseThrow(() -> new RuntimeException("OrganizationNotFound"));

        subject.setDescription(subjectDto.getDescription());
        subject.setName(subjectDto.getName());
        return mapper.subjectToSubjectDto(_subjectRepository.save(subject));
    }
}

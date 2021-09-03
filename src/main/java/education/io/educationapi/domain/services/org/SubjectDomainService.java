package education.io.educationapi.domain.services.org;

import education.io.educationapi.Dtos.SubjectDto;
import education.io.educationapi.domain.interfaces.org.ISubjectDomainService;
import education.io.educationapi.entities.org.Subject;
import education.io.educationapi.mappers.IMapper;
import education.io.educationapi.repositories.org.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class SubjectDomainService implements ISubjectDomainService {
    private final SubjectRepository _subjectRepository;
    private final IMapper mapper;

    public SubjectDomainService(SubjectRepository subjectRepository, IMapper iMapper ) {
        _subjectRepository = subjectRepository;
        this.mapper = iMapper;
    }

    @Override
    public CompletableFuture<List<SubjectDto>>  getAll() {
        return  CompletableFuture.supplyAsync(_subjectRepository::findAll)
                .thenApply(mapper::subjectsToSubjectDto);
    }

    @Override
    public CompletableFuture<SubjectDto> getById(int id) {
        return  CompletableFuture.supplyAsync(()->
                _subjectRepository.findById(id).orElseThrow(()->new RuntimeException("OrganizationNotFound")))
                .thenApply(mapper::subjectToSubjectDto);
    }

    @Override
    public CompletableFuture< SubjectDto> create(SubjectDto subjectDto) {
        return  CompletableFuture.supplyAsync(()->
                _subjectRepository.save( mapper.subjectDtoToSubject(subjectDto)))
                .thenApply(mapper::subjectToSubjectDto);
    }

    @Override
    public CompletableFuture<SubjectDto> update(int id, SubjectDto subjectDto) {

        return  CompletableFuture.supplyAsync(()->
                        _subjectRepository.findById(id).orElseThrow(()->new RuntimeException("OrganizationNotFound")))
                .thenApply(subject->{
                    subject.setDescription(subjectDto.getDescription());
                    subject.setName(subjectDto.getName());
                   return  _subjectRepository.save(subject);
                })
                .thenApply(mapper::subjectToSubjectDto);

    }
}

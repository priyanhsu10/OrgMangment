package education.io.educationapi.domain.services.org;

import education.io.educationapi.Dtos.StandardsClassDto;
import education.io.educationapi.domain.interfaces.org.IStandardClassDomainService;
import education.io.educationapi.entities.org.Standard;
import education.io.educationapi.entities.org.StandardsClass;
import education.io.educationapi.mappers.IMapper;
import education.io.educationapi.repositories.org.StandardClassRepository;
import education.io.educationapi.repositories.org.StandardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

@Service
public class StandardClassDomainService implements IStandardClassDomainService {
    private StandardClassRepository _standardClassRepository;
    private StandardRepository _iStandardRepository;
    private IMapper _mapper;

    public StandardClassDomainService(StandardClassRepository standardClassRepository,
                                      StandardRepository standardRepository, IMapper mapper) {
        _standardClassRepository = standardClassRepository;
        this._iStandardRepository = standardRepository;
        _mapper = mapper;
    }

    @Override
    public CompletableFuture<StandardsClassDto> getById(int standardId, int id) {
        return CompletableFuture.supplyAsync(() -> _standardClassRepository.findByStandardIdAndId(standardId, id)
                        .orElseThrow(() -> new RuntimeException("StandardNotFound")))
                .thenApply((standardsClass) -> _mapper.standardsClassToStandardsClassDto(standardsClass));

    }

    @Override
    public CompletableFuture<StandardsClassDto> create(int standardId, StandardsClassDto standardDto) {
        return CompletableFuture.supplyAsync(() ->  _iStandardRepository.findById(standardId).orElseThrow(()->new RuntimeException("StandardNotFound")))
                .thenApply(x -> createClass(standardDto, x))
                .thenApply(x -> _mapper.standardsClassToStandardsClassDto(x));
    }

    private StandardsClass createClass(StandardsClassDto standardDto, Standard x) {
        StandardsClass standardsClass = _mapper.standardDtoClassToStandardsClass(standardDto);
        standardsClass.setStandard(x);
        return _standardClassRepository.save(standardsClass);
    }

    @Override
    public CompletableFuture<StandardsClassDto> update(int id, int standardId, StandardsClassDto standardDto) {
        return CompletableFuture.supplyAsync(() -> {
            return _iStandardRepository.existsById(standardId);
        }).thenApply(x -> _standardClassRepository.findById(id).orElseThrow(() -> new RuntimeException("StandardNotFound"))
        ).thenApply(save(standardDto)).thenApply(x -> _mapper.standardsClassToStandardsClassDto(x));
    }

    private Function<StandardsClass, StandardsClass> save(StandardsClassDto standardDto) {
        return x -> {
            x.setName(standardDto.getName());
            return _standardClassRepository.save(x);
        };
    }


    @Override
    public CompletableFuture<List<StandardsClassDto>> getAll(int standardId) {
        return CompletableFuture.supplyAsync(() -> _standardClassRepository.findByStandardId(standardId))
                .thenApply(x -> _mapper.StandardsClassToStandardsClassDto(x));
    }
}


package education.io.educationapi.domain.services.org;

import education.io.educationapi.Dtos.StandardDto;
import education.io.educationapi.Dtos.StandardsClassDto;
import education.io.educationapi.domain.interfaces.org.IStandardClassDomainService;
import education.io.educationapi.domain.interfaces.org.IStandardDomainService;
import education.io.educationapi.entities.org.Standard;
import education.io.educationapi.entities.org.Subject;
import education.io.educationapi.mappers.IMapper;
import education.io.educationapi.repositories.org.StandardRepository;
import education.io.educationapi.repositories.org.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class StandardDomainService implements IStandardDomainService {
    private final StandardRepository _standardRepository;
    private final IMapper mapper;

    public StandardDomainService(StandardRepository standardRepository, IMapper iMapper ) {
        _standardRepository = standardRepository;
        this.mapper = iMapper;
    }
    @Override
    public CompletableFuture<List<StandardDto>> getAll() {
        return  CompletableFuture.supplyAsync(()->_standardRepository.findAll())
                .thenApply((x)->mapper.standardsToStandardDto(x));
    }

    @Override
    public CompletableFuture<StandardDto> getById(int id) {
      return   CompletableFuture.supplyAsync(()-> _standardRepository.findById(id).
                orElseThrow(() -> new RuntimeException("StandardNotFound")))
                .thenApply(std->mapper.standardToStandardDto(std));
    }

    @Override
    public CompletableFuture<StandardDto> create(StandardDto standardsDto) {
       return  CompletableFuture.supplyAsync(()->_standardRepository.save(mapper.standardDtoToStandard(standardsDto) ))
               .thenApply(x-> mapper.standardToStandardDto(x));
    }

    @Override
    public CompletableFuture<StandardDto> update(int id, StandardDto standardDto) {
        return  CompletableFuture.supplyAsync(()->_standardRepository.findById(id).orElseThrow(() -> new RuntimeException("StandardNotFound")))
                .thenApply(x->{
                    x.setName(standardDto.getName());
                  return   _standardRepository.save(x);
        })
                .thenApply(y->mapper.standardToStandardDto(y));

    }
}

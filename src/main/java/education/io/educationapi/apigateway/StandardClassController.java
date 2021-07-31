package education.io.educationapi.apigateway;

import education.io.educationapi.Dtos.StandardsClassDto;
import education.io.educationapi.Dtos.SubjectDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/classes")

public class StandardClassController {

    @GetMapping("/")
    public List<StandardsClassDto> GetAll() {

        return new ArrayList<StandardsClassDto>();
    }
}

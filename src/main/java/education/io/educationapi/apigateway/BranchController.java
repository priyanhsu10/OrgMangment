package education.io.educationapi.apigateway;

import education.io.educationapi.Dtos.BranchDto;
import education.io.educationapi.Dtos.StandardsClassDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/branchs")
public class BranchController {
    @GetMapping("/")
    public List<BranchDto> GetAll() {

        return new ArrayList<BranchDto>();
    }
}

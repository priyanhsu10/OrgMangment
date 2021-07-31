package education.io.educationapi.apigateway;

import education.io.educationapi.Dtos.BranchDto;
import education.io.educationapi.Dtos.DepartmentDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/departments")

public class DepartmentController {
    @GetMapping("/")
    public List<DepartmentDto> GetAll() {

        return new ArrayList<DepartmentDto>();
    }
}

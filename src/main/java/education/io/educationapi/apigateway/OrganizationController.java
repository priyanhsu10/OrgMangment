package education.io.educationapi.apigateway;

import education.io.educationapi.Dtos.DepartmentDto;
import education.io.educationapi.Dtos.OrganizationDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/organizations")

public class OrganizationController {
    @GetMapping("/")
    public List<OrganizationDto> GetAll() {

        return new ArrayList<OrganizationDto>();
    }
}


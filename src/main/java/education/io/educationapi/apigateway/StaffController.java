package education.io.educationapi.apigateway;

import education.io.educationapi.Dtos.OrganizationDto;
import education.io.educationapi.Dtos.StaffDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/staffs")

public class StaffController {
    @GetMapping("/")
    public List<StaffDto> GetAll() {

        return new ArrayList<StaffDto>();
    }
}

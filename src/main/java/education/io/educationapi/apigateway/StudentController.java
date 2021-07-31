package education.io.educationapi.apigateway;

import education.io.educationapi.Dtos.StudentDto;
import education.io.educationapi.Dtos.SubjectDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/students")

public class StudentController {
    @GetMapping("/")
    public List<StudentDto> GetAll(){

        return  new ArrayList<StudentDto>();
    }
}

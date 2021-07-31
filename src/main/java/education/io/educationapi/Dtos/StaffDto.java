package education.io.educationapi.Dtos;

import education.io.educationapi.common.CommonEntityDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.Collection;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffDto extends CommonEntityDto {
    @Size(max = 50)
    @NotNull
    private String firstName;
    @Column(length = 50)
    private String middleName;
    @Size(max = 50)
    @NotNull
    private String lastName;
    private long salary;
    private String address;
    @NotNull
    private Date birthdate;
    private int age;
    private int staffType;
    private int gender;

    private DepartmentDto department;
    private OrganizationDto organization;
    private Collection<SubjectDto> subjects;
}

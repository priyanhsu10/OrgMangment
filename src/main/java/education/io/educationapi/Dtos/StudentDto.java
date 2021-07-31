package education.io.educationapi.Dtos;

import education.io.educationapi.common.CommonConstants;
import education.io.educationapi.common.CommonEntity;
import education.io.educationapi.common.CommonEntityDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto extends CommonEntityDto {
    @Size(max = 50)
    @NotNull
    private String firstName;
    @Size(max = 50)
    private String  middleName;
    @Size(max = 50)
    @NotNull
    private String lastName;
    private long salary;
    private String  address ;
    @NotNull
    private Date birthdate;
    private int age;
    private  int gender= CommonConstants.Gender.MALE;
    private StandardDto standard ;
    private StandardsClassDto standardsClass;
    private OrganizationDto organization;
}

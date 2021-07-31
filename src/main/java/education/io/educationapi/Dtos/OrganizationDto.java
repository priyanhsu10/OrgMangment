package education.io.educationapi.Dtos;

import education.io.educationapi.common.CommonEntity;
import education.io.educationapi.common.CommonEntityDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDto extends CommonEntityDto {
    @Size(max = 100)
    @NotNull
    private String name;
    @Size(max = 200)
    private String description;
    @Size(max = 400)
    private String address;
}

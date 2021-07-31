package education.io.educationapi.Dtos;

import education.io.educationapi.common.CommonEntity;
import education.io.educationapi.common.CommonEntityDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StandardsClassDto extends CommonEntityDto {
    @Size(max =50)
    @NotNull
    private  String name;
    private StandardDto standard ;
}

package education.io.educationapi.Dtos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import education.io.educationapi.common.CommonEntityDto;

public class StandardsClassDto extends CommonEntityDto {
    @Size(max = 50)
    @NotNull
    private String name;

    public StandardsClassDto() {
    }

    private StandardDto standard;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StandardDto getStandard() {
        return standard;
    }

    public void setStandard(StandardDto standard) {
        this.standard = standard;
    }
}

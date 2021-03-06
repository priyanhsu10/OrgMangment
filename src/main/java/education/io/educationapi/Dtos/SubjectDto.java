package education.io.educationapi.Dtos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import education.io.educationapi.common.CommonEntityDto;

public class SubjectDto extends CommonEntityDto {
    @Size(max = 50)
    @NotNull
    private String name;

    public SubjectDto() {
    }

    public SubjectDto(int id, String name, String description) {
        this.name = name;
        this.description = description;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Size(max = 200)
    private String description;
}

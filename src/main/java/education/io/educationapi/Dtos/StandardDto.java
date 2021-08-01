package education.io.educationapi.Dtos;

import education.io.educationapi.common.CommonEntity;
import education.io.educationapi.common.CommonEntityDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;


public class StandardDto extends CommonEntityDto {
    public String getName() {
        return name;
    }

    public StandardDto() {
    }

    public StandardDto(String name, Collection<SubjectDto> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<SubjectDto> getSubjects() {
        return subjects;
    }

    public void setSubjects(Collection<SubjectDto> subjects) {
        this.subjects = subjects;
    }

    @Size(max =50)
    @NotNull
    private  String name;
    private Collection<SubjectDto> subjects;
}

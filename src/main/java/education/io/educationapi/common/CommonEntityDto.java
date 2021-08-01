package education.io.educationapi.common;

import lombok.Data;

public abstract class CommonEntityDto {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    protected int id;
}

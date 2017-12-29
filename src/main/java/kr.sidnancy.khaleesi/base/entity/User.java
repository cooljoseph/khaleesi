package kr.sidnancy.khaleesi.base.entity;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * Created by joseph.yoon on 2017. 6. 16..
 */
public class User {

    private int id;
    @JsonView(Views.Public.class)
    public String name;
    @JsonView(Views.Internal.class)
    public String innerName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInnerName() {
        return innerName;
    }

    public void setInnerName(String innerName) {
        this.innerName = innerName;
    }
}

package ca.spfproject.model;

import java.util.SplittableRandom;

public class modelrest {

    private long id;
    private String name;
    private String statement;

    public modelrest(){

    }

    public modelrest(long id, String name, String statement) {
        this.id = id;
        this.name = name;
        this.statement = statement;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }
}

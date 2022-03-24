package com.harri.springproject.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Arrays;

@Entity
@Table(schema = "countries",name="continents")
public class Continent {
    @Id
    char[] code;
    String name;

    public Continent(char[] code, String name) {
        this.code = code;
        this.name = name;
    }

    protected Continent() {}

    public char[] getCode() {
        return code;
    }


    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Continent{" +
                "code=" + Arrays.toString(code) +
                ", name='" + name + '\'' +
                '}';
    }

}

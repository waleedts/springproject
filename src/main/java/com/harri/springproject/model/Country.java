package com.harri.springproject.model;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(schema = "countries",name="countries")
public class Country {
    @Id
    private char[] code;
    private String name;
    @Column(name = "full_name")
    private String fullName;
    private char[] iso3;
    private short number;
    @ManyToOne
    @JoinColumn(name = "continent_code")
    private  Continent continent;
    protected Country(){}

    @Override
    public String toString() {
        return "Country{" +
                "code=" + Arrays.toString(code) +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", iso3=" + Arrays.toString(iso3) +
                ", number=" + number +
                ", continent=" + continent +
                '}';
    }

    public Country(char[] code, String name, String fullName, char[] iso3, short number, Continent continent) {
        this.code = code;
        this.name = name;
        this.fullName = fullName;
        this.iso3 = iso3;
        this.number = number;
        this.continent = continent;
    }

    public Continent getContinent() {
        return continent;
    }

    public char[] getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public char[] getIso3() {
        return iso3;
    }

    public short getNumber() {
        return number;
    }

}

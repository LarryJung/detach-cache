package com.larry.detachcache;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Getter
@Entity
public class Tour implements Serializable {

    private static final long serialversionUID = 129348938L;

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "tour")
    private List<Option> options;

    public Tour() {

    }

    public Tour(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", options=" + options +
                '}';
    }
}

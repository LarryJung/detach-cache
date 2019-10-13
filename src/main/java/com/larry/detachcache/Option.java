package com.larry.detachcache;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Option {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String description;

    @JsonProperty("tour_id")
    @JoinColumn(name = "tour_id", nullable = false)
    @ManyToOne(optional = false)
    private Tour tour;

    public Option() {

    }

    public Option(String description, Tour tour) {
        this.description = description;
        this.tour = tour;
    }

    @Override
    public String toString() {
        return "Option{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}

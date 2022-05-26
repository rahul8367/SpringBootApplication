package com.demo.jobsearchproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "skill")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "skills")
    private String skills;
    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "listOfSkill")
    @JsonIgnore
    private List<Job> jobList=new ArrayList<>();

    public Skill(long id, String skills) {
        this.id = id;
        this.skills = skills;
    }
}

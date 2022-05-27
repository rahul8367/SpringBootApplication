package com.demo.jobsearchproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Job")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    @Column(name = "jobTitle")
    private String jobTitle;
    @Column(name = "location")
    private String location;
    @Column(name="companyName")
    private String companyName;
    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    @JoinTable(name = "job_skill", joinColumns = { @JoinColumn(name = "job_id") }, inverseJoinColumns = {
            @JoinColumn(name = "skill_id") })
    private List<Skill> listOfSkill =new ArrayList<>();
    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    @JoinTable(name = "job_commute", joinColumns = { @JoinColumn(name = "job_id") }, inverseJoinColumns = {
            @JoinColumn(name = "commute_id") })
    private List<Commute> listOfCommute =new ArrayList<>();

    public Job(long id, String jobTitle, String location, String companyName) {
        this.id = id;
        this.jobTitle = jobTitle;
        this.location = location;
        this.companyName = companyName;
    }

    public void setSkillList(Skill skill){
        listOfSkill.add(skill);
    }

    public void setListOfCommute(Commute commute) {

        this.listOfCommute.add(commute);
    }
}
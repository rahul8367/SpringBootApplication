package com.demo.jobsearchproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "commute")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Commute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "commutes")
    private String commuteTypes;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "listOfCommute")
    private List<Job> listJob=new ArrayList<>();

}

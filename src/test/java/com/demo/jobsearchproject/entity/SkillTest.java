package com.demo.jobsearchproject.entity;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SkillTest {

    @Test
    void getSetTest() {
        Long x=1L;
        Job job = new Job();
        job.setJobTitle("java developer");
        job.setLocation("Hyd");
        job.setCompanyName("jpr");
        List<Skill> xList = new ArrayList<>();
        Skill skill=new Skill();
        skill.setSkills("java");
        job.setSkillList(skill);
        List<Job> y= new ArrayList<>();
        y.add(job);
        skill.setJobList(y);
        Skill obj=new Skill(3,"python",y);
        assertEquals("java",skill.getSkills());
        assertEquals(job,skill.getJobList().get(0));

    }

}
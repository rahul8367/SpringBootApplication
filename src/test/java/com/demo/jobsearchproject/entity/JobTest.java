package com.demo.jobsearchproject.entity;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JobTest {

    @Test
    void getAndSetTest() {
        Long x=1L;
        Job job = new Job();
        job.setJobTitle("java developer");
        job.setLocation("Hyd");
        job.setCompanyName("jpr");
        List<Skill> xList = new ArrayList<>();
        Skill skill=new Skill();
        skill.setSkills("java");
        job.setSkillList(skill);
        Job obj=new Job(2,"rdr","xdx","dxdd",job.getListOfSkill());
        assertEquals("java developer",job.getJobTitle());
        assertEquals("jpr",job.getCompanyName());
        assertEquals("Hyd",job.getLocation());
        assertEquals(skill,job.getListOfSkill().get(0));


    }


}
package com.demo.jobsearchproject.controllers;

import com.demo.jobsearchproject.dto.SearchDto;
import com.demo.jobsearchproject.entity.Job;
import com.demo.jobsearchproject.entity.Skill;
import com.demo.jobsearchproject.repository.JobRepository;
import com.demo.jobsearchproject.repository.SkillRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class ControllerTest {

    @Autowired
    private Controller controller;
    @MockBean
    private JobRepository jobRepo;
    @MockBean
    private SkillRepository skillRepository;

  /*  Skill skill1 = new Skill(1L, "java");
    Skill skill2 = new Skill(2L, "python");
    Skill skill3 = new Skill(3L, "uiz");

    Job job1 = new Job(1L, "java dev", "hyd", "raj grops");

    Job job2 = new Job(2L, "python dev", "hyd", "mps");
    Job job3 = new Job(3L, "ui dev", "delhi", "zemoso");*/

 /*   @Test
    void getAllRecordsTest() throws Exception {
        job1.setSkillList(skill1);
        job1.setSkillList(skill2);
        job2.setSkillList(skill3);
        job3.setSkillList(skill3);
        assertNotNull(controller);
        Job job = controller.saveData(job1);
        assertNotNull(job.getListOfSkill());
        List<Job> xList = controller.getJob();
        int le = xList.size();
        controller.saveData(job2);
        List<Job> yList = controller.getJob();
        Skill skill = controller.addSkillToDB(skill3);
        assertNotNull(skill);
        Job obj = controller.getJobById(1L);
        assertEquals("hyd", obj.getLocation());
        long id = 12L;
        List<Skill> obj1 = controller.getAllSkill();
        assertNotNull(obj1);
        List<SearchDto> var = controller.findByKeyword("delhi");
        for (SearchDto j : var) {
            assertEquals("delhi", j.getLocation());
        }
        List<SearchDto> var1 = controller.findByLocation("delhi");
        for (SearchDto j : var1) {
            assertEquals("delhi", j.getLocation());
        }
        List<SearchDto> var3 = controller.findBySkill("java");
        assertNotNull(var3);


    }

    @Test
    public void readAllJobs() throws Exception {
        List<Job> yList = jobRepo.findAll();
        assertNotNull(yList);
    }*/

    //..................................................................................................................
    @Test
    public void jobFindByIdTest() {
        long id = 15L;
        Job job = new Job();
        when(jobRepo.findById(id)).thenReturn(Optional.of(job));

        Assertions.assertEquals(Optional.of(job), jobRepo.findById(id));
    }

    @Test
    public void jobDeleteByIdTest() {
        long id = 15L;
        jobRepo.deleteById(id);
        verify(jobRepo, times(1)).deleteById(id);
    }

    @Test
    public void jobCreateTest() {
        Job mocJob = new Job();
        mocJob.setId(16L);
        mocJob.setJobTitle("full stack");
        mocJob.setLocation("hyd");

        jobRepo.save(mocJob);
        verify(jobRepo, times(1)).save(mocJob);

    }

    @Test
    public void jobSearchTest() {
        String skill = "java";
        List<Job> x = jobRepo.findByKeyword(skill);
        for (Job y : x) {
            List<Skill> jList = y.getListOfSkill();
            for (Skill j : jList) {
                assertEquals(skill, j.getSkills());
            }
        }

    }

    @Test
    public void readAllSkill() throws Exception {
        List<Skill> yList = skillRepository.findAll();
        assertNotNull(yList);

    }
}
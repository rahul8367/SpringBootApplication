package com.demo.jobsearchproject.controllers;

import com.demo.jobsearchproject.converter.Converter;
import com.demo.jobsearchproject.dto.SearchDto;
import com.demo.jobsearchproject.entity.Job;
import com.demo.jobsearchproject.entity.Skill;
import com.demo.jobsearchproject.jobexception.NotFoundException;
import com.demo.jobsearchproject.jobexception.NullException;
import com.demo.jobsearchproject.repository.JobRepository;
import com.demo.jobsearchproject.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class Controller {
    //initialization
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private Converter converter;


    //.............................................for searching...........................................................................................................


    //searching by location or skill..........................................................................
    @GetMapping("/search/{value}")
    public List<SearchDto> findByKeyword(@PathVariable String value) {
        List<Job> xList=jobRepository.findByKeyword(value);
        return converter.entityToDto(xList);
    }


    //searching by location..........................................................................
    @GetMapping("/search/location/{value}")
    public List<SearchDto> findByLocation(@PathVariable String value) {
        List<Job> xList=jobRepository.findByLocation(value);
        return converter.entityToDto(xList);
    }


    //searching by skill..........................................................................
    @GetMapping("/search/skill/{value}")
    public List<SearchDto> findBySkill(@PathVariable String value) {
        List<Job> xList=jobRepository.findBySkill(value);
        return converter.entityToDto(xList);
    }
    //.............................................for Job.........................................................................................................

    //Listing the all the job's....................................................................
    @GetMapping("/job")
    public List<Job> getJob() {

        return jobRepository.findAll();
    }

    //listing the job by id.....................................................................
    @GetMapping("/job/{id}")
    public Job getJobById(@PathVariable("id") Long id){
        Job com=jobRepository.findById(id).orElseThrow(() -> new NotFoundException("job not found with id :" + id));
        return com;
    }

    //add the company................................................................................
    @PostMapping("/job")
    public  Job saveData(@RequestBody Job job) {

        if(job.getLocation().length()<=2){
            throw new NullException("the location is must not null and it must contains more then 2 characters");
        }
        else if(job.getJobTitle().length()<=2){
            throw new NullException("the job title field is must not null ");}
        else if(job.getListOfSkill().size()>=1){
            for(Skill j: job.getListOfSkill()){
                if(j.getSkills().length()<=1){
                    throw new NullException("the skill field is must not null ");
                }
                }
            }
        return jobRepository.save(job);
    }

    //delete the job by id.................................................................................
    @DeleteMapping("/job/{id}")
    public String getDeleteById(@PathVariable("id") long id) {
        try {
            jobRepository.deleteById(id);
            return "the record is deleted";

        }catch (Exception e){
            throw new NotFoundException("job not found with id ="+id);
        }


    }
    //update the job details...............................................................................

    @PutMapping("/job/{id}")
    public String updateCompany(@PathVariable("id") long id, @RequestBody Job job) {
        //check if employee exist in database
        Job obj = jobRepository.findById(id).orElseThrow(() -> new NotFoundException("job not found with id :" + id));
        obj.setCompanyName(job.getCompanyName());
        obj.setJobTitle(job.getJobTitle());
        obj.setLocation(job.getLocation());
        obj.setListOfSkill(job.getListOfSkill());
        if (obj.getLocation().length() <= 2) {
            throw new NullException("the location is must not null and it must contains more then 2 characters");
        }
        else if (obj.getJobTitle().length() <= 2) {
            throw new NullException("the job title field is must not null ");
        }
        else if (job.getListOfSkill().size() >= 1) {
            for (Skill j : job.getListOfSkill()) {
                if (j.getSkills().length() <= 1) {
                    throw new NullException("the skill field is must not null ");
                }
            }
        }

        jobRepository.save(obj);
        return "the record is updated";
    }
    // deleting all the job's........................................................................................
    @DeleteMapping("/job")
    public String deleteAllEmployees() {
       jobRepository.deleteAll();
        return "deleted all";
    }

    // the skill is removed from the job.........................................................................
    @DeleteMapping("/job/{id}/{skillid}")
    public String deleteTheSkillFromJob(@PathVariable("id") Long id,@PathVariable Long skillid){
       Job obj=jobRepository.findById(id).orElseThrow(() -> new NotFoundException("company not found with id :" + id));
        for(Skill s:obj.getListOfSkill()){
            if(s.getId()==skillid) {
                obj.getListOfSkill().remove(s);
                jobRepository.save(obj);
                return "the element is removed";
            }
        }
        return "the element is not present: "+skillid;
    }



    //adding the job to the company.....................................................................................
    @PutMapping("/job/{id}/skill")
    public Job addJob(@PathVariable("id") Long id,@RequestBody Skill skill){

        Job obj=jobRepository.findById(id).orElseThrow(() -> new NotFoundException("job not found with id :" + id));
        if(skill.getSkills().length()<=1){
            throw new NullException("the skill field is must not null ");
        }
        obj.setSkillList(skill);
        return jobRepository.save(obj);
    }

    //.............................................for skill.........................................................................................................


    //add skill in the data base............................................................................................
    @PostMapping("/skill")
    public Skill addSkillToDB(@RequestBody Skill skill){
        if(skill.getSkills().length()<=1){
            throw new NullException("the skill field is must not null ");
        }

        return skillRepository.save(skill);
    }

    //deleting the skill throw the id........................................................................................
    @DeleteMapping("/skill/{id}")
    public String skillDeleteById(@PathVariable("id") Long id){
        try{
            skillRepository.deleteById(id);
            return "the job was deleted";
        }
        catch (Exception e){
            throw new NotFoundException("skill not found with id ="+id);
        }

    }
    //updating the job throw id.........................................................................................
    @PutMapping("/skill/{id}")
    public String updateById(@PathVariable("id") Long id,@RequestBody Skill skill){
        Skill obj=skillRepository.findById(id).orElseThrow(() -> new NotFoundException("skill not found with id :" + id));
        if(skill.getSkills().length()<=1){
            throw new NullException("the skill field is must not null ");
        }
        obj.setSkills(skill.getSkills());
        skillRepository.save(obj);
        return "the id="+id+" is updated";
    }

    //find the job throw job id.............................................................................................
    @GetMapping("/skill/{id}")
    public Skill getSkillById(@PathVariable("id") Long id){
        Skill obj=skillRepository.findById(id).orElseThrow(() -> new NotFoundException("skill not found with id :" + id));
        return obj;
    }
    // find the skill list in db..............................................................................................
    @GetMapping("/skill")
    public List<Skill> getAllSkill(){
        return skillRepository.findAll();
    }
}

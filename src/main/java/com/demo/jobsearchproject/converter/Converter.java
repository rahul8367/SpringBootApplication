package com.demo.jobsearchproject.converter;

import com.demo.jobsearchproject.dto.SearchDto;
import com.demo.jobsearchproject.entity.Job;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Converter {

    public SearchDto entityToDto(Job job){
        SearchDto con=new SearchDto();
        con.setJobTitle(job.getJobTitle());
        con.setId(job.getId());
        con.setLocation(job.getLocation());
        return con;
    }

    public List<SearchDto> entityToDto(List<Job> books) {
        return books.stream().map(this::entityToDto).collect(Collectors.toList());
    }
}
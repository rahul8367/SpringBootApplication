package com.demo.jobsearchproject.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchDtoTest {

    @Test
    void getIdTest() {
        Long x=1L;
        SearchDto obj=new SearchDto();
        obj.setId(x);
        assertEquals(obj.getId(),x);
    }

    @Test
    void getJobTitleTest() {
        Long x=1L;
        SearchDto obj=new SearchDto(x,"java","hyd");
        obj.setLocation("delhi");
        assertEquals("delhi",obj.getLocation());
    }

    @Test
    void getLocationTest() {
        SearchDto obj=new SearchDto();
        obj.setLocation("hyd");
        assertEquals("hyd",obj.getLocation());
    }
}
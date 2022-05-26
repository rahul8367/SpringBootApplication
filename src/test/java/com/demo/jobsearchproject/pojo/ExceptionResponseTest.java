package com.demo.jobsearchproject.pojo;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;



class ExceptionResponseTest {

    @Test
    void getStatusTest() {
        ExceptionResponse exe=new ExceptionResponse();
        exe.setStatus(808);
        assertEquals(808,exe.getStatus());
    }

    @Test
    void getMessageTest() {
        ExceptionResponse exe=new ExceptionResponse();
        exe.setMessage("no error");
        exe.setTimeStamp(System.currentTimeMillis());
        assertEquals("no error",exe.getMessage());
    }

    @Test
    void getTimeStampTest() {
        ExceptionResponse exe=new ExceptionResponse(404,"no error",System.currentTimeMillis());
        assertEquals(System.currentTimeMillis(),exe.getTimeStamp());

    }
}
package com.callor.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/st")
public class StudentController {

    @RequestMapping(value="/list", method= RequestMethod.GET)
    public String list(){

        // tiles_layout.xml 에 name ST/* 로 설정된 파일을 랜더링 해라
        return "ST/st_list";
    }

    @RequestMapping(value="/detail", method= RequestMethod.GET)
    public String detail(){
        return "ST/st_detail";
    }

    @RequestMapping(value="/write", method= RequestMethod.GET)
    public String write(){
        return "ST/st_write";
    }

    @RequestMapping(value="/list2", method= RequestMethod.GET)
    public String list2(){
        return "student/st_list";
    }
}

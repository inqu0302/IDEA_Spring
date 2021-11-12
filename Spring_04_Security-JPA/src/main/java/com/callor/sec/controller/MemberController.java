package com.callor.sec.controller;

import com.callor.sec.models.UserDetailsVO;
import com.callor.sec.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping(value="/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(@Qualifier("memServiceV1") MemberService memberService) {
        this.memberService = memberService;
    }

    // login form 을 열기위한 URL
    @RequestMapping(value="/login", method= RequestMethod.GET)
    public String login(){
        return "member/login";
    }

    @RequestMapping(value="/join", method=RequestMethod.GET)
    public String join(){
        return "member/join";
    }

    @RequestMapping(value="/join", method=RequestMethod.POST)
    public String join(UserDetailsVO userVO){

        log.debug("회원가입 : {}", userVO.toString());

        memberService.insert(userVO);

        return "member/join";
    }

    @ResponseBody
    @RequestMapping(value="/idcheck", method=RequestMethod.GET)
    public UserDetails idcheck(String username){

        /**
         * service(dao) findById(username) 으로 조회를 하여 결과를 바로 return
         *
         * 이미 데이터가 있으면 회원정보를 return 하고
         * 없으면 null 값을 return 한다
         *
         * return sService.findById(username) 으로 사용가능
         */
//        if(username.equalsIgnoreCase("inqu0302")){
//            return "FAIL";
//        } else {
//            return null;
//        }
        return memberService.findById(username);
    }
}

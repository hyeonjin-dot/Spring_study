package hello.hello_spring.controller;

import hello.hello_spring.service.MemberSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberSerivce memberSerivce;

    @Autowired
    public MemberController(MemberSerivce memberSerivce) {
        this.memberSerivce = memberSerivce;
    }
}


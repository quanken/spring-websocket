package com.quanken.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

import javax.servlet.http.HttpServletRequest

@Controller
class IndexController {
    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }
}

@Controller
class LoginController {
    @RequestMapping(value = "login")
    public String enterChatRoom(HttpServletRequest request, String username){
        request.getSession().setAttribute("username", username);
        return "chatroom";
    }
}
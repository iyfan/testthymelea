package com.example.testthymeleaffff.conteoller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class testcontroller {

    @PostMapping("/user/login")
    public  String login(String username, String password, Map map, HttpSession session){
        if(!StringUtils.isEmpty(username)&&"123456".equals(password)) {
            session.setAttribute("loginuser",username);
            return "redirect:/main";
        }else {
            map.put("msg","输入有误!");
            return "index";
        }
    }
}

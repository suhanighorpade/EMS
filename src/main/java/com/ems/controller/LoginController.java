package com.ems.controller;

import com.ems.entity.LoginMaster;
import com.ems.service.LoginMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @Autowired
    private LoginMasterService loginMasterService;

    public void initAdmin()
    {
        if(loginMasterService.getLoginDetails().isEmpty())
        {
            LoginMaster loginMaster = new LoginMaster(1000000000L,"admin","ROLE_ADMIN");
            loginMasterService.save(loginMaster);
        }
    }


    @GetMapping("/showLoginForm")
    public String showLoginPage()
    {
        initAdmin();
        return "login-page";
    }

}

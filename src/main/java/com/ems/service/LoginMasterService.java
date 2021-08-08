package com.ems.service;

import com.ems.dao.LoginMasterDAO;
import com.ems.entity.LoginMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Service
public class LoginMasterService implements UserService {

    @Autowired
    private LoginMasterDAO loginMasterDAO;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        LoginMaster loginMaster = loginMasterDAO.findById(s);

        if(loginMaster == null)
            throw new UsernameNotFoundException("Invalid username or password.");

        return new User(Long.toString(loginMaster.getUserid()), loginMaster.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority(loginMaster.getRole())));
    }


    public void save(LoginMaster loginMaster) {
        loginMasterDAO.save(loginMaster);
    }

    public List<LoginMaster> getLoginDetails() {

        return loginMasterDAO.getAllCreds();
    }
}

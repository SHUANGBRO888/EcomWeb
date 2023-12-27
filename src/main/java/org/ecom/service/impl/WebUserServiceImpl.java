package org.ecom.service.impl;

import org.ecom.entity.AdminUser;
import org.ecom.entity.WebUser;
import org.ecom.mapper.AdminUsersMapper;
import org.ecom.mapper.WebUserMapper;
import org.ecom.service.IWebUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class WebUserServiceImpl implements IWebUserService {
    // mapper database visit objects
    @Resource
    private WebUserMapper webUserMapper;
    // log in
    @Override
    public WebUser webUserLogin(WebUser webUser) {
        return webUserMapper.find(webUser);
    }
    // Sign Up
    @Override
    public void webUserSignUp(WebUser webUser) {
        int affectedRows = webUserMapper.create(webUser);
        if (affectedRows == 0) {
            throw new RuntimeException("User sign up failed.");
        }
    }
    // find by name
    @Override
    public WebUser findByUserName(String userName) {
        WebUser queryUser = new WebUser();
        queryUser.setUserName(userName);
        return webUserMapper.find(queryUser);
    }
}

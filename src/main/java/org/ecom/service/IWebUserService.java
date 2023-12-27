package org.ecom.service;

import org.ecom.entity.AdminUser;
import org.ecom.entity.WebUser;

public interface IWebUserService {

    WebUser webUserLogin(WebUser webUser);

    void webUserSignUp(WebUser webUser);

    WebUser findByUserName(String userName);
}

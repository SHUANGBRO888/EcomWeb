package org.ecom.service;

import org.ecom.entity.AdminUser;

public interface IAdminUserService {
    // log in
    AdminUser adminLogin(AdminUser adminUser);
}

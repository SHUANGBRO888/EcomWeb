package org.ecom.service.impl;

import org.ecom.entity.AdminUser;
import org.ecom.mapper.AdminUsersMapper;
import org.ecom.service.IAdminUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminUsersServiceImpl implements IAdminUserService {

    // mapper database visit objects
    @Resource
    private AdminUsersMapper adminUsersMapper;
    @Override
    public AdminUser adminLogin(AdminUser adminUser) {
        return adminUsersMapper.find(adminUser);
    }


}

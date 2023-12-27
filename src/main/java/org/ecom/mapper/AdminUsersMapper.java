package org.ecom.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.ecom.entity.AdminUser;

@Mapper
public interface AdminUsersMapper {
    // lookup users
    AdminUser find(AdminUser adminUser);
}

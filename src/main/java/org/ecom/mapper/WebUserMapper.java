package org.ecom.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.ecom.entity.WebUser;

@Mapper
public interface WebUserMapper {
    // Look up web user
    WebUser find(WebUser webUser);
    // Create web user account
    int create(WebUser webUser);
}

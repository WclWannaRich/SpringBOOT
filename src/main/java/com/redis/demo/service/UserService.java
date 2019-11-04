/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserService
 * Author:   Administrator
 * Date:     19-11-4, 0004 上午 09:14
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.redis.demo.service;

import com.redis.demo.damain.User;
import com.redis.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 19-11-4, 0004
 * @since 1.0.0
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Cacheable("user")
    public User getUser(int id){
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }
}

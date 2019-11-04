/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserController
 * Author:   Administrator
 * Date:     19-11-4, 0004 上午 09:51
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.redis.demo.controller;

import com.redis.demo.damain.User;
import com.redis.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 19-11-4, 0004
 * @since 1.0.0
 */
@Controller
public class UserController {
    @Autowired
    private RedisTemplate redisCacheTemplate;

    @RequestMapping("/setUser")
    public String setString(String key, String value){
        User user = new User();
        user.setName("xc");
        redisCacheTemplate.opsForValue().set("qwe", user);
        User map2 = (User) redisCacheTemplate.opsForValue().get("qwe");
        System.out.println(map2.getName());
        return "index";
    }
}

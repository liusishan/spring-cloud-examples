package com.lss.consumer.client;

import com.lss.consumer.pojo.User;
import org.springframework.stereotype.Component;

/**
 * @Auther: lss
 * @Date: 2019/4/4 15:14
 * @Description:
 */
@Component
public class UserClientFallback implements UserClient {

    @Override
    public User queryById(Integer id) {
        User user = new User();
        user.setUsername("未知用户! ");
        return user;
    }
}

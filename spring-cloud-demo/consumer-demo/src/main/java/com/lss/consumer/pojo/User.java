package com.lss.consumer.pojo;

import lombok.Data;


/**
 * @Auther: lss
 * @Date: 2019/3/30 17:11
 * @Description:
 */
@Data
public class User {
    // id
    private Integer id;
    // 用户名
    private String username;
    // 密码
    private String password;
    // 年龄
    private Integer age;
    // 性别
    private String sex;
    // email
    private String email;
    // 备注
    private String note;
}


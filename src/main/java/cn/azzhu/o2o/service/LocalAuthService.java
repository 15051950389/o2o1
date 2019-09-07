package cn.azzhu.o2o.service;

import cn.azzhu.o2o.entity.LocalAuth;



public interface LocalAuthService {
    /**
     * 校验用户名
     * @param
     * @return
     */

    LocalAuth getUserById(String userName);

    //注册
    LocalAuth regist(LocalAuth localAuth);

    //登陆
    LocalAuth login(LocalAuth localAuth);

    /**
     * 插入用户账户信息
     */

    int addLocalAuth(LocalAuth localAuth);


}

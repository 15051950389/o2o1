package cn.azzhu.o2o.service;

import cn.azzhu.o2o.entity.PersonInfo;

public interface PersonInfoService {
    //查询单个信息
    PersonInfo getPersonInfo(PersonInfo personInfo);

    /**
     * 注册用户
     */
    int addPersonInfo(PersonInfo personInfo);
}

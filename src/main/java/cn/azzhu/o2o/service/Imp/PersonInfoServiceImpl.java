package cn.azzhu.o2o.service.Imp;

import cn.azzhu.o2o.entity.PersonInfo;
import cn.azzhu.o2o.mapper.PersonInfoMapper;
import cn.azzhu.o2o.service.PersonInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonInfoServiceImpl implements PersonInfoService {
    @Autowired
    private PersonInfoMapper personInfoMapper;

    @Override
    public PersonInfo getPersonInfo(PersonInfo personInfo) {
        QueryWrapper<PersonInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",personInfo.getUserId());
        return personInfoMapper.selectOne(queryWrapper);
    }

    @Override
    public int addPersonInfo(PersonInfo personInfo) {
        return personInfoMapper.insert(personInfo);
    }


}

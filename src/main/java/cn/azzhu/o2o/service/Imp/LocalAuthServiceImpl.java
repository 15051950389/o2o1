package cn.azzhu.o2o.service.Imp;


import cn.azzhu.o2o.entity.LocalAuth;
import cn.azzhu.o2o.mapper.LocalAuthMapper;
import cn.azzhu.o2o.service.LocalAuthService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

@Service
@Transactional
public class LocalAuthServiceImpl implements LocalAuthService {

    @Autowired
    private LocalAuthMapper localAuthMapper;


    @Override
    public LocalAuth getUserById(String userName) {
        QueryWrapper<LocalAuth> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name",userName);
        return localAuthMapper.selectOne(queryWrapper);
    }

    @Override
    public LocalAuth regist(LocalAuth localAuth) {
        return null;
    }

    @Override
    public LocalAuth login(LocalAuth localAuth) {
        QueryWrapper<LocalAuth> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name",localAuth.getUserName());
        //获取明文密码
        String password = localAuth.getPassword();

        //进行加密
        String nwd= DigestUtils.md5DigestAsHex(password.getBytes());
        queryWrapper.eq("password",nwd);


        return localAuthMapper.selectOne(queryWrapper);
    }

    @Override
    public int addLocalAuth(LocalAuth localAuth) {
        return localAuthMapper.insert(localAuth);
    }
}

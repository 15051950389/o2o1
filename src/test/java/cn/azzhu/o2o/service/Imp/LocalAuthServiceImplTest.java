package cn.azzhu.o2o.service.Imp;


import cn.azzhu.o2o.entity.LocalAuth;
import cn.azzhu.o2o.service.LocalAuthService;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;


@RunWith(SpringRunner.class)
@SpringBootTest
public class LocalAuthServiceImplTest {
    @Autowired
    private LocalAuthService userService;

    @Test
    public void getUserById() {
        System.out.println("=====>"+userService.getUserById("admin"));
    }

}

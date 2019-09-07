package cn.azzhu.o2o.service.Imp;

import cn.azzhu.o2o.entity.LocalAuth;
import cn.azzhu.o2o.entity.ShopAuthMap;
import cn.azzhu.o2o.mapper.ShopAuthMapper;
import cn.azzhu.o2o.service.ShopAuthService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopAuthServiceImpl implements ShopAuthService {

    @Autowired
    private ShopAuthMapper shopAuthMapper;

    @Override
    public List<ShopAuthMap> getShopsByAuthId(LocalAuth auth) {
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("employee_id",auth.getUserId());
        return shopAuthMapper.selectList(queryWrapper) ;
    }
}

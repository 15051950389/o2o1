package cn.azzhu.o2o.service;

import cn.azzhu.o2o.entity.LocalAuth;
import cn.azzhu.o2o.entity.ShopAuthMap;

import java.util.List;

public interface ShopAuthService {
    List<ShopAuthMap> getShopsByAuthId(LocalAuth auth);

}

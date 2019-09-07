package cn.azzhu.o2o.service;

import java.util.List;
import java.util.Map;

public interface ChatService {
    List<Map<String,Object>> getTop5Product(Map<String,String> map);
    Map<String,Integer> getOrderStatus(Map<String,String> map);
    List<Map<String,Object>> getMoney(Map<String,String> map);
}

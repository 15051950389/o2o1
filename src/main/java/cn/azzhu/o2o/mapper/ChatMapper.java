package cn.azzhu.o2o.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ChatMapper {
    List<Map<String,Object>> getTop5Product(Map<String,String> map);
    Map<String,Integer> getOrderStatus(Map<String,String> map);
    List<Map<String,Object>> getMoney(Map<String,String> map);
}

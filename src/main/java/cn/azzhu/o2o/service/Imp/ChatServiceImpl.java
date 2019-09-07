package cn.azzhu.o2o.service.Imp;

import cn.azzhu.o2o.mapper.ChatMapper;
import cn.azzhu.o2o.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ChatServiceImpl implements ChatService {
    @Autowired
    private ChatMapper mapper;


    public List<Map<String,Object>> getTop5Product(Map<String,String> map){
        return mapper.getTop5Product(map);
    }

    @Override
    public Map<String, Integer> getOrderStatus(Map<String, String> map) {
        return mapper.getOrderStatus(map);
    }

    @Override
    public List<Map<String, Object>> getMoney(Map<String, String> map) {
        return mapper.getMoney(map);
    }


}

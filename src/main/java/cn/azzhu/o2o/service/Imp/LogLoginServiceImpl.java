package cn.azzhu.o2o.service.Imp;

import cn.azzhu.o2o.entity.LogLogin;
import cn.azzhu.o2o.mapper.LogLoginMapper;
import cn.azzhu.o2o.service.LogLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogLoginServiceImpl implements LogLoginService {

    @Autowired
    private LogLoginMapper logLoginMapper;

    @Override
    public int addLoginfo(LogLogin logLogin) {
        return logLoginMapper.insert(logLogin);
    }
}

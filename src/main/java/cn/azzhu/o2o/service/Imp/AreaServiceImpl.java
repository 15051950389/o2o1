package cn.azzhu.o2o.service.Imp;

import cn.azzhu.o2o.mapper.AreaMapper;
import cn.azzhu.o2o.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.geom.Area;
import java.util.List;


@Service
@Transactional
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaMapper areaMapper;



    @Override
    public List<Area> getAreas() {
        return areaMapper.selectList(null);
    }
}

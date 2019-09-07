package cn.azzhu.o2o.service.Imp;

import cn.azzhu.o2o.entity.ProductCategory;
import cn.azzhu.o2o.entity.Shop;
import cn.azzhu.o2o.mapper.ProductCategoryMapper;
import cn.azzhu.o2o.service.PriductCategoryService;
import cn.azzhu.o2o.utils.DataGrid;
import cn.azzhu.o2o.utils.DataGridView;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements PriductCategoryService {
    @Autowired
    private ProductCategoryMapper mapper;

    @Override
    public DataGrid getDataGrid(Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum,pageSize);
        List<ProductCategory> products = mapper.selectList(null);
        PageInfo<ProductCategory> pageInfo = new PageInfo<>(products);

        DataGrid<ProductCategory> objectDataGrid = new DataGrid<>();
        objectDataGrid.setCount(pageInfo.getTotal());
        objectDataGrid.setData(pageInfo.getList());
        return objectDataGrid;
    }
}

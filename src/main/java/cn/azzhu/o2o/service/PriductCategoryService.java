package cn.azzhu.o2o.service;

import cn.azzhu.o2o.utils.DataGrid;
import cn.azzhu.o2o.utils.DataGridView;

public interface PriductCategoryService {
    DataGrid getDataGrid(Integer pageNum, Integer pageSize);
}

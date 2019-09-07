package cn.azzhu.o2o.utils;

import lombok.Data;

import java.util.List;
@Data
public class DataGrid<T> {
    private Integer code = 0;
    private String msg = "";
    private Long count;
    private List<T> data;
}

package cn.azzhu.o2o.vo;

import cn.azzhu.o2o.entity.Product;
import lombok.Data;

import java.util.List;

@Data
public class ProductVo extends Product {
    private String productName;
    private String startPrice;
    private String endPrice;
    private String startTime;
    private String endTime;

    private List<Long> shopIds;
}

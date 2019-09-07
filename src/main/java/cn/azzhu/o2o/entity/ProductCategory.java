package cn.azzhu.o2o.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

@Data
public class ProductCategory {
    private Integer productCategoryId;

    private String productCategoryName;

    private String productCategoryDesc;

    private Double priority;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createTime;
    @JsonIgnore
    private Date lastEditTime;
    private Long shopId;

}

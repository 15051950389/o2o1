package cn.azzhu.o2o.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;
@Data
public class ShopCategory {
    private Integer shopCategoryId;

    private String shopCategoryName;

    private String shopCategoryDesc;

    private String shopCategoryImg;

    private Integer priority;


    private Date createTime;

    @JsonIgnore
    private Date lastEditTime;

    private Integer parentId;


}
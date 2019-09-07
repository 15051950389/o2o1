package cn.azzhu.o2o.entity;

import lombok.Data;

import java.util.Date;
@Data
public class UserProductMap {
    private Integer userProductId;

    private Integer userId;

    private Integer productId;

    private Integer shopId;

    private String userName;

    private String productName;

    private Date createTime;

    private Integer point;


}
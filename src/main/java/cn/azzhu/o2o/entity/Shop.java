package cn.azzhu.o2o.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;
@Data
public class Shop {
    private Integer shopId;

    private Integer ownerId;

    private Integer areaId;

    private Integer shopCategoryId;

    private Integer parentCategoryId;

    private String shopName;

    private String shopDesc;

    private String shopAddr;

    private String phone;

    @JsonIgnore
    private String shopImg;

    private Double longitude;

    private Double latitude;

    private Integer priority;

    private Date createTime;

    private Date lastEditTime;

    private Integer enableStatus;

    private String advice;


}
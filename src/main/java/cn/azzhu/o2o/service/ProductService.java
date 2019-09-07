package cn.azzhu.o2o.service;

import cn.azzhu.o2o.entity.Product;
import cn.azzhu.o2o.vo.ProductVo;
import com.github.pagehelper.PageInfo;

public interface ProductService {


    PageInfo<Product> getPage(Integer page, Integer limit, ProductVo productVo);

    /**
     * 删除
     * @param product
     */
    void deleteProductById(Product product);

    /**
     * 下架商品
     * @param product
     */
    void down(Product product);

    /**
     * 上架商品
     * @param product
     */
    void up(Product product);

    /**
     * 批量删除
     * @param ids
     */
    void deleteProductByIds(String[] ids);

    /**
     * 修改
     * @param product
     */
    void updateProduct(Product product);

    /**
     * 新增
     * @param product
     */
    void addProduct(Product product);
}

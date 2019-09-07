package cn.azzhu.o2o.controller;

import cn.azzhu.o2o.O2oApplication;
import cn.azzhu.o2o.entity.LocalAuth;
import cn.azzhu.o2o.entity.Product;
import cn.azzhu.o2o.exception.O2OException;
import cn.azzhu.o2o.entity.ShopAuthMap;
import cn.azzhu.o2o.service.Imp.ShopAuthServiceImpl;
import cn.azzhu.o2o.service.ProductService;
import cn.azzhu.o2o.utils.AppFileUtils;
import cn.azzhu.o2o.utils.DataGridView;
import cn.azzhu.o2o.utils.ResultObj;
import cn.azzhu.o2o.utils.SysConstants;
import cn.azzhu.o2o.vo.ProductVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("shop/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ShopAuthServiceImpl shopAuthService;

    @GetMapping("list.html")
    public String toList(){
    return "product/list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public Object getList(ProductVo productVo, HttpSession session,
                          @RequestParam(value = "page",required = false,defaultValue = "1") Integer page,
                          @RequestParam(value = "limit",required = false,defaultValue = "5") Integer limit) {

        LocalAuth user = (LocalAuth) session.getAttribute(SysConstants.SESSION_USER);
        List<ShopAuthMap> userShops = shopAuthService.getShopsByAuthId(user);


        ArrayList<Long> shopIds = new ArrayList<>();
        for (ShopAuthMap userShop : userShops) {
            shopIds.add(userShop.getShopId());
        }
        productVo.setShopIds(shopIds);
        PageInfo<Product> pageInfo = productService.getPage(page, limit, productVo);
        DataGridView<Product> dataGridView = new DataGridView<>();

        dataGridView.setCount(pageInfo.getTotal());
        dataGridView.setData(pageInfo.getList());
        return dataGridView;
    }

    /**
     * 删除单个商品
     * @param product
     * @return
     */
    @GetMapping("deleteProduct")
    @ResponseBody
    public Object deleteProduct(Product product) {
        try {
            this.productService.deleteProductById(product);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @PostMapping("deleteBatchProduct")
    @ResponseBody
    public ResultObj deleteBatchProduct(String[] ids) {
        try {
            this.productService.deleteProductByIds(ids);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
    /**
     * 添加商品
     * @param product
     * @return
     */
    @PostMapping("addProduct")
    @ResponseBody
    public ResultObj addProduct(Product product) {
        //设置时间
        product.setCreateTime(new Date());
        product.setLastEditTime(new Date());

        try {
            //如果不是默认图片就去掉图片的_temp的后缀
            if(!product.getImgAddr().equals(SysConstants.DEFAULT_PRODUCT_IMG)) {
                String filePath=AppFileUtils.updateFileName(product.getImgAddr(),SysConstants.FILE_UPLOAD_TEMP);
                product.setImgAddr(filePath);
            }
            productService.addProduct(product);
            return ResultObj.ADD_SUCCESS;
        } catch (O2OException e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 修改商品
     * @param product
     * @return
     */
    @PostMapping("updateProduct")
    @ResponseBody
    public ResultObj updateProduct(Product product) {
        //设置修改时间
        product.setLastEditTime(new Date());

        try {
            //如果不是默认图片就去掉图片的_temp的后缀
            if (!product.getImgAddr().equals(SysConstants.DEFAULT_PRODUCT_IMG)) {
                String filePath = AppFileUtils.updateFileName(product.getImgAddr(), SysConstants.FILE_UPLOAD_TEMP);
                product.setImgAddr(filePath);
            }
            productService.updateProduct(product);
            return ResultObj.UPDATE_SUCCESS;
        } catch (O2OException e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }


}

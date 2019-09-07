package cn.azzhu.o2o.controller;


import cn.azzhu.o2o.service.PriductCategoryService;
import cn.azzhu.o2o.utils.DataGrid;
import cn.azzhu.o2o.utils.DataGridView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("shop/shop")
public class ProductCategoryController {
    @Autowired
    private PriductCategoryService shopService;

    @GetMapping("shop.html")
    public String toList(){
        return "shop/shop";
    }

    @GetMapping("shop")
    @ResponseBody
    public DataGrid list(@RequestParam(value = "page",required = false,defaultValue = "1") Integer page,
                         @RequestParam(value = "limit",required = false,defaultValue = "5") Integer limit) {
        return shopService.getDataGrid(page,limit);
    }
}

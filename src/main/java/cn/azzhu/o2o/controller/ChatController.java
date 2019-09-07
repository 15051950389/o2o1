package cn.azzhu.o2o.controller;

import cn.azzhu.o2o.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("shop/chart")
public class ChatController {

    @Autowired
    private ChatService chatService;

    /**
     * 商品热销TOP5
     */
    @GetMapping("top5Product")
    @ResponseBody
    public Object getTop5product(@RequestParam(value = "month",required = false)String month,
                                @RequestParam(value = "startTime",required = false)String startTime,
                                 @RequestParam(value = "endTime",required = false)String endTime){
        Map<String,String> map = new HashMap<>();
        map.put("month",month);
        map.put("startTime",startTime);
        map.put("endTime",endTime);

        List<Map<String,Object>> top5Product = chatService.getTop5Product(map);
        return top5Product;
    }

    /**
     * 订单状态分析
     * @param month
     * @param startTime
     * @param endTime
     * @return
     */
    @GetMapping("order")
    @ResponseBody
    public Object getOrderStatus(@RequestParam(value = "month",required = false)String month,
                                 @RequestParam(value = "startTime",required = false)String startTime,
                                 @RequestParam(value = "endTime",required = false)String endTime){
        Map<String,String> map = new HashMap<>();
        map.put("month",month);
        map.put("startTime",startTime);
        map.put("endTime",endTime);

        Map<String,Integer> order = chatService.getOrderStatus(map);
        return order;
    }

    /**
     * 订单金额
     * @param month
     * @param startTime
     * @param endTime
     * @return
     */
    @GetMapping("money")
    @ResponseBody
    public Object getMoney(@RequestParam(value = "month",required = false)String month,
                                 @RequestParam(value = "startTime",required = false)String startTime,
                                 @RequestParam(value = "endTime",required = false)String endTime){
        Map<String,String> map = new HashMap<>();
        map.put("month",month);
        map.put("startTime",startTime);
        map.put("endTime",endTime);

        List<Map<String,Object>> money = chatService.getMoney(map);
        return money;
    }
    @GetMapping("/top5.html")
    public String top5(){
        return "chart/top5";
    }

    @GetMapping("/order.html")
    public String order(){
        return "chart/order";
    }

    @GetMapping("/money.html")
    public String money(){
        return "chart/money";
    }
}

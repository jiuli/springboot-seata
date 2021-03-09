package io.seata.sample.controller;

import io.seata.sample.entity.Order;
import io.seata.sample.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * @author
 */
@RestController
@RequestMapping(value = "order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 创建订单
     * @param order
     * @return
     */
    @PostMapping("create")
    public String create(Order order){
        orderService.create(order);
        return "Create order success";
    }

    /**
     * 修改订单状态
     * @param userId
     * @param money
     * @param status
     * @return
     */
    @RequestMapping("update")
    String update(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money, @RequestParam("status") Integer status){
        orderService.update(userId,money,status);
        return "订单状态修改成功";
    }
}

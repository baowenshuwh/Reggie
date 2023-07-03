package com.bao.reggie.service;

import com.bao.reggie.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;

public interface OrderService extends IService<Orders> {
    void submit(Orders orders);
}

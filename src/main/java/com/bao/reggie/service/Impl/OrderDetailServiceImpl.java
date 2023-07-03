package com.bao.reggie.service.Impl;

import com.bao.reggie.entity.OrderDetail;
import com.bao.reggie.mapper.OrderDetailMapper;
import com.bao.reggie.service.OrderDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {
}

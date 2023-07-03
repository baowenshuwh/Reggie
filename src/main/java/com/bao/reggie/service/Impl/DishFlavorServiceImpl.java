package com.bao.reggie.service.Impl;

import com.bao.reggie.entity.DishFlavor;
import com.bao.reggie.mapper.DishFlavorMapper;
import com.bao.reggie.service.DishFlavorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor> implements DishFlavorService {
}

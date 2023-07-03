package com.bao.reggie.service.Impl;

import com.bao.reggie.dto.DishDto;
import com.bao.reggie.entity.Dish;
import com.bao.reggie.entity.DishFlavor;
import com.bao.reggie.mapper.DishMapper;
import com.bao.reggie.service.DishFlavorService;
import com.bao.reggie.service.DishService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {
    @Autowired
    private DishFlavorService dishFlavorService;
    @Override
    public void saveWithFlavor(DishDto dishDto) {
        //将菜品数据保存到dish表中
        this.save(dishDto);
        //获取dishId
        Long dishId = dishDto.getId();
        //将获取到的dishId赋值给dishFlavor的dishId属性
        List<DishFlavor> flavors = dishDto.getFlavors();
        for (DishFlavor dishFlavor : flavors) {
            dishFlavor.setDishId(dishId);
        }
        //同时将菜品口味数据保存到dish_flavor表
        dishFlavorService.saveBatch(flavors);
    }
}

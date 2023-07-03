package com.bao.reggie.service.Impl;

import com.bao.reggie.common.CustomException;
import com.bao.reggie.entity.Category;
import com.bao.reggie.entity.Dish;
import com.bao.reggie.entity.Setmeal;
import com.bao.reggie.mapper.CategoryMapper;
import com.bao.reggie.service.CategoryService;
import com.bao.reggie.service.DishService;
import com.bao.reggie.service.SetmealService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    @Autowired
    private DishService dishService;

    @Autowired
    private SetmealService setmealService;

    @Override
    public void remove(Long id) {
        //1.判断当前分类和菜品的关联情况
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        //添加查询条件，根据分类id进行查询
        dishLambdaQueryWrapper.eq(Dish::getCategoryId, id);
        int count1 = dishService.count(dishLambdaQueryWrapper);
        //查询当前分类是否关联菜品，如果已经关联，抛出业务异常
        if (count1>0) {
            //已经关联菜品，抛出业务异常
            throw new CustomException("已经关联菜品，无法删除");
        }

        //1.判断当前分类和套餐的关联情况
        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        //添加查询条件，根据分类id进行查询
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId, id);
        int count2 = setmealService.count(setmealLambdaQueryWrapper);
        //查询当前分类是否关联套餐，如果已经关联，抛出业务异常
        if (count2>0) {
            //已经关联套餐，抛出业务异常
            throw new CustomException("已经关联套餐，无法删除");
        }

        //菜品和套餐都没关联，则可以直接删除
        super.removeById(id);
    }
}

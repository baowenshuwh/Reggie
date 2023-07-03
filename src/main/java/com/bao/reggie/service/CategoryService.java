package com.bao.reggie.service;

import com.bao.reggie.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;

public interface CategoryService extends IService<Category> {
    void remove(Long id);
}

package com.bao.reggie.dto;

import com.bao.reggie.entity.Setmeal;
import com.bao.reggie.entity.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
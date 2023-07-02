package com.bao.reggie.service.Impl;

import com.bao.reggie.entity.Employee;
import com.bao.reggie.mapper.EmployeeMapper;
import com.bao.reggie.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
}

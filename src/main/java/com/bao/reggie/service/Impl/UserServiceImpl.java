package com.bao.reggie.service.Impl;

import com.bao.reggie.entity.User;
import com.bao.reggie.mapper.UserMapper;
import com.bao.reggie.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}

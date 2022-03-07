package com.demo.mybatis_plus.mybatis_plus_demo.service.impl;

import com.demo.mybatis_plus.mybatis_plus_demo.entity.User;
import com.demo.mybatis_plus.mybatis_plus_demo.mapper.UserMapper;
import com.demo.mybatis_plus.mybatis_plus_demo.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jyz
 * @since 2022-03-06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}

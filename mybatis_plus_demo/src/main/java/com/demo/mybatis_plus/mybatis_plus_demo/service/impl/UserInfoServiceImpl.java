package com.demo.mybatis_plus.mybatis_plus_demo.service.impl;

import com.demo.mybatis_plus.mybatis_plus_demo.entity.UserInfo;
import com.demo.mybatis_plus.mybatis_plus_demo.mapper.UserInfoMapper;
import com.demo.mybatis_plus.mybatis_plus_demo.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 *
 * @author jyz
 * @since 2022-03-06
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

}

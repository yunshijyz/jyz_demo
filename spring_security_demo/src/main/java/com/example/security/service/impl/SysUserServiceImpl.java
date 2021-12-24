package com.example.security.service.impl;


import com.example.security.entity.SysUser;
import com.example.security.mapper.SysUserMapper;
import com.example.security.service.SysUserService;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements SysUserService {

    private SysUserMapper sysUserMapper;

    public SysUserServiceImpl(SysUserMapper sysUserMapper){
        this.sysUserMapper = sysUserMapper;
    }

    @Override
    public int insertUser(SysUser user) {
        return sysUserMapper.insertUser(user);
    }
}

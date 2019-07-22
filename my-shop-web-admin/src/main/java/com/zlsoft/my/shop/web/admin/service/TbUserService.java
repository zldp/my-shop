package com.zlsoft.my.shop.web.admin.service;

import com.zlsoft.my.shop.domain.TbUser;

import java.util.List;

public interface TbUserService {

    /**
     * 查询全部用户信息
     * @return
     */
    public List<TbUser> selectAll();

    TbUser login(String email, String password);
}
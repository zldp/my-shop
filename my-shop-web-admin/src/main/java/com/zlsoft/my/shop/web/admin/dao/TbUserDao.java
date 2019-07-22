package com.zlsoft.my.shop.web.admin.dao;

import com.zlsoft.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbUserDao {

    /**
     * 查询全部用户信息
     * @return
     */
    public List<TbUser> selectAll();

    /**
     * 增加
     * @param tbUser
     */
    public void insert(TbUser tbUser);

    /**
     * 删除
     * @param tbUser
     */
    void delete(TbUser tbUser);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    TbUser getById(long id);

    /**
     * 修改
     * @param tbUser
     */
    void update(TbUser tbUser);

    /**
     * 根据username模糊查询
     * @param username
     * @return
     */
    List<TbUser> selectByName(String username);

    TbUser selectByEmail(String email);
}
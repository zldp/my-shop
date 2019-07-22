package com.zlsoft.my.shop.web.admin.dao;

import com.zlsoft.my.shop.domain.TbUser;
import com.zlsoft.my.shop.web.admin.service.TbUserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml", "classpath:spring-context-druid.xml", "classpath:spring-context-mybatis.xml"})
public class TbUserDaoTest {

    @Autowired
    private TbUserService userService;

    @Autowired
    private TbUserDao userDao;
    @Before
    public void setUp() throws Exception {
    }
    @Test
    public void testSelectAll() {
        List<TbUser> tbUsers = userService.selectAll();
        for (TbUser tbUser : tbUsers) {
            System.out.println(tbUser.getUsername());
        }
    }

    @Test
    public void insert(){
        TbUser tbUser = new TbUser();
        tbUser.setEmail("admin@admin.com");
        tbUser.setPassword("admin");
        tbUser.setPhone("15888888888");
        tbUser.setUsername("Lusifer");
        tbUser.setCreated(new Date());
        tbUser.setUpdated(new Date());

        userDao.insert(tbUser);
    }

    @Test
    public void delete(){
        TbUser tbUser = new TbUser();
        tbUser.setId(37L);

        userDao.delete(tbUser);
    }

    @Test
    public void testGetById() {
        TbUser tbUser = userDao.getById(36L);
        System.out.println(tbUser.getUsername());
    }
    @Test
    public void testUpdate() {
        TbUser tbUser = userDao.getById(36L);
        tbUser.setUsername("Lusifer");

        userDao.update(tbUser);
    }

    @Test
    public void testSelectByName() {
        List<TbUser> tbUsers = userDao.selectByName("uni");
        for (TbUser tbUser : tbUsers) {
            System.out.println(tbUser.getUsername());
        }
    }
    @Test
    public void testMd5(){
        System.out.println(DigestUtils.md5DigestAsHex("123456".getBytes()));
    }
}
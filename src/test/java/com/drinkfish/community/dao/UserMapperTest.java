package com.drinkfish.community.dao;

import com.drinkfish.community.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * @author DrinkFish
 */
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectById() {
        User user = userMapper.selectById(1);
        System.out.println(user);
    }

    @Test
    public void testSelectByName() {
        User user = userMapper.selectByName("SYSTEM");
        System.out.println(user);
    }

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setUsername("张三啊");
        user.setPassword("123456");
        user.setSalt("abc");
        user.setEmail("zhangsan@qq.com");
        user.setHeaderUrl("http://www.nowcoder.com/101.png");
        user.setCreateTime(new Date());

        int row = userMapper.insertUser(user);
        System.out.println("row = " + row);
        System.out.println("用户id："+ user.getId());
    }

    @Test
    public void testUpdateStatus() {
        int row = userMapper.updateStatus(153, 1);
        System.out.println("row = " + row);
    }

    @Test
    public void testUpdateHeader() {
        int row = userMapper.updateHeader(153, "http://www.nowcoder.com/102.png");
        System.out.println("row = " + row);
    }

    @Test
    public void testUpdatePassword() {
        int row = userMapper.updatePassword(153, "654321");
        System.out.println("row = " + row);
    }
}

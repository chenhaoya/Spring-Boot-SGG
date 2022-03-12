package com.ch.admin;

import com.ch.admin.bean.UserMp;
import com.ch.admin.mapper.UserMpMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
class Boot05WebAdminApplicationTests {

    @Autowired
    DataSource dataSource;



    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void contextLoads() {
//        Long aLong = jdbcTemplate.queryForObject("select count(*) from aaa.tb_emp1", Long.class);
        Long aLong = jdbcTemplate.queryForObject("select concat(1) from aaa.tb_emp1", Long.class);
        log.info("记录总数：{}",aLong);

        log.info("数据源类型：{}",dataSource.getClass());
    }


    @Autowired
    UserMpMapper userMpMapper;

    @Test
    void testUserMpMapper(){
        UserMp userMp = userMpMapper.selectById(1L);
        UserMp userMp1 = new UserMp();
        userMp1.setName("aaa");
        userMp1.setAge(11);
        userMp1.setEmail("111@aaa");
        int insert = userMpMapper.insert(userMp1);
        log.info("插入了一个数据：{}",insert);

        log.info("用户信息：{}",userMp);
    }

    /**用于测试redis
     * 它用来操作redis的客户端
     * */
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisConnectionFactory redisConnectionFactory;

    @Test
    void testRedis(){
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        operations.set("hello","world");
        String hello = operations.get("hello");
        log.info("redis设置的值为：{}",hello);

        log.info("连接工厂类型：{}",redisConnectionFactory.getClass());
    }


}

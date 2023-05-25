package com.example.blog_system;

import com.example.blog_system.Mapper.StatisticMapper;
import com.example.blog_system.model.domain.Statistic;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class BlogSystemApplicationTests {
    @Autowired
    private StatisticMapper statisticMapper;
    @Test   //配置文件
    void contextLoads() {
        Statistic statistic=statisticMapper.selectStatisticWithArticleId(1);
        System.out.println(statistic);
    }


}

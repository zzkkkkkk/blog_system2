package com.example.blog_system;

import com.example.blog_system.Mapper.StatisticMapper;
import com.example.blog_system.model.domain.Article;
import com.example.blog_system.model.domain.Statistic;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class BlogSystemApplicationTests2 {

    @Autowired
    private StatisticMapper statisticMapper;

    @Test   //统计博客文章总评论量
    void testGetTotalComment() {
        long totalComment = statisticMapper.getTotalComment();
        System.out.println("统计博客文章总评论量: " + totalComment);
    }

    @Test   //博客文章访问量
    void testGetTotalVisit() {
        long totalVisit = statisticMapper.getTotalVisit();
        System.out.println("博客文章访问量：" + totalVisit);
    }
    @Test   //统计文章热度信息
    void testGetStatistic() {
        List<Statistic> statistics = statisticMapper.getStatistic();
        for (Statistic statistic : statistics) {
            System.out.println(statistic.getArticleId() + ": " + statistic.getHits() + ", " + statistic.getCommentsNum());
        }
    }
    @Test   // 新增一篇文章对应的统计信息
    void testAddStatistic() {
        Article article = new Article();
        article.setId(13);
        statisticMapper.addStatistic(article);
        // 新增文章对应的统计信息
        System.out.println("新增文章统计信息成功");
    }

    @Test   // 修改点击量
    void testUpdateArticleHitsWithId() {

        Statistic statistic = statisticMapper.selectStatisticWithArticleId(2);
        System.out.println("更新前点击量: " + statistic.getHits());

        statistic.setHits(50);
        // 更新统计信息
        statisticMapper.updateArticleHitsWithId(statistic);

        Statistic updatedStatistic = statisticMapper.selectStatisticWithArticleId(2);
        System.out.println("更新后点击量: " + updatedStatistic.getHits());


    }
    @Test   // 修改评论量
    void testUpdateArticleCommentsWithId() {
        // 获取文章对应的统计信息
        Statistic statistic = statisticMapper.selectStatisticWithArticleId(2);
        System.out.println("更新前评论量：" + statistic.getCommentsNum());

        statistic.setCommentsNum(50);
        statisticMapper.updateArticleCommentsWithId(statistic);

        // 验证评论量是否修改成功
        Statistic updatedStatistic = statisticMapper.selectStatisticWithArticleId(2);
        System.out.println("更新后评论量：" + updatedStatistic.getCommentsNum());
    }
    @Test   // 删除统计信息
    void testDeleteStatisticWithId() {

        statisticMapper.deleteStatisticWithId(13);

    }

}

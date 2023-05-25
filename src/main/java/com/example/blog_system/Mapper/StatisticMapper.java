package com.example.blog_system.Mapper;

import com.example.blog_system.model.domain.Article;
import com.example.blog_system.model.domain.Statistic;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface StatisticMapper {
    // 新增文章对应的统计信息
    @Insert("INSERT INTO t_statistic(article_id, hits, comments_num) VALUES (#{id}, 0, 0)")
    void addStatistic(Article article);

    // 根据文章id查询点击量和评论量相关信息
    @Select("SELECT * FROM t_statistic WHERE article_id=#{articleId}")
    Statistic selectStatisticWithArticleId(Integer articleId);

    // 通过文章id更新点击量
    @Update("UPDATE t_statistic SET hits=#{hits} WHERE article_id=#{articleId}")
    void updateArticleHitsWithId(Statistic statistic);

    // 通过文章id更新评论量
    @Update("UPDATE t_statistic SET comments_num=#{commentsNum} WHERE article_id=#{articleId}")
    void updateArticleCommentsWithId(Statistic statistic);

    // 根据文章id删除统计数据
    @Delete("DELETE FROM t_statistic WHERE article_id=#{aid}")
    void deleteStatisticWithId(int aid);

    // 统计文章热度信息
    @Select("SELECT * FROM t_statistic WHERE hits >= 1 ORDER BY hits " +
            "DESC, comments_num DESC")
    List<Statistic> getStatistic();

    // 统计博客文章访问量
    @Select("SELECT SUM(hits) FROM t_statistic")
    long getTotalVisit();

    // 统计博客文章总评论量
    @Select("SELECT SUM(comments_num) FROM t_statistic")
    long getTotalComment();
}

package com.kf.practice.dao;

import com.kf.practice.domain.jianshu.News;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/1/29
 */
@Repository
public interface NewsDao {

    //Todo
    @Select(" insert into tbl_news(id,title,author) values (#{id},#{title},#{author} ) ")
    public int save(News news);

}

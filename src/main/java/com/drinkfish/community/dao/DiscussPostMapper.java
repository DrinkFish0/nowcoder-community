package com.drinkfish.community.dao;

import com.drinkfish.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author DrinkFish
 */
@Mapper
public interface DiscussPostMapper {

    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    /**
     *  如果只有一个参数,并且在<if>里使用,则必须使用 @Param 加别名
     */
    int selectDiscussPostRows(@Param("userId") int userId);
}

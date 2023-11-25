package com.green.greengram2.feed;

import com.green.greengram2.feed.model.*;
import com.green.greengram2.user.model.SelFeedProDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedMapper {
    int insFeed(FeedInsProcDto dto);
    List<FeedSelVo> selFeedAll(FeedSelDto dto);
    Integer selFeed(FeedDelDto dto);
    int delFeed(FeedDelDto dto);
}

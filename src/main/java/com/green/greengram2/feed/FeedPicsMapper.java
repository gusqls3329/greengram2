package com.green.greengram2.feed;

import com.green.greengram2.feed.model.FeedDelDto;
import com.green.greengram2.feed.model.FeedInsProcDto;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedPicsMapper {
    int insFeedPics(FeedInsProcDto dto);
    List<String> selFeedPicsAll(int ifeed);

    int delFeedPicsByIfeed(FeedDelDto dto);
}

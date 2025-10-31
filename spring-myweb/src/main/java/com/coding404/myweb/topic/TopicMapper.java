package com.coding404.myweb.topic;

import com.coding404.myweb.command.TopicVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TopicMapper {
    int topicRegist(TopicVO topicVO);
}

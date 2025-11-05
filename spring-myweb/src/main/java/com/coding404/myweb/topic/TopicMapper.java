package com.coding404.myweb.topic;

import com.coding404.myweb.command.TopicVO;
import com.coding404.myweb.util.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TopicMapper {
    int topicRegist(TopicVO topicVO);
    List<TopicVO> getList(@Param("topicWriter") String topicWriter,
                          @Param("criteria") Criteria criteria);
    int getTotal(String topicWriter);
    List<TopicVO> getListAll(@Param("criteria") Criteria criteria);
    int getTotalAll(@Param("criteria") Criteria criteria);
    TopicVO getModify(long topicId);
    int topicUpdate(TopicVO topicVO);
    int topicDelete(long topicId);
}

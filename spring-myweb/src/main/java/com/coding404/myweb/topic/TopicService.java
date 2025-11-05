package com.coding404.myweb.topic;

import com.coding404.myweb.command.TopicVO;
import com.coding404.myweb.util.Criteria;

import java.util.List;

public interface TopicService {
    int topicRegist(TopicVO topicVO);
    List<TopicVO> getList(String topicWriter, Criteria criteria);
    int getTotal(String topicWriter);
    List<TopicVO> getListAll(Criteria criteria);
    int getTotalAll(Criteria criteria);
    TopicVO getModify(long topicId);
    int topicUpdate(TopicVO topicVO);
    int topicDelete(long topicId);
}

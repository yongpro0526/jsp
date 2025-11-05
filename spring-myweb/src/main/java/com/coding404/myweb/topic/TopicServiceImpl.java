package com.coding404.myweb.topic;

import com.coding404.myweb.command.TopicVO;
import com.coding404.myweb.util.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("topicService")
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicMapper topicMapper;

    @Override
    public int topicRegist(TopicVO topicVO) {
        return topicMapper.topicRegist(topicVO);
    }

    @Override
    public List<TopicVO> getList(String topicWriter, Criteria criteria) {
        return topicMapper.getList(topicWriter, criteria);
    }

    @Override
    public TopicVO getModify(long topicId) {
        return topicMapper.getModify(topicId);
    }

    @Override
    public List<TopicVO> getListAll(Criteria criteria) {
        return topicMapper.getListAll(criteria);
    }

    @Override
    public int topicUpdate(TopicVO topicVO) {
        return topicMapper.topicUpdate(topicVO);
    }

    @Override
    public int topicDelete(long topicId) {
        return topicMapper.topicDelete(topicId);
    }

    @Override
    public int getTotal(String topicWriter) {
        return topicMapper.getTotal(topicWriter);
    }

    @Override
    public int getTotalAll(Criteria criteria) {
        return topicMapper.getTotalAll(criteria);
    }
}

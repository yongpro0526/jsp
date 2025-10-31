package com.example.basic.chap05;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemoMapper {
    List<MemoVO> memoList();
    void memoRegist(MemoVO memoVO);
}

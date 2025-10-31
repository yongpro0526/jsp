package com.example.basic.chap05;

import java.util.List;

public interface MemoService {
    List<MemoVO> memoList();
    void memoRegist(MemoVO memoVO);
}

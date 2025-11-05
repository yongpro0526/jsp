package com.coding404.myweb.util;

import lombok.Data;

import java.util.List;
import java.util.stream.IntStream;

@Data // getter, setter, toString
public class PageVO {
    // 페이지네이션을 그리기 위한 클래스
    private int start; // 페이지네이션 시작번호
    private int end; // 페이지네이션 끝번호
    private boolean prev; // 이전버튼 활성화 여부
    private boolean next; // 다음버튼 활성화 여부
    private int page; // 현재 조회하고 있는 페이지번호
    private int amount; // 현재 조회하고 있는 데이터 개수
    private int total; // 전체 게시글 수
    private int realEnd; // 실제 끝번호
    private List<Integer> pageList; // 타임리프에서는 향상된 for문밖에 없어서 start에서 end까지 리스트에 저장하기 위한 목적

    // 생성자
    public PageVO(Criteria criteria, int total) {
        this.page = criteria.getPage();
        this.amount = criteria.getAmount();
        this.total = total;

        // 1. 페이지 끝번호 계산 - 올림(조회하는 페이지번호 / 페이지네이션 수) * 페이지네이션 수
        // 1 ~ 10번 페이지 조회 -> 끝 페이지네이션 10
        // 11 ~ 20번 페이지 조회 -> 끝 페이지네이션 20
        this.end = (int)Math.ceil(page / 10.0) * 10;

        // 2. 시작번호
        // this.start = 끝페이지번호 - 페이지네이션 수 + 1
        this.start = end - 10 + 1;

        // 3.진짜 끝번호를 재계산
        // 올림(전체 개시글 수 / 데이터개수
        this.realEnd = (int)Math.ceil(this.total / (double)amount);

        // 4. 맨 마지막 페이지네이션은 realEnd로 바꾸기.
        // 304개 게시물end -> 10, 20, 30, 40
        // realEnd -> 31
        if (this.end > this.realEnd) {
            this.end = this.realEnd;
        }

        // 5. 이전버튼 활성화 여부
        // 1일때만 true.
        this.prev = this.start > 1;

        // 6. 다음버튼 활성화 여부
        this.next = this.realEnd > this.end;

        // 7. 페이지리스트 초기화
        this.pageList = IntStream.rangeClosed(this.start, this.end).boxed().toList();
    }
}

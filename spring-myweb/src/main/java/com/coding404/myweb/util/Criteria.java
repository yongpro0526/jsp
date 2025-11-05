package com.coding404.myweb.util;

import lombok.Data;

@Data
public class Criteria {

    private int page; // 현재 페이지 번호
    private int amount; // 데이터 개수
    // 검색에 사용할 키워드
    private String searchName;
    private String searchContent;
    private String searchPrice;
    private String startDate;
    private String endDate;
    private String searchWriter;

    // 기본 생성자
    private Criteria() {
        this(1,10);
    }

    // 페이지 번호와 데이터 개수를 전달받는 생성자
    private Criteria(int page, int amount) {
        this.page = page;
        this.amount = amount;
    }

    // limit 함수에 offset값 계산하는 getter
    public int getPageStart(){
        return (page - 1) * amount;
    }
}

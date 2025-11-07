package com.coding404.myweb.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryVO {
    private int categoryId;
    private String groupId;
    private int categoryLv;
    private String categoryNm;
    private int categoryDetailLv;
    private String categoryDetailNm;
    public int categoryParentLv;
    public int categoryDetailParentLv;
}

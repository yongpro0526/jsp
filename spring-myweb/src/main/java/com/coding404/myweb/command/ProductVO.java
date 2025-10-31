package com.coding404.myweb.command;

import lombok.*;

import java.time.LocalDateTime;

// lombok이 있을 경우
//@Getter // Getter 생성
//@Setter // Setter 생성
//@ToString // toString 오버라이드해줌.
@Data // Getter, Setter, toString을 한 번에
@NoArgsConstructor // 기본생성자 생성
@AllArgsConstructor // 매개변수로 받는 생성자 생성
@Builder // 빌더패턴으로 객체생성을 제공해줌
public class ProductVO {
    private long prodId;
    private LocalDateTime prodRegdate;
    private String prodEnddate;
    private String prodCategory;
    private String prodWriter;
    private String prodName;
    private long prodPrice;
    private long prodCount;
    private long prodDiscount;
    private String prodPurchaseYn;
    private String prodContent;
    private String prodComment;
}

package com.example.basic.chap06;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SimpleVO {
    private int num;
    private String first;
    private String last;
    private LocalDateTime regdate;
}

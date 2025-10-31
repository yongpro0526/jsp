package com.coding404.myweb.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TopicVO {
    private long topicId;
    private String topicWriter;
    private String topicRegdate;
    private String topicName;
    private String topicContent;
}

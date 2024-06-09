package com.example.testb.notice.dto.response;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class NoticeResponse {

    private int rankNo;
    private int noticeId;
    private String title;
    private String content;
    private String createId;
    private String createAt;
}

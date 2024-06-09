package com.example.testb.notice.mapper;


import com.example.testb.notice.dto.request.NoticeRequest;
import com.example.testb.notice.dto.response.NoticeResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {
    List<NoticeResponse> selectNoticeList();

    NoticeResponse selectOneNotice(int noticeId);

    int updateDetail(NoticeRequest request);

    int deleteNotice(int noticeId);

    int insertNotice(NoticeRequest request);
}

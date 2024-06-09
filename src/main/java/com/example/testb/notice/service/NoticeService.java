package com.example.testb.notice.service;


import com.example.testb.notice.dto.request.NoticeRequest;
import com.example.testb.notice.dto.response.NoticeResponse;
import com.example.testb.notice.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeMapper noticeMapper;

    public List<NoticeResponse> selectNoticeList(){
        return noticeMapper.selectNoticeList();
    }

    public NoticeResponse selectOneNotice(int noticeId) {
        return noticeMapper.selectOneNotice(noticeId);
    }

    public int updateDetail(NoticeRequest request) {
        return noticeMapper.updateDetail(request);
    }

    public int deleteNotice(int noticeId) {
        return noticeMapper.deleteNotice(noticeId);
    }

    public int insertNotice(NoticeRequest request) {
        return noticeMapper.insertNotice(request);
    }
}

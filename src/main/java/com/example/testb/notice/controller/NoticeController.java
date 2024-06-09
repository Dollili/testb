package com.example.testb.notice.controller;


import com.example.testb.notice.dto.request.NoticeRequest;
import com.example.testb.notice.dto.response.NoticeResponse;
import com.example.testb.notice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/notice")
public class NoticeController {

    private final NoticeService noticeService;
    /** 목록 **/
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String notice(Model model){
        List<NoticeResponse> noticeResponse =
                noticeService.selectNoticeList();
        System.out.println("noticeResponse ==> " + noticeResponse);
        model.addAttribute("notices", noticeResponse);

        return "notice/notice";
    }

    @RequestMapping(value = "/notice-detail/{noticeId}", method = RequestMethod.GET)
    public String noticeDetail(@PathVariable("noticeId") int noticeId, Model model) {

        NoticeResponse noticeResponse = noticeService.selectOneNotice(noticeId);
        System.out.println("noticeDetail noticeResponse ==> " + noticeResponse);
        model.addAttribute("notice", noticeResponse);

        return "notice/noticeDetail";
    }

    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    @ResponseBody
    public int updateDetail(@RequestBody NoticeRequest noticeRequest) {
        System.out.println("updateDetail noticeRequest ==> " + noticeRequest);
        return noticeService.updateDetail(noticeRequest);
    }

    @DeleteMapping("/delete/{noticeId}")
    @ResponseBody
    public int deleteNotice(@PathVariable("noticeId") int noticeId) {
        System.out.println("deleteNotice noticeId ==> " + noticeId);
        return noticeService.deleteNotice(noticeId);
    }

    @RequestMapping(value = "/insert-view", method = RequestMethod.GET)
    public String noticeInsertView() {
        return "notice/noticeInsert";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public int insertNotice(@RequestBody NoticeRequest noticeRequest) {
        System.out.println("insertNotice noticeRequest ==> " + noticeRequest);
        return noticeService.insertNotice(noticeRequest);
    }
}

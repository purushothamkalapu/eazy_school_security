package com.purushotham.controller;

import com.mysql.cj.protocol.x.Notice;
import com.purushotham.entity.NoticeDetail;
import com.purushotham.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class NoticesController {
    @Autowired
    private NoticeRepository noticeRepository;

    @GetMapping("/notices")
    public ResponseEntity<List<NoticeDetail>> getNotices() {
        List<NoticeDetail> notices = noticeRepository.findAllActiveNotices();
        if (notices != null ) {
            return ResponseEntity.ok()
                    .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                    .body(notices);
        }else {
            return null;
        }
       // return null;
    }
}
package com.hostelassist.notices;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class NoticeService {
    private final List<Notice> notices;
    private Long nextId;
    public NoticeService(){
        this.notices = new ArrayList<>();
        this.nextId = 1L;
    }

    //Inserting New Notices
    public void createNotice(String title, String content){
        Notice notice = new Notice(nextId++, title, content);
        notices.add(notice);
    }

    //Printing All Notices
    public List<Notice> getAllNotices(){
        return notices;
    }

    //Getting Notices By Id
    public Notice getNoticeById(Long id){
        for (Notice notice:notices){
            if (notice.getId().equals(id)){
                return notice;
            }
        }
        return null;
    }

    //Delete Notice with Id
    public void deleteNotice(Long id){
        notices.removeIf(notice -> notice.getId().equals(id));
    }

}


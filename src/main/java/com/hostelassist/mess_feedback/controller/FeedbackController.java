package com.hostelassist.mess_feedback.controller;

import com.hostelassist.mess_feedback.model.FeedbackSummary;
import com.hostelassist.mess_feedback.model.FeedbackType;
import com.hostelassist.mess_feedback.service.FeedbackService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messfeedback")
public class FeedbackController {

    private final FeedbackService service;

    public FeedbackController(FeedbackService service) {
        this.service = service;
    }

    @PostMapping("/{type}")
    public String submitFeedback(@PathVariable FeedbackType type) {
        service.submitFeedback(type);
        return "Feedback submitted successfully";
    }

    @GetMapping()
    public FeedbackSummary getSummary() {
        return service.getSummary();
    }
}

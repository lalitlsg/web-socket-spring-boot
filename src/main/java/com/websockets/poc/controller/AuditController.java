package com.websockets.poc.controller;

import com.websockets.poc.model.AuditContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class AuditController {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    // sender sends data to this url and this method send data to receiver
    @MessageMapping("/audit-data")
    public AuditContent receiveAuditData(@Payload AuditContent auditContent) {
        simpMessagingTemplate.convertAndSendToUser(
            auditContent.getReceiverName(),
            "/audit",
            auditContent
        );
        return auditContent;
    }
}

package com.websockets.poc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuditContent {
    private String senderName;
    private String receiverName;
    private Object data;
    private Status status;
}

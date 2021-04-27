package com.smartclide.rabbitmq.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SmartClideMessage {

    private String messageId;
    private String message;
    private int num;
}

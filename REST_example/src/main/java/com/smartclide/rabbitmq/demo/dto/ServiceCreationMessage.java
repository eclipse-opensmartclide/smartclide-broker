package com.smartclide.rabbitmq.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ServiceCreationMessage {

    private String serviceId;
    private String serviceName;
    private String description;
    private String date;
    private String owner;
}

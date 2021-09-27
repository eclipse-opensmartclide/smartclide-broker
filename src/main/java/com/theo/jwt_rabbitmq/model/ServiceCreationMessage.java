package com.theo.jwt_rabbitmq.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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

/*******************************************************************************
 * Copyright (c) 2021 CERTH
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     theioakiti - initial API and implementation
 *******************************************************************************/
package com.example.websocket.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("eu.smartclide.broker")
@Getter
@Setter
@ToString(exclude = "password")
public class MessageBrokerConfig {

    public static final String WS_ENDPOINT = "/websocket";
    public static final String DESTINATION_PREFIX = "/exchange";
    public static final String EXCHANGE_NAME = "mom";

    private String host;
    private int port;
    private int stompPort;
    private String username;
    private String password;
    private String[] allowedOrigins;
}

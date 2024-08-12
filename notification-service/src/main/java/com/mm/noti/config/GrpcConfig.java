package com.mm.noti.config;

import net.devh.boot.grpc.client.autoconfigure.GrpcClientAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(GrpcClientAutoConfiguration.class)
public class GrpcConfig {

    private final ApplicationContext applicationContext;

    public GrpcConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }


}
package com.mm.noti;

//import net.devh.boot.grpc.server.autoconfigure.GrpcHealthServiceAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = "com.mm.noti.repository")
@EntityScan(basePackages = "com.mm.comm")
@ComponentScan(basePackages = {"com.mm.noti", "com.mm.comm"})
public class NotificationServiceApplication  {

    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApplication.class, args);
    }

//    @Bean
//    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer() {
//        return factory -> factory.setContextPath(MicroserviceBaseURI.NOTIFICATION);
//    }
}

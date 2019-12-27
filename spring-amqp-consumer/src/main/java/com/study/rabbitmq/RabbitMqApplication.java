package com.study.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author luhonggang
 *
 */
@SpringBootApplication
@EnableScheduling
public class RabbitMqApplication extends SpringBootServletInitializer /*implements CommandLineRunner*/ {

    public static void main( String[] args )
    {

       SpringApplication.run(RabbitMqApplication.class, args);
    }
}

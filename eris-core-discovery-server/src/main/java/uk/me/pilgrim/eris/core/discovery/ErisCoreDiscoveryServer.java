package uk.me.pilgrim.eris.core.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ErisCoreDiscoveryServer {

    public static void main(String[] args) {
        SpringApplication.run(ErisCoreDiscoveryServer.class, args);
    }
}
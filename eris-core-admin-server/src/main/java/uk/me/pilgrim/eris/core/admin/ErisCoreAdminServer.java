package uk.me.pilgrim.eris.core.admin;

import de.codecentric.boot.admin.server.cloud.discovery.EurekaServiceInstanceConverter;
import de.codecentric.boot.admin.server.cloud.discovery.ServiceInstanceConverter;
import de.codecentric.boot.admin.server.config.EnableAdminServer;
import de.codecentric.boot.admin.server.domain.values.Registration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableAdminServer
public class ErisCoreAdminServer {

    public static void main(String[] args) {
        SpringApplication.run(ErisCoreAdminServer.class, args);
    }


    @Bean
    ServiceInstanceConverter serviceInstanceConverter(){
        return new EurekaServiceInstanceConverter(){
            @Override
            public Registration convert(ServiceInstance instance) {
                return Registration.create(instance.getServiceId().toLowerCase(), getHealthUrl(instance).toString())
                        .managementUrl(getManagementUrl(instance).toString()).serviceUrl(getServiceUrl(instance).toString())
                        .metadata(getMetadata(instance)).build();
            }
        };
    }
}

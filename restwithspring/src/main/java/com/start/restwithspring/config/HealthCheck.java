package com.start.restwithspring.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.net.InetAddress;

@Component
public class HealthCheck implements HealthIndicator {

    @Override
    public Health health(){
        try{
            InetAddress adress = InetAddress.getByName("localhost");
            if(adress.isReachable(1000)){
                return Health.up().build();
            }
        }catch (Exception e){
            return Health.down().withDetail("reason", e.getMessage()).build();
        }
        return Health.down().withDetail("reason", "unknown reason").build();

    }



}

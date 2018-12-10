package com.poc.boldconnect.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class ServiceHealthIndicator implements HealthIndicator {
    public enum HealthStatus {
        GOOD(0), TANDEM_DOWN(1);
        private int value;

        private HealthStatus(int value) {
            this.value = value;
        }
    }

    @Override
    public Health health() {
        HealthStatus status = isHealthy();
        if (status.value != HealthStatus.GOOD.value) {
            return Health.down().withDetail("Error Code", status).build();
        }
        return Health.up().build();
    }

    private HealthStatus isHealthy(){
        // TODO implement what would make this service sick (Tandem down, redis down, missing dependency) 
        return HealthStatus.GOOD;
    }
}
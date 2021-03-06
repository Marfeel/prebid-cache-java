package org.prebid.cache.metrics;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Configuration
@ConfigurationProperties(prefix="metrics.graphite")
public class GraphiteConfig {
    private String host;
    private int port;
    private String prefix;
    private boolean enabled;
}

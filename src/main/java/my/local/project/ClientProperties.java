package my.local.project;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="client")
@Data
public class ClientProperties {
    private String url;
    private String basePath;
}

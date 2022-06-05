package shuffle.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LogService {

    @Value("${service.log.url}")
    private String serviceLogUrl;

    private final RestTemplate restTemplate;

    public LogService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }


    @Async("logTaskExecutor")
    public void logArray(int[] array) {
        restTemplate.postForObject(serviceLogUrl + "/log/log-service", array, ResponseEntity.class);
    }


}

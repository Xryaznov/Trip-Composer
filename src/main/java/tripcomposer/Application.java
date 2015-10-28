package main.java.tripcomposer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application implements CommandLineRunner {
    private final String url = "http://tripcomposer.net/rest/test/countries/get";
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Override
    public void run(String... strings) throws Exception {

        RestTemplate restTemplate = new RestTemplate();

        ServerResponse response = new ServerResponse();

        String t = restTemplate.postForObject(url, response, String.class);

        System.err.println(response.toString());

        System.err.println(t);
    }
}

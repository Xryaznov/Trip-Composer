//package main.java.tripcomposer;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.util.LinkedMultiValueMap;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.ArrayList;
//import java.util.List;
//
////@SpringBootApplication
//public class Application implements CommandLineRunner {
//    private final String url = "http://tripcomposer.net/rest/test/countries/get";
//    private static final Logger log = LoggerFactory.getLogger(Application.class);
//
//    public static void main(String[] args) {
//        SpringApplication.run(Application.class);
//    }
//
//    @Override
//    public void run(String... strings) throws Exception {
//        RestTemplate rest = new RestTemplate();
//
//        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
//        map.add("key", "");
//        map.add("echo", "all your base are belong to us");
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
//
//        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
//
//        messageConverters.add(new MappingJackson2HttpMessageConverter());
//
//        rest.setMessageConverters(messageConverters);
//
//        ServerResponse resp = rest.postForObject(url, request, ServerResponse.class);
//
//        log.info(resp.toString());
//    }
//}

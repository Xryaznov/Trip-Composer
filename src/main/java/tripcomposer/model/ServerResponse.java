package main.java.tripcomposer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServerResponse {
    private String type;
    private Long time;
    private Object countries;
    private String echo;
}

package main.java.tripcomposer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServerResponse {
    private String type;
    private String time;
    private String[] countries;
    private String[] cities;
    private String echo;
}

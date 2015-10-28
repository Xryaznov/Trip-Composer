package main.java.tripcomposer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {
    private String countryName;
    private String countryISOCode;
}

package main.java.tripcomposer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "country_seq_gen")
    @SequenceGenerator(name = "country_seq_gen", sequenceName = "country_id_seq")
    private Long id;
    private String countryISOCode;
    private String countryName;
    private String time;
    private String echo;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"id\"").append(":").append("\"" + id + "\"").append(",");
        sb.append("\"countryISOCode\"").append(":").append("\"" + countryISOCode + "\"").append(",");
        sb.append("\"countryName\"").append(":").append("\"" + countryName + "\"").append(",");
        sb.append("\"time\"").append(":").append("\"" + time + "\"").append(",");
        sb.append("\"echo\"").append(":").append("\"" + echo + "\"").append("}");
        return sb.toString();
    }
}

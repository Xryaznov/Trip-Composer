package main.java.tripcomposer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "city_seq_gen")
    @SequenceGenerator(name = "city_seq_gen", sequenceName = "city_id_seq")
    private Long id;
    private String cityName;
    private Long countryId;
}

package main.java.tripcomposer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ServerResponse {
    private String type;
    private String time;
    private String[] countries;
    private String[] cities;
    private String echo;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String[] getCountries() {
        return countries;
    }

    public void setCountries(String[] countries) {
        this.countries = countries;
    }

    public String[] getCities() {
        return cities;
    }

    public void setCities(String[] cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ServerResponse{");
        sb.append("type='").append(type).append('\'');
        sb.append(", time='").append(time).append('\'');
        sb.append(", countries=").append(Arrays.toString(countries));
        sb.append(", cities=").append(Arrays.toString(cities));
        sb.append('}');
        return sb.toString();
    }
}

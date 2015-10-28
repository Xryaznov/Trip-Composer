package main.java.tripcomposer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {
    private String countryName;
    private String countryISOCode;

    public Country() {
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryISOCode() {
        return countryISOCode;
    }

    public void setCountryISOCode(String countryISOCode) {
        this.countryISOCode = countryISOCode;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Country{");
        sb.append("countryName='").append(countryName).append('\'');
        sb.append(", countryISOCode='").append(countryISOCode).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

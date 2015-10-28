package main.java.tripcomposer;

public class City {
    private String cityName;

    public City() {
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("City{");
        sb.append("cityName='").append(cityName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

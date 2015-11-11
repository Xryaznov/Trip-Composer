package main.java.tripcomposer.controller;

import main.java.tripcomposer.model.City;
import main.java.tripcomposer.model.Country;
import main.java.tripcomposer.model.ServerResponse;
import main.java.tripcomposer.utils.HibernateUtil;
import org.hibernate.*;
import org.hibernate.criterion.Order;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class DataController {
    @SuppressWarnings("unchecked")
    @RequestMapping("/insert")
    public void insertData(@RequestParam String echo) {

        ServerResponse resp = new TripComposerController().getResponse(echo);
        List countries = (List) resp.getCountries();

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = null;

        try {
            session = sf.openSession();
            Transaction t = session.getTransaction();
            t.begin();

            for (Object o1 : countries) {
                Map<String, Object> map1 = (Map) o1;

                Country country = new Country();
                defineCountry(resp, map1, country);
                session.save(country);

                ArrayList cities = (ArrayList) map1.get("cities");

                for (Object o2 : cities) {
                    String cityName = (String) ((LinkedHashMap) o2).get("cityName");
                    session.flush();

                    City city = new City();
                    city.setCityName(cityName);
                    city.setCountryId(country.getId());
                    session.save(city);
                }
            }

            t.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @RequestMapping("/show")
    public List showData() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction t = session.getTransaction();

        try {
            t.begin();
            Query q = session.createSQLQuery("SELECT * FROM COUNTRY ORDER BY ID DESC LIMIT 20;")
                    .addEntity(Country.class);
            return q.list();
        } finally {
            t.commit();
            session.close();
        }
    }

    @RequestMapping("/showCities")
    public List showCitiesData(@RequestParam String id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction t = session.getTransaction();
        t.begin();
        try {
            Query q = session.createSQLQuery("SELECT CITYNAME FROM CITY WHERE COUNTRYID = " + id + ";");
            return q.list();
        } finally {
            t.commit();
            session.close();
        }
    }

    private void defineCountry(ServerResponse resp, Map<String, Object> map1, Country country) {
        country.setCountryName((String) map1.get("countryName"));
        country.setCountryISOCode((String) map1.get("countryISOCode"));

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss z");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+2"));

        country.setTime(sdf.format(new Date(resp.getTime())));
        country.setEcho(resp.getEcho());
    }


}

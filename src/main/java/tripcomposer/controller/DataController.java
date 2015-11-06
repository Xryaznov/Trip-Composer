package main.java.tripcomposer.controller;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.util.JSONPObject;
import main.java.tripcomposer.model.City;
import main.java.tripcomposer.model.Country;
import main.java.tripcomposer.model.ServerResponse;
import main.java.tripcomposer.utils.HibernateUtil;
import org.hibernate.*;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class DataController {
    @RequestMapping("/insert")
    public void insertData(@RequestParam String echo) {

        ServerResponse resp = new TripComposerController().getResponse(echo);
        List countries = (List) resp.getCountries();

        SessionFactory sf;
        Session session = null;

        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            session.beginTransaction();

            for (Object o1 : countries) {
                Map<String, Object> map1 = (Map) o1;

                Country country = new Country();
                defineCountry(resp, map1, country);
                session.save(country);

                ArrayList cities = (ArrayList) map1.get("cities");

                for (Object o2 : cities) {
                    String cityName = (String) ((LinkedHashMap) o2).get("cityName");
                    System.out.println(cityName);

                    City city = new City();
                    city.setCityName(cityName);
                    city.setCountryId(country.getId());
                    session.save(city);
                }
            }

            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }
    }

    @RequestMapping("/show")
    public List showData() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        Criteria criteria = session.createCriteria(Country.class);
        criteria.addOrder(Order.desc("id"));
        criteria.setMaxResults(20);

        return criteria.list();
    }

    private void defineCountry(ServerResponse resp, Map<String, Object> map1, Country country) {
        country.setCountryName((String) map1.get("countryName"));
        country.setCountryISOCode((String) map1.get("countryISOCode"));
        country.setTime(new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(new Date(resp.getTime())));
        country.setEcho(resp.getEcho());
    }


}

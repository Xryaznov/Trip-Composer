package main.java.tripcomposer.controller;

import main.java.tripcomposer.model.City;
import main.java.tripcomposer.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataController {
    @RequestMapping("/insert")
    public void insertData() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        City city = new City();
        city.setCityName("Kyiv");
        try {
            s.beginTransaction();
            s.save(city);
            s.getTransaction().commit();
        } catch (HibernateException e) {
            s.getTransaction().rollback();
        }
    }

    @RequestMapping("/show")
    public String showData() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Query q = s.createSQLQuery("select * from city;");

        s.beginTransaction();

        List list = q.list();
        s.close();

        StringBuilder sb = new StringBuilder();

        for (Object obj : list) {
            sb.append(String.valueOf(obj)).append("\n");
        }

        return sb.toString();
    }


}

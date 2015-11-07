package main.java.tripcomposer.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {

            Configuration cfg = new Configuration().configure();

            cfg.setProperty("hibernate.connection.url", System.getenv("DATABASE_URL"));
            cfg.setProperty("hibernate.connection.username", System.getenv("DATABASE_USER"));
            cfg.setProperty("hibernate.connection.password", System.getenv("DATABASE_PASS"));

            ServiceRegistry serviceRegistry
                    = new StandardServiceRegistryBuilder()
                    .applySettings(cfg.getProperties()).build();

            sessionFactory = cfg.buildSessionFactory(serviceRegistry);
        }

        return sessionFactory;
    }
}

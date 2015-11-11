package main.java.tripcomposer.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private static SessionFactory sf;

    public static SessionFactory getSessionFactory() {
        if (sf == null) {
            initSessionFactory();
        }
        return sf;
    }

    public static void initSessionFactory() {
        Configuration cfg = new Configuration();
         cfg.configure("hibernate.cfg.xml");
         cfg.setProperty("hibernate.connection.url", System.getenv("DB_URL"));
         cfg.setProperty("hibernate.connection.username", System.getenv("DATABASE_USER"));
         cfg.setProperty("hibernate.connection.password", System.getenv("DATABASE_PASS"));

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(cfg.getProperties()).build();
        sf = cfg.buildSessionFactory(serviceRegistry);
    }

    public static void closeSessionFactory() {
        if (sf != null && !sf.isClosed()) {
            sf.close();
        }
    }


}

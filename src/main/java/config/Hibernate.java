package config;

import domain.Category;
import domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class Hibernate {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {
            Properties settings = new Properties();
            settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
            settings.put(Environment.URL, "jdbc:mysql://localhost:3306/databaseName?characterEncoding=UTF-8");
            settings.put(Environment.USER, "root");
            settings.put(Environment.PASS, "password");
            settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");

            Configuration configuration = new Configuration();

                    configuration.addAnnotatedClass(Category.class)
                    .addAnnotatedClass(Product.class).setProperties(settings);

            ServiceRegistry serviceRegistry = new
                    StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory =
                    configuration.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }
}


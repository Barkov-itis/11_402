package ru.itis.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.DriverManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.repository.FilesRepository;
import ru.itis.repository.FilesRepositoryImpl;
import ru.itis.repository.UsersRepository;
import ru.itis.repository.UsersRepositoryJdbcImpl;
import ru.itis.services.*;

@WebListener
public class CustomServletContextListener implements ServletContextListener {


    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "gjhfqr102";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/testdb_11_402";
    private static final String DB_DRIVER = "org.postgresql.Driver";

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DB_DRIVER);
        dataSource.setUrl(DB_URL);
        dataSource.setUsername(DB_USERNAME);
        dataSource.setPassword(DB_PASSWORD);

        UsersRepository usersRepository = new UsersRepositoryJdbcImpl(dataSource);
        SignUpService signUpService = new SignUpServiceImpl(usersRepository);
        UsersService usersService = new UsersServiceImpl(usersRepository);
        FilesRepository filesRepository = new FilesRepositoryImpl(dataSource);
        FilesService filesService = new FilesServiceImpl(filesRepository);

        servletContext.setAttribute("usersRepository", usersRepository);
        servletContext.setAttribute("signUpService", signUpService);
        servletContext.setAttribute("usersService", usersService);
        servletContext.setAttribute("filesService", filesService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}

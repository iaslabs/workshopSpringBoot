package co.com.ias.projectBird.infrastructure.configuration;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

@Configuration
public class DataBaseConfig {

    @Bean
    public DbSecret secret(Environment environment){
        return new DbSecret(environment.getProperty("spring.datasource.username"),
                            environment.getProperty("spring.datasource.password"),
                            environment.getProperty("spring.datasource.url"));
    }

    /*@Bean
    @Profile("test")
    public DataSource dataSource(DbSecret dbSecret){
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(dbSecret.url());
        hikariConfig.setUsername(dbSecret.userName());
        hikariConfig.setPassword(dbSecret.password());
        hikariConfig.setDriverClassName("spring.datasource.driverClassName");
        return new HikariDataSource(hikariConfig);
    }*/

    @Bean
    @Profile("dev")
    public DataSource dataSourcePost(DbSecret dbSecret){
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(dbSecret.url());
        hikariConfig.setUsername(dbSecret.userName());
        hikariConfig.setPassword(dbSecret.password());
        return new HikariDataSource(hikariConfig);
    }

}

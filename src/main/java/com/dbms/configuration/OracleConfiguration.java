package com.dbms.configuration;

/**
 * Created by mengleisun on 3/14/16.
 */

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import javax.validation.constraints.NotNull;
import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;

/**
 * Un-comment the annoations to use the Oracle Java config
 */
@Configuration
@ConfigurationProperties("oracle")
public class OracleConfiguration {
    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String url;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Bean
    DataSource dataSource() throws SQLException {

        OracleDataSource dataSource = new OracleDataSource();
        dataSource.setUser(username);
        dataSource.setPassword(password);
        dataSource.setURL(url);
        dataSource.setImplicitCachingEnabled(false);
        dataSource.setFastConnectionFailoverEnabled(true);
        return dataSource;
    }
}

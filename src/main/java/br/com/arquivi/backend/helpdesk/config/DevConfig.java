package br.com.arquivi.backend.helpdesk.config;

import br.com.arquivi.backend.helpdesk.domain.services.DBServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
@RequiredArgsConstructor
public class DevConfig {

    private final DBServices dbServices;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddlAuto;

    @Bean
    public Boolean instanciaDB() {
        if (ddlAuto.equals("create")) {
            this.dbServices.instanceDB();
            return true;
        }
        return false;
    }
}

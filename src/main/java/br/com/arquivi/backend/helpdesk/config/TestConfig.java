package br.com.arquivi.backend.helpdesk.config;

import br.com.arquivi.backend.helpdesk.domain.services.DBServices;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
@RequiredArgsConstructor
public class TestConfig {

    private final DBServices dbServices;

    @Bean
    public void instanciaDB() {
        this.dbServices.instanceDB();
    }

}

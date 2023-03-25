package br.com.arquivi.backend.helpdesck.config;

import br.com.arquivi.backend.helpdesck.domain.services.DBServices;
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
    public void instanciaDB(){
        this.dbServices.instanceDB();
    }

}

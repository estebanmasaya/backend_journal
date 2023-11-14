package com.kth.estmm.backend_journal.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Bean
    public WebClient.Builder webClientBuilder(){
        return WebClient.builder();
    }

   @Bean
    public WebClient webClient(WebClient.Builder webClientBuilder){
        return webClientBuilder.baseUrl("https://hapi.fhir.org/baseR4/").build();
   }



}

package com.kth.estmm.backend_journal.Persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.kth.estmm.backend_journal.BO.Patient;
import com.kth.estmm.backend_journal.BO.Services.PatientFromJson;
import com.kth.estmm.backend_journal.BO.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@Repository
public class PatientRepository{
    public final WebClient webClient;
    private final ObjectMapper objectMapper;

    @Autowired
    public PatientRepository(WebClient webClient, ObjectMapper objectMapper){
        this.webClient = webClient;
        this.objectMapper = objectMapper;
    }

    public void getPatient(long id) {
        String jsonResult = webClient.get().uri("/Patient?_source=estamuelV2")
                .retrieve()
                .bodyToMono(String.class).block();


        System.out.println(jsonResult);
        try {
            JsonNode rootNode = objectMapper.readTree(jsonResult);
            JsonNode entryNode = rootNode.path("entry");
            System.out.println("A");
            if(entryNode.isArray()){
                System.out.println("B");
                for(JsonNode j : entryNode){
                    System.out.println("C");
                    Long patientId = j.at("/resource/id").asLong();
                    String name = j.at("/resource/name/0/given/0").asText() + " " +
                            j.at("/resource/name/0/family").asText();
                    String email = j.at("/resource/telecom/0").get("value").asText();
                    System.out.println(patientId + " " + name + " " + email);
                }

            }

/*

            if(entry.isArray()){
                for(JsonNode j : entry){
                    JsonNode name = j.path("resource").path("name");
                    if(name.isArray()){
                        for(JsonNode s : name){
                            System.out.println(s.path("family"));
                            if(s.path("given").isArray()){
                                for(JsonNode n : s.path("given")){
                                    System.out.println(n);
                                }
                            }
                        }

                    }

                }
            }

*/
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

       /* jsonResultMono.subscribe(
                jsonResult -> {
                    try {
                        JsonNode rootNode = objectMapper.readTree(jsonResult);

                        if (rootNode.has("entry") && rootNode.get("entry").isArray()) {
                            JsonNode entryNode = rootNode.get("entry").get(0);

                            String idValue = entryNode.at("/resource/id").asText();
                            String name = entryNode.at("/resource/name/0/given").get(0).asText() + " " +
                                    entryNode.at("/resource/name/0/family").asText();
                            String email = entryNode.at("/resource/telecom/0/value").asText();

                            System.out.println("Retrieved patient: " + idValue + ", " + name + ", " + email);
                        } else {
                            System.err.println("No patient data found");
                        }
                    } catch (Exception e) {
                        System.err.println("Error processing JSON: " + e.getMessage());
                    }
                },
                error -> {
                    System.err.println("Error retrieving patient: " + error.getMessage());
                },
                () -> {
                    System.out.println("Request completed");
                }
        );*/

    }

}

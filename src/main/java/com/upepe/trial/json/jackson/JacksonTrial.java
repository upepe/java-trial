package com.upepe.trial.json.jackson;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JacksonTrial.
 */
@Slf4j
public class JacksonTrial {

    public static void main(String[] args) throws Exception {
        Actor actor = Actor.builder().name("ted").age(20).gender(GenderType.MALE).build();
        ObjectMapper om = new ObjectMapper();

        // serialize
        String json = om.writeValueAsString(actor);
        log.info("serialization json[{}]", json);

        // deserialize
        Actor deserializationActor = om.readValue(json, Actor.class);
        log.info("deserialization actor[{}]", actor);
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Actor {
        private String name;
        private Integer age;
        private GenderType gender;
    }

    public static enum GenderType {
        MALE, FEMALE;
    }
}

package com.upepe.trial.json.gson;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

/**
 * GsonTrial.
 */
@Slf4j
public class GsonTrial {

    public static void main(String[] args) throws Exception {
        Actor actor = Actor.builder().name("ted").age(20).gender(GenderType.MALE).nickname(null).build();
        Gson gson = new Gson();

        // serialize
        String json = gson.toJson(actor);
        log.info("serialization json[{}]", json);

        // deserialize
        Actor deserializationActor = gson.fromJson(json, Actor.class);
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
        private String nickname;
    }

    public static enum GenderType {
        MALE, FEMALE;
    }
}

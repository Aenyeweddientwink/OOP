package io.github.aenyeweddientwink;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) throws JsonProcessingException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        Note mynote = new Note("Note1","Hello, world!", "17.12.2019 13:00");
        String json = objectMapper.writeValueAsString(mynote);
        System.out.println(json);

        File file = new File("/Test.json");

        Note note= objectMapper.readValue(file, Note.class);

        System.out.println(note.toString());

    }

}

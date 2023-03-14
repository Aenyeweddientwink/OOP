package io.github.aenyeweddientwink;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Diary that can contain notes and do multiple operations with them
 */
public class Diary {
    private static List<Note> notes;

    private static ObjectMapper mapper = null;

    public Diary(){
        notes = new ArrayList<Note>();
    }


}
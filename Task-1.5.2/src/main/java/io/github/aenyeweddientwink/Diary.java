package io.github.aenyeweddientwink;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;


import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class Diary that can contain notes and do multiple operations with them
 */
public class Diary {
    private static List<Note> notes;

    private static ObjectMapper mapper = null;

    /**
     * Constructor
     */
    public Diary(){
        notes = new ArrayList<Note>();
        mapper = JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .build();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    /**
     * adds a note
     * @param title title of the note
     * @param text text of the note
     */
    public void addNote(String title,String text){
        Note note = new Note(title,text, LocalDateTime.now());
        notes.add(note);
    }

    /**
     * removes a note
     * @param title title of the node that has to be removed
     */
    public void removeNote(String title){
        notes.removeIf(x->x.getTitle().equals(title));
    }

    /**
     * Get all notes
     * @return List of all notes
     */
    public List<Note> getNotes() {
        return notes;
    }
    /**
     * get notes from from to to and with at least one keyword
     * @param from from which time
     * @param to to which time
     * @param keywords keywords to look for
     * @return
     */
    public List<Note> getNotes(LocalDateTime from, LocalDateTime to, String[] keywords){
        return notes
                .stream()
                .filter(x->x.getTimestamp().isAfter(from)
                && x.getTimestamp().isBefore(to)
                && Arrays.stream(keywords).anyMatch(
                        y -> x.getText().contains(y)))
                .collect(Collectors.toList());

    }

    /**
     * loads notes from a json file
     * @throws IOException
     */
    public void loadNotes() throws IOException {
        notes = Arrays.asList(mapper.readValue(Paths.get("notebook.json").toFile(), Note[].class));
    }

    /**
     * saves notes to a json file
     */
    public void saveNotes() throws IOException {
        mapper.writeValue(Paths.get("notebook.json").toFile(), notes);
    }



}
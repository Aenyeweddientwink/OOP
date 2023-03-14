package io.github.aenyeweddientwink;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOError;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Tests of Diary and Note classes
 */
public class DiaryTest {
    @Test
    public void simpleTest() throws IOException{
        Diary diary = new Diary();
        diary.addNote("Title", "Hello, World!");
        diary.saveNotes();
        Assertions.assertEquals("Hello, World!", diary.getNotes().get(0).getText());
        diary.removeNote("Title");
        Assertions.assertEquals(0,diary.getNotes().size());
        diary.addNote("Title", "Hello, World!");
        diary.addNote("Title", "Bye, World!");
        LocalDateTime time = diary.getNotes().get(0).getTimestamp();
        List<Note> notes = diary.getNotes(time.minusMinutes(2), time.plusMinutes(1), new String[]{"World!"});
        Assertions.assertEquals(2, notes.size());
        Assertions.assertEquals("Hello, World!", notes.get(0).getText());
        diary.saveNotes();

    }

}

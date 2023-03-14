package io.github.aenyeweddientwink;

import java.time.LocalDateTime;
/**
 * Class Note, a basic Note in a diary
 * Attributes:
 *  Timestamp - Date and time of the Note
 *  Title - Title of the note
 *  Text - Text of the note
 */
public class Note {

    private final String timestamp;
    private final String title;
    private final String text;

    /**
     * Note constructor
     * @param title Title of the note
     * @param text Text of the note
     * @throws NullPointerException
     */
    public Note(String title, String text, String timestamp) throws  NullPointerException{
        if ((title ==null) || (text == null) || (timestamp == null)){
            throw new NullPointerException("Title, text and timestamp must be non-null");
        }
        this.title = title;
        this.text = text;
        this.timestamp = timestamp;
    }

    @Override
    public String toString(){
        return (timestamp + " " + this.title + " " + this.text + "\n");
    }

    public String getTitle(){
        return (this.title);
    }

    public String getText(){
        return (this.text);
    }

    public String getTimestamp(){
        return (this.timestamp);
    }



}

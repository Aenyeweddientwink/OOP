package io.github.aenyeweddientwink;

/**
 * Record class
 */
public class Record {
    public String subject;
    public String teacher;
    public int mark;
    public int semester;

    /**
     * Creates a record
     * @param subject name of the subject
     * @param teacher name of the teacher
     * @param mark mark:
     *             5 - Excellent
     *             4 - Good
     *             3 - Satisfactory
     * @param semester number of the semester
     */
    public Record(String subject, String teacher, int mark, int semester){
        this.subject = subject;
        this.teacher = teacher;
        this.mark = mark;
        this.semester = semester;
    }

}
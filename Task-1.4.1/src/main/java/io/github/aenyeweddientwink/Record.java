package io.github.aenyeweddientwink;

/**
 * Record class has attributes:
 * name of the subject
 * name of the teacher
 * mark:
 *             5 - Excellent
 *             4 - Good
 *             3 - Satisfactory
 * semester -  number of the semester
 * credit - has values PASSED, FAILED, SCORED.
 *  PASSED means that subject was passed
 *  FAILED means that subject was failed
 *  SCORED means that subject is not a credit but a scored mark
 */
public class Record {
    private final String subject;
    private final String teacher;
    private final int mark;
    private final int semester;
    private final Credit credit;

    public Record(String subject, String teacher, int mark, int semester){
        this.subject = subject;
        this.teacher = teacher;
        this.mark = mark;
        this.credit = Credit.SCORED;
        this.semester = semester;
    }

    public Record(String subject, String teacher, Credit credit, int semester){
        this.subject = subject;
        this.teacher = teacher;
        this.mark = -1;
        this.credit = credit;
        this.semester = semester;
    }

    public int getSemester(){
        return this.semester;
    }

    public int getMark(){
        return this.mark;
    }

    public Credit getCredit(){
        return this.credit;
    }
    /**
     *  pass or fail type of score called CREDIT
     */
    public enum Credit{
        PASSED, FAILED, SCORED
    }
}

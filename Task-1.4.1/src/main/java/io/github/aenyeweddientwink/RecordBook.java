package io.github.aenyeweddientwink;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for a Record Book. It contains credits and marks of a certain student
 * Attributes:
 *  Name - name of the student
 *  Surname - surname of the student
 *  Records - list of records of the student
 *  Semester - current semester
 *  QualificationScore - score of the qualification work
 */
public class RecordBook {
    private final String Name;
    private final String Surname;
    private final List<Record> records;
    private int semester;

    private int qualificationScore;

    /**
     * Creation of a Record Book
     */
    public RecordBook(String Name, String Surname, int semester){
        this.Name = Name;
        this.Surname = Surname;
        this.semester = semester;
        this.records = new ArrayList<>();
        this.qualificationScore = -1;
    }

    public void changeSemester(int newsemester){
        this.semester = newsemester;
    }

    public int getSemester(){
        return this.semester;
    }

    public void setQualificationScore(int qualificationScore){
        this.qualificationScore = qualificationScore;
    }

    public int getQualificationScore(int qualificationScore){
        return this.qualificationScore;
    }

    public void addRecord(Record Record1){
        records.add(Record1);
    }

    public void addRecord(String subject, String teacher, int mark, int semester){
        records.add(new Record(subject,teacher,mark,semester));
    }

    public void addRecord(String subject, String teacher, Record.Credit credit, int semester){
        records.add(new Record(subject,teacher,credit,semester));
    }

    public List<Record> getRecords() {
        return records;
    }

    /**
     * Method
     * @return All Time average mark
     */
    public float AlltimeaverageMark(){
        float result = 0F;
        for (Record record: records){
            if (record.getCredit() == Record.Credit.SCORED) {
                result += (((float) record.getMark()) / (float) records.size());
            }
        }
        return result;
    }

    /**
     * Method
     * @param semester number of the semester
     * @return Average mark in that semester
     */
    public float SemesterAverageMark(int semester){
        float result = 0F;
        int numberofrecords = 0;
        for (Record record : records){
            if (record.getSemester() == semester && record.getCredit() == Record.Credit.SCORED){
                result += (float) record.getMark();
                numberofrecords +=1;
            }
        }
        result = result / (float) numberofrecords;
        return result;
    }

    /**
     * Method returns if a student is able to finish with honors
     * @return true if yes false if no
     */
    public boolean isAbletofinishwithHonors(){
        // no 3s at all
        for (Record record : records){
            if (record.getMark() == 3){
                return false;
            }
        }

        //5s are 75% of marks for the last semester
        if (this.SemesterAverageMark(this.semester) < 4.75) {
            return false;
        }

        //final record must be 5
        if (this.qualificationScore != 5) {
            return false;
        }
        return true;
    }

    /**
     * Determines if the student can get an increased Stipend( has to have 5.0 average mark in the previous semester)
     * @return true if yes, false if no
     */
    public boolean isAbletogetIncreasedStipend(){
        if (this.semester == 1){
            return false;
        }
        return (SemesterAverageMark(this.semester - 1) == 5.0);
    }



}


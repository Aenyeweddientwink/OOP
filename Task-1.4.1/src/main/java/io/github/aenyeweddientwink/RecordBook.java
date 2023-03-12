package io.github.aenyeweddientwink;

import java.util.ArrayList;
import java.util.List;

public class RecordBook {
    private final String Name;
    private final String Surname;
    private final List<Record> records;
    private int semester;

    /**
     * Creation of a Record Book
     * @param Name Name of the student
     * @param Surname Surname of the student
     * @param semester number of semester
     */
    public RecordBook(String Name, String Surname, int semester){
        this.Name = Name;
        this.Surname = Surname;
        this.semester = semester;
        this.records = new ArrayList<>();
    }

    public void changeSemester(int newsemester){
        this.semester = newsemester;
    }

    public int getSemester(){
        return this.semester;
    }

    public void addRecord(Record Record1){
        records.add(Record1);
    }

    public void addRecord(String subject, String teacher, int mark, int semester){
        records.add(new Record(subject,teacher,mark,semester));
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
            result+= (((float) record.mark) / (float) records.size());
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
            if (record.semester == semester){
                result += (float) record.mark;
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
            if (record.mark == 3){
                return false;
            }
        }

        //5s are 75% of marks for the last semester
        if (this.SemesterAverageMark(this.semester) < 4.75) {
            return false;
        }

        //final record must be 5
        if (records.get(records.size()-1).mark !=5) {
            return false;
        }
        return true;
    }

    public boolean isAbletogetIncreasedStipend(){
        if (this.semester == 1){
            return false;
        }
        return (SemesterAverageMark(this.semester - 1) == 5.0);
    }



}


package io.github.aenyeweddientwink;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
    public double AlltimeaverageMark(){
        return records
                    .stream()
                    .filter(x-> x.getCredit() == Record.Credit.SCORED)
                    .mapToDouble(Record::getMark)
                    .average()
                    .orElse(0);
    }

    /**
     * Method
     * @param semester number of the semester
     * @return Average mark in that semester
     */
    public double SemesterAverageMark(int semester){
        return records
                .stream()
                .filter(x-> x.getCredit() == Record.Credit.SCORED)
                .filter(x->x.getSemester() == semester)
                .mapToDouble(Record::getMark)
                .average()
                .orElse(0);
    }

    /**
     * Method returns if a student is able to finish with honors
     * @return true if yes false if no
     */
    public boolean isAbletofinishwithHonors(){
        //Qual score should be 5
        if (this.qualificationScore != 5){
            return false;
        }
        // no 3s at all
        boolean hasthrees = records
                .stream()
                .filter(x->x.getCredit() == Record.Credit.SCORED)
                .anyMatch(x->x.getMark() == 3);
        if (hasthrees == true){
            return false;
        }
        //count average
        RecordComparator MyRecordComparator = new RecordComparator();
        double average=records
                .stream()
                .filter(x-> x.getCredit() == Record.Credit.SCORED)
                .sorted(MyRecordComparator)
                .map(RecordWrapper::new)
                .distinct()
                .map(RecordWrapper::unwrap)
                .mapToDouble(Record::getMark)
                .average()
                .orElse(0);
        if (average < 4.75){
            return false;
        }
        else{
            return true;
        }
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


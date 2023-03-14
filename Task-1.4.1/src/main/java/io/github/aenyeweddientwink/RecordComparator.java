package io.github.aenyeweddientwink;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

public class RecordComparator implements Comparator<Record> {
    @Override
    public int compare(Record record1, Record record2) throws NullPointerException{
        return record1.compareTo(record2);
    }
}

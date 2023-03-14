package io.github.aenyeweddientwink;

import java.util.Objects;

public class RecordWrapper {
    private final Record record;
    public RecordWrapper(Record record) {
        this.record = record;
    }
    public Record unwrap() {
        return record;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof RecordWrapper) {
            return ((RecordWrapper) obj).record.getSubject().equals(record.getSubject());
        }else {
            return false;
        }
    }
    @Override
    public int hashCode() {
        return record.getSubject().hashCode();
    }
}

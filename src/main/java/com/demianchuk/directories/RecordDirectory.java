package com.demianchuk.directories;

import com.demianchuk.models.Record;

import java.time.*;
import java.util.*;
import java.util.stream.Collectors;

public class RecordDirectory {

    private static RecordDirectory recordDirectory;
    private List<Record> records = new ArrayList<>();

    private RecordDirectory() {}

    public static RecordDirectory getInstance() {
        if(recordDirectory == null) {
            recordDirectory = new RecordDirectory();
        }
        return recordDirectory;
    }

    public void addRecord(Record record) {
        records.add(record);
    }

    public List<Record> getRecordsByType(Record.Type type){
        return records.stream()
                .filter(r -> r.getType().equals(type))
                .collect(Collectors.toList());
    }

    public List<Record> getRecordsByTypeAndDate(Record.Type type, LocalDate date) {
        return records.stream()
                .filter(r -> r.getType().equals(type) &&  r.getDate().equals(date))
                .collect(Collectors.toList());
    }

    public List<Record> getRecordsByTypeAndMonth(Record.Type type, Month month) {
        return records.stream()
                .filter(r -> r.getType().equals(type) &&  r.getMonth().equals(month))
                .collect(Collectors.toList());
    }

    public List<Record> getRecordsByTypeAndYear(Record.Type type, int year) {
        return records.stream()
                .filter(r -> r.getType().equals(type) &&  r.getYear() == year)
                .collect(Collectors.toList());
    }

    public List<Record> getAllRecords() {
        return records;
    }

    public void removeAllRecords() {
        records.clear();
    }
}

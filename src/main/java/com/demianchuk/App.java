package com.demianchuk;

import com.demianchuk.directories.RecordDirectory;
import com.demianchuk.models.Record;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        RecordDirectory recordDirectory = RecordDirectory.getInstance();
        recordDirectory.addRecord(new Record(Record.Type.Expense, LocalDate.now(), 10.23, "Electricity", "ComEd"));
        recordDirectory.addRecord(new Record(Record.Type.Expense, LocalDate.of(2005, 2, 21),166.5, "Gas", "Shell"));
        recordDirectory.addRecord(new Record(Record.Type.Expense, LocalDate.now(),45.60, "Water", "AFs"));


        List<Record> recordList = recordDirectory.getRecordsByTypeAndMonth(Record.Type.Expense, Month.MAY);
        for(Record record : recordList) {
            System.out.println(record);
        }
    }
}

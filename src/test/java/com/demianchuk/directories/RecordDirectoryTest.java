package com.demianchuk.directories;

import com.demianchuk.models.Record;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.junit.Assert.*;

public class RecordDirectoryTest {

    RecordDirectory recordDirectory;

    @Before
    public void setUp() {
        recordDirectory = RecordDirectory.getInstance();
        recordDirectory.removeAllRecords();
        this.addRecords();
    }

    @Test
    public void getInstance() {
        RecordDirectory recordDirectory2 = RecordDirectory.getInstance();

        assertNotNull(recordDirectory);
        assertNotNull(recordDirectory2);
        assertEquals(recordDirectory, recordDirectory2);
    }

    @Test
    public void addRecord() {
        recordDirectory.addRecord(new Record(Record.Type.Expense, LocalDate.of(2018, 5, 24), 100, "Beauty", "Massage"));
        List<Record> records = recordDirectory.getAllRecords();

        assertNotNull(records);
        assertEquals(13, records.size());
        recordDirectory.removeAllRecords();
    }

    @Test
    public void getRecordsByType() {
        List<Record> expenses = recordDirectory.getRecordsByType(Record.Type.Expense);
        List<Record> incomes = recordDirectory.getRecordsByType(Record.Type.Income);

        assertNotNull(expenses);
        assertNotNull(incomes);
        assertNotEquals(expenses, incomes);
        assertEquals(4, incomes.size());
        assertEquals(8, expenses.size());
    }

    @Test
    public void getRecordsByTypeAndDate() {
        List<Record> expenses = recordDirectory.getRecordsByTypeAndDate(Record.Type.Expense, LocalDate.of(2018, 5, 1));

        assertNotNull(expenses);
        assertEquals(2, expenses.size());
    }

    @Test
    public void getRecordsByTypeAndMonth() {
        List<Record> incomes = recordDirectory.getRecordsByTypeAndMonth(Record.Type.Income, Month.MAY);

        assertNotNull(incomes);
        assertEquals(3, incomes.size());
    }

    @Test
    public void getRecordsByTypeAndYear() {
        List<Record> expenses = recordDirectory.getRecordsByTypeAndYear(Record.Type.Expense, 2018);

        assertNotNull(expenses);
        assertEquals(7, expenses.size());
    }

    @Test
    public void getAllRecords() {
        List<Record> records = recordDirectory.getAllRecords();

        assertNotNull(records);
        assertEquals(12, records.size());
    }

    @Test
    public void removeAllRecords() {
        recordDirectory.removeAllRecords();

        assertNotNull(recordDirectory);
        assertEquals(0, recordDirectory.getAllRecords().size());
    }

    private void addRecords() {

        recordDirectory.addRecord(new Record(Record.Type.Expense, LocalDate.of(2018, 5, 24), 10.5, "Groceries", "Milk and cereal"));
        recordDirectory.addRecord(new Record(Record.Type.Expense, LocalDate.of(2018, 4, 21), 20, "Beauty", "Haircut"));
        recordDirectory.addRecord(new Record(Record.Type.Expense, LocalDate.of(2018, 5, 11), 4.38, "Transportation", "Lyft"));
        recordDirectory.addRecord(new Record(Record.Type.Expense, LocalDate.of(2018, 5, 16), 25, "Lunch", "Salad and coffee"));
        recordDirectory.addRecord(new Record(Record.Type.Expense, LocalDate.of(2017, 4, 15), 95.15, "Groceries", "WholeFoods shopping"));
        recordDirectory.addRecord(new Record(Record.Type.Expense, LocalDate.of(2018, 5, 18), 5.96, "Transportation", "Uber"));
        recordDirectory.addRecord(new Record(Record.Type.Expense, LocalDate.of(2018, 5, 1), 125.66, "Bills", "Electricity and gas"));
        recordDirectory.addRecord(new Record(Record.Type.Expense, LocalDate.of(2018, 5, 1), 700, "Bills", "Rent"));

        recordDirectory.addRecord(new Record(Record.Type.Income, LocalDate.of(2018, 5, 6), 50, "Garage sale", "Old bike"));
        recordDirectory.addRecord(new Record(Record.Type.Income, LocalDate.of(2018, 5, 6), 70, "Garage sale", "TV"));
        recordDirectory.addRecord(new Record(Record.Type.Income, LocalDate.of(2018, 4, 24), 250, "Lottery", "Pure luck"));
        recordDirectory.addRecord(new Record(Record.Type.Income, LocalDate.of(2018, 5, 6), 185, "Garage sale", "PSP console"));
    }
}
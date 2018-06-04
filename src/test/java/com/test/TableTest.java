package com.test;

import org.junit.Test;

import static org.junit.Assert.*;

public class TableTest {

    @Test
    public void getFields() {
        String[]Fields=new String[]{"Field_0", "Field_1", "Field_2"};
        Table table=new Table(Fields);
        String[]Actual = table.getFields();
        String[]Expected =new String[]{"Field_0", "Field_1", "Field_2"};;
        assertArrayEquals(Actual,Expected);
    }

    @Test
    public void getRecord() {
        String[]Fields=new String[]{"Field_0", "Field_1", "Field_2"};
        String[] Record1 = new String[]{"Record_00", "Record_01", "Record_02"};
        String[] Record2 = new String[]{"Record_10", "Record_11", "Record_12"};
        Table table=new Table(Fields);
        table.addRecord(Record1);
        table.addRecord(Record2);
        String[]Actual = table.getRecord(1);
        String[]Expected =new String[]{"Record_10", "Record_11", "Record_12"};
        assertArrayEquals(Actual,Expected);

    }

    @Test
    public void findField() {
        String[]Fields=new String[]{"Field_0", "Field_1", "Field_2"};
        String[] Record1 = new String[]{"Record_00", "Record_01", "Record_02"};
        String[] Record2 = new String[]{"Record_10", "Record_11", "Record_12"};
        Table table=new Table(Fields);
        table.addRecord(Record1);
        table.addRecord(Record2);

        Integer Actual = table.findField("Field_2");
        Integer Expected = 2;
        assertEquals(Actual,Expected);
    }

    @Test
    public void isRecordRight() {
        String[]Fields=new String[]{"Field_0", "Field_1", "Field_2"};
        String[] Record1 = new String[]{"Record_00", "Record_01", "Record_02"};
        String[] Record2 = new String[]{"Record_10", "Record_11", "Record_12"};
        Table table=new Table(Fields);
        table.addRecord(Record1);
        table.addRecord(Record2);

        Boolean Actual = table.isRecordRight(1 ,1,"Record_11");
        Boolean Expected = true;
        assertEquals(Actual,Expected);
    }

    @Test
    public void size() {
        String[]Fields=new String[]{"Field_0", "Field_1", "Field_2"};
        String[] Record1 = new String[]{"Record_00", "Record_01", "Record_02"};
        String[] Record2 = new String[]{"Record_10", "Record_11", "Record_12"};
        Table table=new Table(Fields);
        table.addRecord(Record1);
        table.addRecord(Record2);

        Integer Actual = table.size();
        Integer Expected = 2;
        assertEquals(Actual,Expected);
    }

    @Test
    public void numberOfFields() {
        String[]Fields=new String[]{"Field_0", "Field_1", "Field_2"};
        String[] Record1 = new String[]{"Record_00", "Record_01", "Record_02"};
        String[] Record2 = new String[]{"Record_10", "Record_11", "Record_12"};
        Table table=new Table(Fields);
        table.addRecord(Record1);
        table.addRecord(Record2);

        Integer Actual = table.numberOfFields();
        Integer Expected = 3;
        assertEquals(Actual,Expected);
    }
}
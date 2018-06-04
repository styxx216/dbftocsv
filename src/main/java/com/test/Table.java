package com.test;

import java.sql.BatchUpdateException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Table {
    private String[] Fields;
    private List<String[]> Record = new ArrayList<String[]>();
    public Table(String[] fields){

        Fields= fields;
    }
    public Table(){
        Fields= null;
    }
    public void changeFields(String[] fields){
        Fields= fields;
    }
    public void addRecord(String[] record){
        Record.add(record);
    }
    public String[] getFields(){
        return Fields;
    }
    public String[] getRecord(int i){
        return Record.get(i);
    }
    public Integer findField(String Name){
        for(int i=0;i<Fields.length;i++){
            if (Fields[i].equals(Name))
                return i;
        }
        return -1;
    }
    public Boolean isRecordRight(Integer NumberOfRecord,Integer NumberOfField, String RecordValue){
        String[]record = Record.get(NumberOfRecord);
        return (record[NumberOfField].equals(RecordValue));
    }
    public Integer size(){
        return Record.size();
    }
    public Integer numberOfFields(){
        return Fields.length;
    }
}

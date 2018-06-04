package com.test;
//java -jar C:\Users\Lena\Desktop\dbftocsv\target\dbftocsv-1.0-SNAPSHOT.jar C:\Users\Lena\Desktop\dbase_31.dbf C:\Users\Lena\Desktop\dbase_31.csv
//java -jar C:\Users\Lena\Desktop\dbftocsv\target\dbftocsv-1.0-SNAPSHOT.jar C:\Users\Lena\Desktop\dbase_31.dbf C:\Users\Lena\Desktop\dbase_31.csv s CATEGORYID 1
//java -jar C:\Users\Admin\IdeaProjects\dbftocsv\target\dbftocsv-1.0-SNAPSHOT.jar C:\Users\Admin\Desktop\dbase_31.dbf C:\Users\Admin\Desktop\dbase_31.csv
import com.linuxense.javadbf.*;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.*;

import java.nio.file.Paths;
import java.nio.file.Files;


public class Main {

    private static String splitSimbol = ";";
    private static Boolean isParametr = false;
    private static Table table;
    private static String [] record;
    private static String longrecord;
    private static String NameOfField;
    private static String ValueOfRecord;
    public static void main(String args[])throws Exception{
        table=new Table();

        try{
            DBFReader reader;
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(args[1]));
            reader = new DBFReader(new FileInputStream(args[0]));

            longrecord = "";

            if(args.length>4){
                String test=args[2];
                if(test.equals("s")){
                    isParametr=true;

                    NameOfField=(String)args[3];
                    ValueOfRecord= (String)args[4];
                }
            }
            int numberOfFields = reader.getFieldCount();
            for (int i = 0; i < numberOfFields; i++) {
                DBFField field = reader.getField(i);
                if (longrecord!="")
                    longrecord+=splitSimbol;
                longrecord+=(String)field.getName();
            }
            record = longrecord.split(splitSimbol);
            table.changeFields(record);
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(record));
            try{
                Object[] rowObjects;
                while ((rowObjects = reader.nextRecord()) != null) {
                    longrecord="";
                    for (int i = 0; i < rowObjects.length; i++) {
                        if(longrecord!="")
                            longrecord+=splitSimbol;
                        longrecord+=rowObjects[i];
                    }
                    record = longrecord.split(splitSimbol);
                    table.addRecord(record);
                }


                for (int i =0;i<table.size();i++){
                    if(isParametr){
                        int j=table.findField(NameOfField);

                        if (j!=-1){
                            if(table.isRecordRight(i,j,ValueOfRecord))
                                csvPrinter.printRecord(table.getRecord(i));
                        }

                    }
                    else{
                        csvPrinter.printRecord(table.getRecord(i));
                    }
                }

            }finally {
                csvPrinter.flush();
                reader.close();
            }



        }catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}


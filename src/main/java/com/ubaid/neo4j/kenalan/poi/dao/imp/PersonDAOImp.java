package com.ubaid.neo4j.kenalan.poi.dao.imp;

import com.ubaid.neo4j.kenalan.entity.Person;
import com.ubaid.neo4j.kenalan.poi.dao.def.PersonDAO;
import com.ubaid.neo4j.kenalan.poi.reader.ExcelReader;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Repository
public class PersonDAOImp implements PersonDAO {

    @Autowired
    private ExcelReader reader;
    private final static String SHEET_NAME = "Installed info";
    private final static int MANUFACTURER_COLUMN_INDEX = 2;
    private DataFormatter dataFormatter = new DataFormatter();


    @Override
    public Set<Person> getPersons() {
        try {
            Sheet sheet = reader.getSheet(SHEET_NAME);
            Set<Person> personSet1 = _get_(sheet);

            Sheet sheet2 = reader.getSheet("Service History");

            Set<Person> personSet2 = _get_2(sheet2);

            personSet1.addAll(personSet2);

            return  personSet1;

        } catch(IOException exp) {
            exp.printStackTrace();
        }
        return null;

    }

    private Set<Person> _get_2(Sheet sheet) {
        Iterator<Row> rowIterable = sheet.rowIterator();
        Set<Person> persons = new HashSet<Person>();
        int ignore = 0;
        while (rowIterable.hasNext()) {
            Row row = rowIterable.next();
            if (ignore == 0) {
                ignore = ignore + 1;
                continue;
            }
            Cell cell = row.getCell(3);
            String person_name = dataFormatter.formatCellValue(cell);
            Person person = new Person(person_name, null, null, null);
            persons.add(person);
        }

        return  persons;

    }


    private Set<Person> _get_(Sheet sheet) {
        Iterator<Row> rowIterable = sheet.rowIterator();
        Set<Person> persons = new HashSet<Person>();
        int ignore = 0;
        while (rowIterable.hasNext()) {
            Row row = rowIterable.next();
            if (ignore == 0) {
                ignore = ignore + 1;
                continue;
            }
            Cell cell = row.getCell(MANUFACTURER_COLUMN_INDEX);
            String person_name = dataFormatter.formatCellValue(cell);
            Person person = new Person(person_name, null, null, null);

            Cell cell1 = row.getCell(MANUFACTURER_COLUMN_INDEX + 1);
            String person_name1 = dataFormatter.formatCellValue(cell1);
            Person person1 = new Person(person_name1, null, null, null);
            persons.add(person);
            persons.add(person1);
        }

        return  persons;
    }

}

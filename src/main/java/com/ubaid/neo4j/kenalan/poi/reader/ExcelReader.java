package com.ubaid.neo4j.kenalan.poi.reader;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class ExcelReader {

    @Value("${excel.path}")
    private String path;

    private Workbook workbook = null;


    private Workbook getWorkBook() throws IOException {
        if(workbook == null) {
            workbook = WorkbookFactory.create(new File(path));
        }
        return workbook;
    }

    public Sheet getSheet(String name) throws IOException {
        workbook = getWorkBook();
        return  workbook.getSheet(name);
    }
}

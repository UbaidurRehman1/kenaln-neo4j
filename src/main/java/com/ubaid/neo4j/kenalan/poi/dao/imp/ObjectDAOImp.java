package com.ubaid.neo4j.kenalan.poi.dao.imp;

import com.ubaid.neo4j.kenalan.entity.Material;
import com.ubaid.neo4j.kenalan.entity.Object;
import com.ubaid.neo4j.kenalan.poi.dao.def.ObjectDAO;
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
public class ObjectDAOImp implements ObjectDAO {

    @Autowired
    private ExcelReader reader;
    private final static String SHEET_NAME = "Part Info";
    private final static int MANUFACTURER_COLUMN_INDEX = 5;
    private DataFormatter dataFormatter = new DataFormatter();


    @Override
    public Set<Object> getObjectsFromExcel() {
        try {
            Sheet sheet = reader.getSheet(SHEET_NAME);
            return  _get_(sheet);
        } catch(IOException exp) {
            exp.printStackTrace();
        }
        return null;

    }


    private Set<Object> _get_(Sheet sheet) {
        Iterator<Row> rowIterable = sheet.rowIterator();
        Set<Object> objects = new HashSet<Object>();
        int ignore = 0;
        while (rowIterable.hasNext()) {
            Row row = rowIterable.next();
            if (ignore == 0) {
                ignore = ignore + 1;
                continue;
            }
            Cell cell_1 = row.getCell(0);
            Cell cell_2 = row.getCell(1);
            Cell cell_3 = row.getCell(2);
            Cell cell_4 = row.getCell(3);
            Cell cell_5 = row.getCell(4);
            Cell cell_6 = row.getCell(5);
            Cell cell_7 = row.getCell(6);

            String name_1 = dataFormatter.formatCellValue(cell_1);
            String name_2 = dataFormatter.formatCellValue(cell_2);
            String name_3 = dataFormatter.formatCellValue(cell_3);
            String name_4 = dataFormatter.formatCellValue(cell_4);
            String name_5 = dataFormatter.formatCellValue(cell_5);
            String name_6 = dataFormatter.formatCellValue(cell_6);
            String name_7 = dataFormatter.formatCellValue(cell_7);

            Object object = new Object(name_1, name_3, name_2, name_4);
            object.setManufacturerName(name_5);
            object.setMaterialName(name_6);
            object.setNodeTypeName(name_7);

            objects.add(object);

        }

        return  objects;
    }


}

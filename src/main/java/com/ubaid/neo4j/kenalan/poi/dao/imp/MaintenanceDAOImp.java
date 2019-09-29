package com.ubaid.neo4j.kenalan.poi.dao.imp;

import com.ubaid.neo4j.kenalan.entity.Maintenance;
import com.ubaid.neo4j.kenalan.entity.Person;
import com.ubaid.neo4j.kenalan.poi.dao.def.MaintenanceDAO;
import com.ubaid.neo4j.kenalan.poi.reader.ExcelReader;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.*;

@Repository
public class MaintenanceDAOImp implements MaintenanceDAO {

    @Autowired
    private ExcelReader reader;
    private final static String SHEET_NAME = "Installed info";
    private final static int MANUFACTURER_COLUMN_INDEX = 0;
    private DataFormatter dataFormatter = new DataFormatter();


    @Override
    public List<Maintenance> getMaintenanceList() {
        try {
            Sheet sheet = reader.getSheet(SHEET_NAME);
            return  _get_(sheet);
        } catch(IOException exp) {
            exp.printStackTrace();
        }
        return null;

    }


    private List<Maintenance> _get_(Sheet sheet) {
        Iterator<Row> rowIterable = sheet.rowIterator();
        List<Maintenance> maintenanceSet = new ArrayList<Maintenance>();
        int ignore = 0;
        while (rowIterable.hasNext()) {
            Row row = rowIterable.next();
            if (ignore == 0) {
                ignore = ignore + 1;
                continue;
            }
            Cell cell = row.getCell(MANUFACTURER_COLUMN_INDEX);
            String part_name = dataFormatter.formatCellValue(cell);
            Maintenance maintenance = new Maintenance();
            maintenance.setName(part_name);
            maintenanceSet.add(maintenance);
        }

        return  maintenanceSet;
    }

}

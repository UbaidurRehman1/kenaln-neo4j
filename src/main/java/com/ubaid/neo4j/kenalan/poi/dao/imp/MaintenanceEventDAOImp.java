package com.ubaid.neo4j.kenalan.poi.dao.imp;

import com.ubaid.neo4j.kenalan.entity.MaintenanceEvent;
import com.ubaid.neo4j.kenalan.entity.Object;
import com.ubaid.neo4j.kenalan.poi.dao.def.MaintenanceEventDAO;
import com.ubaid.neo4j.kenalan.poi.reader.ExcelReader;
import com.ubaid.neo4j.kenalan.poi.util.Util;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.*;

@Repository
public class MaintenanceEventDAOImp implements MaintenanceEventDAO {

    @Autowired
    private ExcelReader reader;
    private final static String SHEET_NAME = "Service History";
    private final static int MANUFACTURER_COLUMN_INDEX = 0;
    private DataFormatter dataFormatter = new DataFormatter();


    @Override
    public List<MaintenanceEvent> getAllMaintenanceEvent() {
        try {
            Sheet sheet = reader.getSheet(SHEET_NAME);
            return  _get_(sheet);
        } catch(IOException exp) {
            exp.printStackTrace();
        }

        return null;

    }

    private List<MaintenanceEvent> _get_(Sheet sheet) {
        Iterator<Row> rowIterable = sheet.rowIterator();
        List<MaintenanceEvent> maintenanceEvents = new ArrayList<MaintenanceEvent>();
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

            String part_name = dataFormatter.formatCellValue(cell_1);
            String event_type = dataFormatter.formatCellValue(cell_2);
            String date = dataFormatter.formatCellValue(cell_3);
            String person_name = dataFormatter.formatCellValue(cell_4);

            MaintenanceEvent maintenanceEvent = new MaintenanceEvent();

            maintenanceEvent.setObjectName(part_name);
            maintenanceEvent.setType(event_type);
            if(!date.equals(""))
                maintenanceEvent.setTime(Util.convertStringToTimestamp(date));
            maintenanceEvent.setPersonName(person_name);

            maintenanceEvents.add(maintenanceEvent);
        }

        return  maintenanceEvents;
    }

}

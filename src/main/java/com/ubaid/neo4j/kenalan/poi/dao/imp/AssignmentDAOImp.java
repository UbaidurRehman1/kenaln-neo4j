package com.ubaid.neo4j.kenalan.poi.dao.imp;

import com.ubaid.neo4j.kenalan.entity.Assignment;
import com.ubaid.neo4j.kenalan.entity.Maintenance;
import com.ubaid.neo4j.kenalan.poi.dao.def.AssignmentDAO;
import com.ubaid.neo4j.kenalan.poi.reader.ExcelReader;
import com.ubaid.neo4j.kenalan.poi.util.Util;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class AssignmentDAOImp implements AssignmentDAO {

    @Autowired
    private ExcelReader reader;
    private final static String SHEET_NAME = "Installed info";
    private final static int MANUFACTURER_COLUMN_INDEX = 0;
    private DataFormatter dataFormatter = new DataFormatter();


    @Override
    public List<Assignment> getAssignmentList() {
        try {
            Sheet sheet = reader.getSheet(SHEET_NAME);
            return  _get_(sheet);
        } catch(IOException exp) {
            exp.printStackTrace();
        }
        return null;

    }

    private List<Assignment> _get_(Sheet sheet) {
        Iterator<Row> rowIterable = sheet.rowIterator();
        List<Assignment> assignments = new ArrayList<Assignment>();
        int ignore = 0;
        while (rowIterable.hasNext()) {
            try
            {
                Row row = rowIterable.next();
                if (ignore == 0) {
                    ignore = ignore + 1;
                    continue;
                }
                Cell cell = row.getCell(0);
                String part_name = dataFormatter.formatCellValue(cell);

                Cell cell1 = row.getCell(1);
                String installed_date = dataFormatter.formatCellValue(cell1);

                Cell cell2 = row.getCell(2);
                String installed_by = dataFormatter.formatCellValue(cell2);

                Cell cell3 = row.getCell(3);
                String approved_by = dataFormatter.formatCellValue(cell3);

                Cell cell4 = row.getCell(4);
                String time_installed = dataFormatter.formatCellValue(cell4);

                Assignment assignment = new Assignment();
                assignment.setPartName(part_name);
                assignment.setTimeScheduled(Util.convertStringToTimestamp(installed_date));
                assignment.setPersonName(installed_by);
                assignment.setApprovedByName(approved_by);
                assignment.setTimeEstimate(Float.parseFloat(time_installed));
                assignments.add(assignment);

            }
            catch(Exception exp)
            {
                exp.printStackTrace();
            }
        }

        return  assignments;
    }

}

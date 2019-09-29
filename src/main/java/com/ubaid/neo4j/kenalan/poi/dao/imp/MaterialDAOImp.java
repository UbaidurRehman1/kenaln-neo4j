package com.ubaid.neo4j.kenalan.poi.dao.imp;

import com.ubaid.neo4j.kenalan.entity.Material;
import com.ubaid.neo4j.kenalan.poi.dao.def.MaterialDAO;
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
public class MaterialDAOImp implements MaterialDAO {

    @Autowired
    private ExcelReader reader;
    private final static String SHEET_NAME = "Part Info";
    private final static int MANUFACTURER_COLUMN_INDEX = 5;
    private DataFormatter dataFormatter = new DataFormatter();


    @Override
    public Set<Material> getMaterials() {
        try {
            Sheet sheet = reader.getSheet(SHEET_NAME);
            return  _get_(sheet);
        } catch(IOException exp) {
            exp.printStackTrace();
        }
        return null;
    }

    private Set<Material> _get_(Sheet sheet) {
        Iterator<Row> rowIterable = sheet.rowIterator();
        Set<Material> materials = new HashSet<Material>();
        int ignore = 0;
        while (rowIterable.hasNext()) {
            Row row = rowIterable.next();
            if (ignore == 0) {
                ignore = ignore + 1;
                continue;
            }

            Cell cell = row.getCell(MANUFACTURER_COLUMN_INDEX);
            String object_name = dataFormatter.formatCellValue(cell);
            Material material = new Material(object_name, null, null, null);
            materials.add(material);
        }

        return  materials;
    }


}

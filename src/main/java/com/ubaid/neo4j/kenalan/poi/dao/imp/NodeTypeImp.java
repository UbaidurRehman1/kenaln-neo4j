package com.ubaid.neo4j.kenalan.poi.dao.imp;

import com.ubaid.neo4j.kenalan.entity.Material;
import com.ubaid.neo4j.kenalan.entity.NodeType;
import com.ubaid.neo4j.kenalan.entity.Part;
import com.ubaid.neo4j.kenalan.poi.dao.def.NodeDAO;
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
public class NodeTypeImp implements NodeDAO {

    @Autowired
    private ExcelReader reader;
    private final static String SHEET_NAME = "Part Info";
    private final static int MANUFACTURER_COLUMN_INDEX = 6;
    private DataFormatter dataFormatter = new DataFormatter();


    @Override
    public Set<NodeType> getParts() {
        try {
            Sheet sheet = reader.getSheet(SHEET_NAME);
            return  _get_(sheet);
        } catch(IOException exp) {
            exp.printStackTrace();
        }
        return null;
    }


    private Set<NodeType> _get_(Sheet sheet) {
        Iterator<Row> rowIterable = sheet.rowIterator();
        Set<NodeType> nodeTypes = new HashSet<NodeType>();
        int ignore = 0;
        while (rowIterable.hasNext()) {
            Row row = rowIterable.next();
            if (ignore == 0) {
                ignore = ignore + 1;
                continue;
            }
            Cell cell = row.getCell(MANUFACTURER_COLUMN_INDEX);
            String material_name = dataFormatter.formatCellValue(cell);
            NodeType nodeType = new NodeType(material_name, null, null, null);
            nodeTypes.add(nodeType);
        }

        return  nodeTypes;
    }

}

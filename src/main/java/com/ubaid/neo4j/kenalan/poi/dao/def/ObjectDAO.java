package com.ubaid.neo4j.kenalan.poi.dao.def;

import com.ubaid.neo4j.kenalan.entity.Object;

import java.util.Set;

public interface ObjectDAO {
    public Set<Object> getObjectsFromExcel();
}

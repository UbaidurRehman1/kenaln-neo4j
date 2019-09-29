package com.ubaid.neo4j.kenalan.poi.dao.def;

import com.ubaid.neo4j.kenalan.entity.NodeType;
import com.ubaid.neo4j.kenalan.entity.Part;

import java.util.Set;

public interface NodeDAO {
    public Set<NodeType> getParts();
}

package com.ubaid.neo4j.kenalan.poi.dao.def;

import com.ubaid.neo4j.kenalan.entity.Person;

import java.util.Set;

public interface PersonDAO {
    public Set<Person> getPersons();
}

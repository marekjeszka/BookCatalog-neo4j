package com.bookcatalog.model;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Filename {
    @GraphId
    Long id;

    private String filename_id;
    private String name;

    public Filename() {}

    public String getFilename_id() {
        return filename_id;
    }

    public void setFilename_id(String filename_id) {
        this.filename_id = filename_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.bookcatalog.model;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity(type = "AS_FILE")
public class AsFile {
    @GraphId
    Long id;

    @StartNode
    private Book book;
    @EndNode
    private Filename filename;

    public AsFile() {}

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Filename getFilename() {
        return filename;
    }

    public void setFilename(Filename filename) {
        this.filename = filename;
    }
}

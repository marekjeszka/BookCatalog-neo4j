package com.bookcatalog.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@JsonIdentityInfo(generator=JSOGGenerator.class)
@NodeEntity
public class Book {
    @GraphId
    Long id;

    private String book_id;
    private String title;
    private String isbn;

    @Relationship(type = "AS_FILE")
    private List<AsFile> filenames;

    @Relationship(type = "HAS_CATEGORY")
    private List<HasCategory> categories;

    public Book() {}

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<AsFile> getFilenames() {
        return filenames;
    }

    public void setFilenames(List<AsFile> filenames) {
        this.filenames = filenames;
    }

    public List<HasCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<HasCategory> categories) {
        this.categories = categories;
    }
}

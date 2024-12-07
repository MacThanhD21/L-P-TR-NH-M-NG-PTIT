/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;

import java.io.Serializable;

/**
 *
 * @author ADMIN
 */
public class Book implements Serializable{
    private static final long serialVersionUID = 20241123L;
    private String id, title, author, code;
    private int yearPublished, pageCount;

    public Book() {
    }

    public Book(String id, String title, String author, String code, int yearPublished, int pageCount) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.code = code;
        this.yearPublished = yearPublished;
        this.pageCount = pageCount;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCode() {
        return code;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title=" + title + ", author=" + author + ", code=" + code + ", yearPublished=" + yearPublished + ", pageCount=" + pageCount + '}';
    }
}

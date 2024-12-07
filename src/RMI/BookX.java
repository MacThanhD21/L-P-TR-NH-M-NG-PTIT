package RMI;

import java.io.Serializable;

public class BookX implements Serializable {

    private static final long serialVersionUID = 20241124L;
    private String id, title, author, genre, code;
    private int yearPublished;

    public BookX() {
    }

    public BookX(String id, String title, String author, String genre, String code, int yearPublished) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.code = code;
        this.yearPublished = yearPublished;
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

    public String getGenre() {
        return genre;
    }

    public String getCode() {
        return code;
    }

    public int getYearPublished() {
        return yearPublished;
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

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    @Override
    public String toString() {
        return "BookX{" + "id=" + id + ", title=" + title + ", author=" + author + ", genre=" + genre + ", code=" + code + ", yearPublished=" + yearPublished + '}';
    }

}
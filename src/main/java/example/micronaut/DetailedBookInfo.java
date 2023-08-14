package example.micronaut;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
@JsonPropertyOrder({
        "author",
        "isbn"
})
@Introspected
public class DetailedBookInfo extends BookInfo {

    private String author;

    private String isbn;

    public DetailedBookInfo() {
    }

    public DetailedBookInfo(String author, String isbn, String name, TypeEnum type) {
        super(name, type);
        this.author = author;
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
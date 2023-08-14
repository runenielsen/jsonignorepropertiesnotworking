package example.micronaut;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
@JsonPropertyOrder({
        "author"
})
@Introspected
public class BasicBookInfo extends BookInfo {

    private String author;

    public BasicBookInfo() {
    }

    public BasicBookInfo(String author, String name, TypeEnum type) {
        super(name, type);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
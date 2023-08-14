package example.micronaut;

import com.fasterxml.jackson.annotation.*;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@Serdeable
@JsonPropertyOrder({
        "name",
        "type"
})
@JsonIgnoreProperties(
  value = "type"
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = DetailedBookInfo.class, name = "DETAILED"),
        @JsonSubTypes.Type(value = BasicBookInfo.class, name = "BASIC"),
})
@Introspected
public class BookInfo {

    private String name;

    protected TypeEnum type;

    public BookInfo() {
    }

    public BookInfo(String name, TypeEnum type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    @Serdeable
    public enum TypeEnum {
        BASIC("BASIC"),
        DETAILED("DETAILED");

        private final String value;

        TypeEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        private final static Map<String, TypeEnum> VALUE_MAPPING = Arrays.stream(values())
            .collect(Collectors.toMap(v -> v.getValue(), v -> v));

        @JsonCreator
        public static TypeEnum fromValue(String value) {
            if (!VALUE_MAPPING.containsKey(value)) {
                throw new IllegalArgumentException("Unexpected value '" + value + "'");
            }
            return VALUE_MAPPING.get(value);
        }
    }
}
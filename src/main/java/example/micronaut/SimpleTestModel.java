package example.micronaut;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;

@JsonIgnoreProperties(
        value = "testProperty2"
)
@Introspected
@Serdeable
public class SimpleTestModel {

    @JsonIgnore
    private String testProperty1;

    private String testProperty2;

    public String getTestProperty1() {
        return testProperty1;
    }

    public void setTestProperty1(String testProperty1) {
        this.testProperty1 = testProperty1;
    }

    public String getTestProperty2() {
        return testProperty2;
    }

    public void setTestProperty2(String testProperty2) {
        this.testProperty2 = testProperty2;
    }

    @Override
    public String toString() {
        return "TestModel{" +
                "testProperty1='" + testProperty1 + '\'' +
                ", testProperty2='" + testProperty2 + '\'' +
                '}';
    }
}

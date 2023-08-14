package example.micronaut;

import io.micronaut.serde.ObjectMapper;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

@MicronautTest
class JsonIgnorePropertiesWithDiscriminatorTest {

    private final ObjectMapper objectMapper;

    public JsonIgnorePropertiesWithDiscriminatorTest(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Test
    void testJacksonSerializationWithJsonIgnoreProperties() throws IOException {
        var testModel = new BasicBookInfo("Michael Ende", "The Neverending Story", BookInfo.TypeEnum.DETAILED);

        var testModelStr = new com.fasterxml.jackson.databind.ObjectMapper().writeValueAsString(testModel);

        Assertions.assertEquals("{\"type\":\"BASIC\",\"name\":\"The Neverending Story\",\"author\":\"Michael Ende\"}", testModelStr);
    }

    @Test
    void testMicronautSerializationWithJsonIgnoreProperties() throws IOException {
        var testModel = new BasicBookInfo("Michael Ende", "The Neverending Story", BookInfo.TypeEnum.DETAILED);

        var testModelStr = objectMapper.writeValueAsString(testModel);

        Assertions.assertEquals("{\"type\":\"BASIC\",\"name\":\"The Neverending Story\",\"author\":\"Michael Ende\"}", testModelStr);
    }
}

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
        // It is intentional for the purpose of the test, that I have set the discriminator property to something that
        // doesn't match the class of the bean here. The value shouldn't matter, since it should be ignored.
        var testModel = new BasicBookInfo("Michael Ende", "The Neverending Story", BookInfo.TypeEnum.DETAILED);

        var testModelStr = new com.fasterxml.jackson.databind.ObjectMapper().writeValueAsString(testModel);

        Assertions.assertEquals("{\"type\":\"BASIC\",\"author\":\"Michael Ende\",\"name\":\"The Neverending Story\"}", testModelStr);
    }

    @Test
    void testMicronautSerializationWithJsonIgnoreProperties() throws IOException {
        // It is intentional for the purpose of the test, that I have set the discriminator property to something that
        // doesn't match the class of the bean here. The value shouldn't matter, since it should be ignored.
        var testModel = new BasicBookInfo("Michael Ende", "The Neverending Story", BookInfo.TypeEnum.DETAILED);

        var testModelStr = objectMapper.writeValueAsString(testModel);

        Assertions.assertEquals("{\"type\":\"BASIC\",\"author\":\"Michael Ende\",\"name\":\"The Neverending Story\"}", testModelStr);
    }
}

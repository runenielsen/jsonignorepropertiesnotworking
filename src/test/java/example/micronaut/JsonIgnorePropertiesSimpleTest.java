package example.micronaut;

import io.micronaut.serde.ObjectMapper;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

@MicronautTest
class JsonIgnorePropertiesSimpleTest {

    private final ObjectMapper objectMapper;

    public JsonIgnorePropertiesSimpleTest(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Test
    void testJacksonSerializationWithJsonIgnore() throws IOException {
        var testModel = new SimpleTestModel();
        testModel.setTestProperty1("testValue1");
        testModel.setTestProperty2("testValue2");
        var testModelStr = new com.fasterxml.jackson.databind.ObjectMapper().writeValueAsString(testModel);

        Assertions.assertEquals("{}", testModelStr);
    }

    @Test
    void testMicronautSerializationWithJsonIgnore() throws IOException {
        var testModel = new SimpleTestModel();
        testModel.setTestProperty1("testValue1");
        testModel.setTestProperty2("testValue2");
        var testModelStr = objectMapper.writeValueAsString(testModel);

        Assertions.assertEquals("{}", testModelStr);
    }

    @Test
    void testJacksonDeserializationWithJsonIgnore() throws IOException {
        var testModel = new com.fasterxml.jackson.databind.ObjectMapper().readValue(
                "{\"testProperty1\":\"testValue1\",\"testProperty2\":\"testValue2\"}", SimpleTestModel.class);

        Assertions.assertEquals("TestModel{testProperty1='null', testProperty2='null'}", testModel.toString());
    }

    @Test
    void testMicronautDeserializationWithJsonIgnore() throws IOException {
        var testModel = objectMapper.readValue(
                "{\"testProperty1\":\"testValue1\",\"testProperty2\":\"testValue2\"}", SimpleTestModel.class);

        Assertions.assertEquals("TestModel{testProperty1='null', testProperty2='null'}", testModel.toString());
    }
}

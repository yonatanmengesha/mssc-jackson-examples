package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@JsonTest
class BeerDtoTest extends BaseTest{

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testSerializeDto() throws JsonProcessingException {

        BeerDto beerDto = getDto();
      String jsonString =  objectMapper.writeValueAsString(beerDto);

        System.out.println(jsonString);
    }

    @Test
    void testDecirialization() throws IOException {
        String json = "{\"id\":\"d71c9282-2195-4557-9815-0498eda3cca6\",\"beerName\":\"BeerName\",\"beerStyle\":\"ALE\",\"upc\":1234567890,\"price\":12.99,\"createdDate\":\"2025-06-24T14:37:45.1837332-04:00\",\"lastUpdatedDate\":\"2025-06-24T14:37:45.1847327-04:00\"}\n";
        BeerDto beerDto = objectMapper.readValue(json, BeerDto.class);

        System.out.println(beerDto);
    }
}
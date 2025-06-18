package utils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
public class JsonUtils {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> List<T> readJsonAsList(String filePath, Class<T> clazz) {
        try {
            return mapper.readValue(
                    new File(filePath),
                    mapper.getTypeFactory().constructCollectionType(List.class, clazz)
            );
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JSON file: " + filePath, e);
        }
    }

    public static <T> T readJsonAsObject(String filePath, Class<T> clazz) {
        try {
            return mapper.readValue(new File(filePath), clazz);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JSON object from file: " + filePath, e);
        }
    }
}

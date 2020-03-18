package cn.tsxygfy.beyond.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.lang.NonNull;
import org.springframework.util.Assert;

import java.io.IOException;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.beyond.util
 * @since 2020-03-18 12:17:59
 */
public class JsonUtil {

    private JsonUtil() {
    }

    private static final ObjectMapper DEFAULT_OBJECT_MAPPER = createDefaultMapper();

    public static ObjectMapper createDefaultMapper() {
        return new ObjectMapper();
    }

    @NonNull
    public static String objectToJson(@NonNull Object source) throws JsonProcessingException {
        return objectToJson(source, DEFAULT_OBJECT_MAPPER);
    }

    @NonNull
    public static String objectToJson(@NonNull Object source, @NonNull ObjectMapper objectMapper) throws JsonProcessingException {
        return objectMapper.writeValueAsString(source);
    }

    @NonNull
    public static <T> T jsonToObject(@NonNull String json, @NonNull Class<T> type) throws IOException {
        return jsonToObject(json, type, DEFAULT_OBJECT_MAPPER);
    }

    @NonNull
    public static <T> T jsonToObject(@NonNull String json, @NonNull Class<T> type, @NonNull ObjectMapper objectMapper) throws IOException {
        Assert.hasText(json, "Json content must not be blank");
        Assert.notNull(type, "Target type must not be null");
        Assert.notNull(objectMapper, "Object mapper must not null");

        return objectMapper.readValue(json, type);
    }
}

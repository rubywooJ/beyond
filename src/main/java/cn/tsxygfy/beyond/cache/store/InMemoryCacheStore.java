package cn.tsxygfy.beyond.cache.store;

import cn.tsxygfy.beyond.cache.CacheWrapper;
import cn.tsxygfy.beyond.exception.ServiceException;
import cn.tsxygfy.beyond.util.JsonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.util.Assert;

import javax.annotation.PreDestroy;
import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.beyond.cache.store
 * @since 2020-03-17 22:05:12
 */
@Slf4j
public class InMemoryCacheStore extends AbstractCacheStore<String, String> {

    private Lock lock = new ReentrantLock();

    /**
     * cache container
     */
    private static final ConcurrentHashMap<String, CacheWrapper<String>> CACHE_CONTAINER = new ConcurrentHashMap<>();

    @Override
    Optional<CacheWrapper<String>> getInternal(String key) {
        Assert.hasText(key, "cache key must not be blank");
        return Optional.ofNullable(CACHE_CONTAINER.get(key));
    }

    @Override
    void putInternal(String key, CacheWrapper<String> cacheWrapper) {
        CacheWrapper<String> res = CACHE_CONTAINER.put(key, cacheWrapper);
        log.debug("put [{}], res=[{}]", key, res);
    }

    @Override
    Boolean putInternalIfAbsent(String key, CacheWrapper<String> cacheWrapper) {
        lock.lock();
        try {
            Optional<CacheWrapper<String>> internal = getInternal(key);
            if (internal.isPresent()) {
                // key is present already
                log.debug("failed put key [{}], because its present already", key);
                return false;
            }

            putInternal(key, cacheWrapper);
            log.debug("succeeded put key [{}]", key);
            return true;
        } finally {
            lock.unlock();
        }
    }

    public <T> void putAny(String key, T value) {
        try {
            put(key, JsonUtil.objectToJson(value));
        } catch (JsonProcessingException e) {
            throw new ServiceException("Failed to convert " + value + " to json", e);
        }
    }

    public <T> void putAny(@NonNull String key, @NonNull T value, long timeout, @NonNull TimeUnit timeUnit) {
        try {
            put(key, JsonUtil.objectToJson(value), timeout, timeUnit);
        } catch (JsonProcessingException e) {
            throw new ServiceException("failed to convert " + value + " to json", e);
        }
    }

    public <T> Optional<T> getAny(String key, Class<T> type) {
        Assert.notNull(type, "type must not be null");

        return get(key).map(value -> {
            try {
                return JsonUtil.jsonToObject(value, type);
            } catch (IOException e) {
                log.error("failed to convert json to type: " + type.getName(), e);
                return null;
            }
        });
    }

    @Override
    public void delete(String key) {
        CACHE_CONTAINER.remove(key);
        log.debug("removed key: [{}]", key);
    }

    @PreDestroy
    public void preDestroy() {
        log.debug("cancelling all timer tasks");

        clear();
    }

    private void clear() {
        CACHE_CONTAINER.clear();
    }
}

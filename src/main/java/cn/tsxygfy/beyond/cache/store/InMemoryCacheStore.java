package cn.tsxygfy.beyond.cache.store;

import cn.tsxygfy.beyond.cache.CacheWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import javax.annotation.PreDestroy;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
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

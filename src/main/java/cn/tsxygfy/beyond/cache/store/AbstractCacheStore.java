package cn.tsxygfy.beyond.cache.store;

import cn.tsxygfy.beyond.cache.CacheWrapper;
import cn.tsxygfy.beyond.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.beyond.cache
 * @since 2020-03-13 16:04:44
 */
@Slf4j
public abstract class AbstractCacheStore<K, V> implements CacheStore<K, V> {

    /**
     * get cache wrapper by key
     *
     * @param key
     * @return
     */
    abstract Optional<CacheWrapper<V>> getInternal(K key);

    /**
     * put into cache by key and wrapper value
     *
     * @param key
     * @param cacheWrapper
     */
    abstract void putInternal(@NonNull K key, @NonNull CacheWrapper<V> cacheWrapper);

    /**
     * put into cache by key and value if the key is not in
     *
     * @param key
     * @param cacheWrapper
     * @return
     */
    abstract Boolean putInternalIfAbsent(@NonNull K key, @NonNull CacheWrapper<V> cacheWrapper);

    @Override
    public Optional<V> get(K key) {
        return getInternal(key).map(cacheWrapper -> {
            if (cacheWrapper.getExpireAt() != null && cacheWrapper.getExpireAt().before(DateUtil.now())) {
                log.warn("cache key [{}] has expired", key);
                delete(key);
            }
            return cacheWrapper.getData();
        });
    }

    @Override
    public void put(K key, V value) {
        putInternal(key, buildCacheWrapper(value, 0, null));
    }

    @Override
    public void put(K key, V value, long timeout, TimeUnit timeUnit) {
        putInternal(key, buildCacheWrapper(value, timeout, timeUnit));
    }

    @Override
    public Boolean putIfAbsent(K key, V value, long timeout, TimeUnit timeUnit) {
        return putInternalIfAbsent(key, buildCacheWrapper(value, timeout, timeUnit));
    }

    /**
     * 构造缓存
     *
     * @param value
     * @param timeout
     * @param timeUnit
     * @return
     */
    private CacheWrapper<V> buildCacheWrapper(@NonNull V value, long timeout, @Nullable TimeUnit timeUnit) {
        Date now = DateUtil.now();
        Date expireAt = null;
        if (timeout > 0 && timeUnit != null) {
            expireAt = DateUtil.add(now, timeout, timeUnit);
        }

        // build
        CacheWrapper<V> cacheWrapper = new CacheWrapper<>();
        cacheWrapper.setCreateAt(now);
        cacheWrapper.setData(value);
        cacheWrapper.setExpireAt(expireAt);
        return cacheWrapper;
    }
}

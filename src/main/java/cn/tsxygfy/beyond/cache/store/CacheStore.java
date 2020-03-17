package cn.tsxygfy.beyond.cache.store;

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
 * @since 2020-03-13 15:21:53
 */
public interface CacheStore<K, V> {

    /**
     * get value from cache by key
     *
     * @param key
     * @return
     */
    Optional<V> get(K key);


    /**
     * set value to cache by key that is no-expired
     *
     * @param key
     * @param value
     */
    void put(K key, V value);

    /**
     * set value to cache by key which can expire
     *
     * @param key
     * @param value
     * @param timeout
     * @param timeUnit
     */
    void put(K key, V value, long timeout, TimeUnit timeUnit);

    /**
     * set value to cache by key which can expire
     *
     * @param key
     * @param value
     * @param timeout
     * @param timeUnit
     * @return
     */
    Boolean putIfAbsent(K key, V value, long timeout, TimeUnit timeUnit);

    /**
     * delete cache value by key
     *
     * @param key
     */
    void delete(K key);
}

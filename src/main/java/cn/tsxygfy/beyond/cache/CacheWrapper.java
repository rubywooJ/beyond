package cn.tsxygfy.beyond.cache;

import lombok.*;

import java.util.Date;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.beyond.cache
 * @since 2020-03-13 16:01:37
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CacheWrapper<V> {

    private V data;

    private Date expireAt;

    private Date createAt;

}

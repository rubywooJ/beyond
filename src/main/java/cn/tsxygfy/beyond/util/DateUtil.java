package cn.tsxygfy.beyond.util;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.lang.NonNull;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.beyond.util
 * @since 2020-03-17 21:44:43
 */
public class DateUtil {

    private DateUtil() {
    }

    public static Date now() {
        return new Date();
    }


    public static Date add(@NonNull Date date, long time, @NonNull TimeUnit timeUnit) {
        Date result;
        int timeIntValue;

        if (time > Integer.MAX_VALUE) {
            timeIntValue = Integer.MAX_VALUE;
        } else {
            timeIntValue = Long.valueOf(time).intValue();
        }

        switch (timeUnit) {
            case DAYS:
                result = DateUtils.addDays(date, timeIntValue);
                break;
            case HOURS:
                result = DateUtils.addHours(date, timeIntValue);
                break;
            case MINUTES:
                result = DateUtils.addMinutes(date, timeIntValue);
                break;
            case SECONDS:
                result = DateUtils.addSeconds(date, timeIntValue);
                break;
            case MILLISECONDS:
                result = DateUtils.addMilliseconds(date, timeIntValue);
                break;
            default:
                result = date;
        }
        return result;
    }

}

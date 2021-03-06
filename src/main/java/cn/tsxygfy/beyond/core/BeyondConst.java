package cn.tsxygfy.beyond.core;

import org.springframework.http.HttpHeaders;

import java.io.File;
import java.time.Duration;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.beyond.core
 * @since 2020-02-21 15:00:15
 */
public class BeyondConst {

    private BeyondConst() {

    }

    /**
     * User home directory.
     */
    public static final String USER_HOME = System.getProperties().getProperty("user.home");
    /**
     * Temporary directory.
     */
    public static final String TEMP_DIR = System.getProperties().getProperty("java.io.tmpdir");
    /**
     * Default theme name.
     */
    public static final String DEFAULT_THEME_ID = "zozo";
    /**
     * Version constant. (Available in production environment)
     */
    public static final String BEYOND_VERSION;
    /**
     * Path separator.
     */
    public static final String FILE_SEPARATOR = File.separator;
    /**
     * Suffix of freemarker template file
     */
    public static final String SUFFIX_FTL = ".ftl";
    /**
     * Custom freemarker tag method key.
     */
    public static final String METHOD_KEY = "method";
    /**
     * 网易云音乐短代码前缀
     */
    public static final String NETEASE_MUSIC_PREFIX = "[music:";
    /**
     * 网易云音乐 iframe 代码
     */
    public static final String NETEASE_MUSIC_IFRAME = "<iframe frameborder=\"no\" border=\"0\" marginwidth=\"0\" marginheight=\"0\" width=330 height=86 src=\"//music.163.com/outchain/player?type=2&id=$1&auto=1&height=66\"></iframe>";
    /**
     * 网易云音乐短代码正则表达式
     */
    public static final String NETEASE_MUSIC_REG_PATTERN = "\\[music:(\\d+)\\]";
    /**
     * 哔哩哔哩视频短代码前缀
     */
    public static final String BILIBILI_VIDEO_PREFIX = "[bilibili:";
    /**
     * 哔哩哔哩视频 iframe 代码
     */
    public static final String BILIBILI_VIDEO_IFRAME = "<iframe height=$3 width=$2 src=\"//player.bilibili.com/player.html?aid=$1\" scrolling=\"no\" border=\"0\" frameborder=\"no\" framespacing=\"0\" allowfullscreen=\"true\"> </iframe>";
    /**
     * 哔哩哔哩视频正则表达式
     */
    public static final String BILIBILI_VIDEO_REG_PATTERN = "\\[bilibili:(\\d+)\\,(\\d+)\\,(\\d+)\\]";
    /**
     * YouTube 视频短代码前缀
     */
    public static final String YOUTUBE_VIDEO_PREFIX = "[youtube:";
    /**
     * YouTube 视频 iframe 代码
     */
    public static final String YOUTUBE_VIDEO_IFRAME = "<iframe width=$2 height=$3 src=\"https://www.youtube.com/embed/$1\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>";
    /**
     * YouTube 视频正则表达式
     */
    public static final String YOUTUBE_VIDEO_REG_PATTERN = "\\[youtube:(\\w+)\\,(\\d+)\\,(\\d+)\\]";
    /**
     * Github Api url for beyond-admin release.
     */
    public static final String BEYOND_ADMIN_RELEASES_LATEST = "https://api.github.com/repos/feiyangebyond/beyond-admin/releases/latest";

    /**
     * Content token header name.
     */
    public static final String API_ACCESS_KEY_HEADER_NAME = "API-" + HttpHeaders.AUTHORIZATION;
    /**
     * Admin token header name.
     */
    public static final String ADMIN_TOKEN_HEADER_NAME = "ADMIN-" + HttpHeaders.AUTHORIZATION;
    /**
     * Admin token param name.
     */
    public static final String ADMIN_TOKEN_QUERY_NAME = "admin_token";
    /**
     * Temporary token.
     */
    public static final String TEMP_TOKEN = "temp_token";
    /**
     * Content api token param name
     */
    public static final String API_ACCESS_KEY_QUERY_NAME = "api_access_key";
    public static final Duration TEMP_TOKEN_EXPIRATION = Duration.ofDays(7);
    /**
     * user_session
     */
    public static String USER_SESSION_KEY = "user_session";

    static {
        // Set version
        BEYOND_VERSION = BeyondConst.class.getPackage().getImplementationVersion();
    }
}

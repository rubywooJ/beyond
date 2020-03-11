package cn.tsxygfy.blog.util;

import org.springframework.util.StringUtils;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.blog.util
 * @since 2020-02-21 15:06:01
 */
public class ArticleUtil {

    private ArticleUtil() {
    }

    /**
     * 给出HTML截取文章摘要
     *
     * @param html   html
     * @param length 摘要字数
     * @return 摘要
     */
    public static String parseHtml(String html, int length) {

        if (StringUtils.isEmpty(html)) {
            return html = "空";
        } else {
            if (html.length() < length) {
                return html;
            } else {
                /*
                 * <.*?>为正则表达式，其中的.表示任意字符，*?表示出现0次或0次以上，此方法可以去掉双头标签(双头针对于残缺的标签)
                 * "<.*?"表示<尖括号后的所有字符，此方法可以去掉残缺的标签，及后面的内容
                 * " "，若有多种此种字符，可用同一方法去除
                 */
                html = html.replaceAll("<.*?>", " ").replaceAll("", "");
                html = html.replaceAll("<.*?", "");
                return (html.substring(0, length) + "...");
            }
        }
    }
}

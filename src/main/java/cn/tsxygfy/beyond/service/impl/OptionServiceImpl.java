package cn.tsxygfy.beyond.service.impl;

import cn.tsxygfy.beyond.mapper.InfoMapper;
import cn.tsxygfy.beyond.model.po.Info;
import cn.tsxygfy.beyond.service.OptionService;
import cn.tsxygfy.beyond.util.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.beyond.service.impl
 * @since 2020-02-21 15:04:40
 */
@Service
public class OptionServiceImpl implements OptionService {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private InfoMapper infoMapper;

    @Value("${beyond.domain:}")
    private String domain;

    @Override
    public String getBlogBaseUrl() {
        String serverPort = applicationContext.getEnvironment().getProperty("server.port", "8080");
        String baseUrl;
        if (StringUtils.hasText(domain)) {
            baseUrl = domain;
        } else {
            baseUrl = String.format("http://%s:%s", IpUtil.getMachineIp(), serverPort);
        }

        return baseUrl;
    }

    @Override
    public Map<String, Object> listOptions() {
        Map<String, Object> result = new HashMap<>(3);
        List<Info> infos = infoMapper.selectAll();
        if (!CollectionUtils.isEmpty(infos)) {
            Info info = infos.get(0);
            result.put("blog_title", info.getBlogTitle());
            result.put("seo_keywords", info.getSeoKeywords());
            result.put("seo_description", info.getSeoDescription());
        }
        return result;
    }
}

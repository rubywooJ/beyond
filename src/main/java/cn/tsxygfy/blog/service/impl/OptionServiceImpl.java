package cn.tsxygfy.blog.service.impl;

import cn.tsxygfy.blog.mapper.InfoMapper;
import cn.tsxygfy.blog.model.po.Info;
import cn.tsxygfy.blog.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author feiyang
 * @version v1.0
 * @className OptionServiceImpl
 * @description
 * @date 2020/01/30 周四 23:04
 */
@Service
public class OptionServiceImpl implements OptionService {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private InfoMapper infoMapper;

    @Override
    public String getBlogBaseUrl() {
        String serverPort = applicationContext.getEnvironment().getProperty("server.port", "8080");
        // TODO 添加 baseURL
        String address = ""; //公网ip

        String baseUrl = String.format("http://%s:%s", "localhost", serverPort);

        return baseUrl;
    }

    @Override
    public Map<String, Object> listOptions() {
        Map<String, Object> result = new HashMap<>();
        List<Info> infos = infoMapper.selectAll();
        if(!CollectionUtils.isEmpty(infos)){
            Info info = infos.get(0);
            result.put("blog_title", info.getBlogTitle());
            result.put("seo_keywords", info.getSeoKeywords());
            result.put("seo_description", info.getSeoDescription());
        }
        return result;
    }
}

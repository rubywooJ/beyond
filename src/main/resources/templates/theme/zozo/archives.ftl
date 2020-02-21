<#include "layouts/partials/head.ftl">
<@head title="归档 · ${options.blog_title}" keywords="${options.seo_keywords!}" description="${options.seo_description!}" canonical="${context!}/archives" />
<body>
<div class="main animated">
    <#include "layouts/partials/nav.ftl">
    <#include "layouts/partials/header.ftl">
    <div class="content">
        <div class="list_with_title">
            <@postTag method="archiveYear">
                <#list archives as archive>
                    <div class="listing_title">${archive.year?c}</div>
                    <div class="listing">
                        <#list archive.articles?sort_by("createTime")?reverse as post>
                            <div class="listing_item">
                                <div class="listing_post">
                                    <a href="${context!}/archives/${post.title}">${post.title!}</a>
                                    <div class="post_time"><span
                                                class="date">${post.createTime?number_to_datetime?string('MM-dd')}</span>
                                    </div>
                                </div>
                            </div>
                        </#list>
                    </div>
                </#list>
            </@postTag>
        </div>
        <div class="pagination"></div>
    </div>
    <a id="back_to_top" href="#" class="back_to_top"><i class="remixicon-arrow-up-s-line"></i></a>
</div>
<#include "layouts/partials/footer.ftl">
<#include "layouts/partials/js.ftl">
</body>
</html>

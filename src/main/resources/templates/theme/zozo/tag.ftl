<#include "layouts/partials/head.ftl">
<@head title="标签：${tag.name} · ${options.blog_title}" keywords="${options.seo_keywords!}" description="${options.seo_description!}" canonical="${context!}/tags/${tag.slugName!}" />
<body>
<div class="main animated">
    <#include "layouts/partials/nav.ftl">
    <#include "layouts/partials/header.ftl">
    <div class="content">
        <div class="list_with_title">
            <div class="listing_title">标签：${tag.name}</div>
            <div class="listing">
                <#list posts as post>
                <div class="listing_item">
                    <div class="listing_post">
                        <a href="${context!}/archives/${post.title!}">${post.title!}</a>
                        <div class="post_time"><span
                                    class="date">${post.createTime?number_to_datetime?string('yyyy-MM-dd')}</span></div>
                    </div>
                </div>
                </#list>
            </div>
        </div>
        <div class="pagination">

        </div>
    </div>
    <a id="back_to_top" href="#" class="back_to_top"><i class="remixicon-arrow-up-s-line"></i></a>
</div>
<#include "layouts/partials/footer.ftl">
<#include "layouts/partials/js.ftl">
</body>
</html>

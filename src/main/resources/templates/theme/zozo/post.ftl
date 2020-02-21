<#include "layouts/partials/head.ftl">
<@head title="${post.title!} · ${options.blog_title}" keywords="${options.seo_keywords!},${tagWords!}" description="${post.summary!}" canonical="${context!}/archives/${post.title!}" />
<body>
<div class="main animated">
    <#include "layouts/partials/nav.ftl">
    <#include "layouts/partials/header.ftl">
    <div class="content">
        <div class="post_page">
            <div class="post animated fadeInDown">
                <div class="post_title post_detail_title">
                    <h2><a href='${context!}/archives/${post.title!}'>${post.title!}</a></h2>
                    <div class="info">
                        <span class="field">
                          <i class="remixicon-time-line"></i>
                          <span class="date">${post.createTime?number_to_datetime?string('yyyy-MM-dd HH:mm')}</span>
                        </span>
                        &nbsp;&nbsp;
                        <#if post.tags?? && post.tags?size gt 0>
                            <span class="field">
                              <i class="remixicon-price-tag-3-line"></i>
                              <#list post.tags as tag>
                                  <a href="${context!}/tags/${tag.name}" style="font-size: unset; color: rgba(0,0,0,0.44)" onmouseover="this.style.color='black';"onmouseout="this.style.color='rgba(0,0,0,0.44)';">${tag.name}</a>
                              </#list>
                            </span>
                        </#if>
                        &nbsp;&nbsp;
                        <#if post.author?? && post.author?length gt 0>
                            <span class="field">
                                <i class="remixicon-user-3-line"></i>
                                <a href="${post.origin!context}" style="font-size: unset; color: rgba(0,0,0,0.44);" onmouseover="this.style.color='black';"onmouseout="this.style.color='rgba(0,0,0,0.44)';">${post.author!}</a>
                            </span>
                        </#if>
                    </div>
                </div>
                <div class="post_content markdown">${post.content}</div>
            </div>
            <!-- Valine 评论系统 -->
            <#include "layouts/partials/comments.ftl">
            <@comment post=post type="post" />
        </div>
    </div>
    <a id="back_to_top" href="#" class="back_to_top"><i class="remixicon-arrow-up-s-line"></i></a>
</div>
<#include "layouts/partials/footer.ftl">
<#include "layouts/partials/js.ftl">
</body>
</html>

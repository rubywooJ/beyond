<#list posts.content as post>
    <div class="post animated fadeInDown">
        <div class="post_title">
            <h2><a href='${context!}/archives/${post.title}'>${post.title!}</a></h2>
        </div>
        <div class="list">
            <div class="post_content markdown">
                <p>${post.summary!}......</p>
            </div>
        </div>
        <#--
        有人说我没有初始化 ？？？

        如果一定要给爱这个变量初始化

        那么变量类型

        大概是她的名字吧
        -->
        <div class="post_footer">
            <div class="meta">
                <div class="info">
                    <span class="field">
                      <i class="remixicon-time-line"></i>
                      <span class="date">${post.createTime?number_to_datetime?string('yyyy-MM-dd HH:mm')}</span>
                    </span>
                    <#if post.tags?? && post.tags?size gt 0>
                        <span class="field tags">
                          <i class="remixicon-price-tag-3-line"></i>
                          <#list post.tags as tag>
                              <a href="${context!}/tags/${tag.name}">${tag.name}</a>
                          </#list>
                        </span>
                    </#if>
                </div>
            </div>
        </div>
    </div>
</#list>

<div class="pagination">
    <#if posts.totalPages gt 1>
        <#if posts.pageNum lte posts.totalPages>
            <#if posts.pageNum gt 1>
                <#if posts.pageNum-1 lte 1>
                    <a href="${context!}" class="pre">
                        返回上一页
                    </a>
                <#else>
                    <a href="${context!}/page/${posts.pageNum-1}" class="pre">
                        返回上一页
                    </a>
                </#if>
            </#if>
            <#if posts.pageNum lt posts.totalPages>
                <a href="${context!}/page/${posts.pageNum+1}" class="next">
                    阅读更多文章
                </a>
            </#if>
        </#if>
    </#if>
</div>

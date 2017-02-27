package com.yanll.framework.util.page;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

/**
 * Created by YANLL on 2017/2/27.
 */
public class PageUtil {

    public static final int DEFAULT_PAGE = 1;
    public static final int DEFAULT_LIMIT = 10;

    public static PageBounds toPageBounds(Integer page, Integer limit) {
        return new PageBounds(page == null ? DEFAULT_PAGE : getPage(page), limit == null ? DEFAULT_LIMIT : getLimit(limit), true);
    }

    public static PageBounds toPageBounds(Integer page, Integer limit, Boolean containsTotalCount) {
        PageBounds pageBounds = new PageBounds(page == null ? DEFAULT_PAGE : getPage(page), limit == null ? DEFAULT_LIMIT : getLimit(limit));
        pageBounds.setContainsTotalCount(containsTotalCount);
        return pageBounds;
    }


    public static Integer getPage(Integer page) {
        return Math.max(page.intValue(), 1);
    }

    public static Integer getLimit(Integer limit) {
        return Math.max(limit.intValue(), 1);
    }

}

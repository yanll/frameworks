package com.yanll.framework.util.page;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

/**
 * Created by Administrator on 2017/2/27.
 */
public class PaginationUtil {

    public static final int DEFAULT_PAGE = 1;
    public static final int DEFAULT_LIMIT = 10;

    public static PageBounds toPageBounds(Integer page) {
        return new PageBounds(page == null ? DEFAULT_PAGE : max(page), DEFAULT_LIMIT, false);
    }

    public static PageBounds toPageBounds(Integer page, Integer limit) {
        return new PageBounds(page == null ? DEFAULT_PAGE : max(page), limit == null ? DEFAULT_LIMIT : max(limit), false);
    }

    public static PageBounds toPageBounds(Integer page, Integer limit, Boolean containsTotalCount) {
        PageBounds pageBounds = new PageBounds(page == null ? DEFAULT_PAGE : max(page), limit == null ? DEFAULT_LIMIT : max(limit));
        pageBounds.setContainsTotalCount(containsTotalCount);
        return pageBounds;
    }


    public static Integer max(Integer n) {
        return Math.max(n.intValue(), 1);
    }

}

package com.yanll.framework.facade.page;


/**
 * Created by YANLL on 2017/2/27.
 */
public class PaginationUtil {

    public static final int DEFAULT_PAGE = 1;
    public static final int DEFAULT_LIMIT = 10;

    public static Pagination toPageBounds(Integer page) {
        return new Pagination(page == null ? DEFAULT_PAGE : max(page), DEFAULT_LIMIT);
    }

    public static Pagination toPageBounds(Integer page, Integer limit) {
        return new Pagination(page == null ? DEFAULT_PAGE : max(page), limit == null ? DEFAULT_LIMIT : max(limit));
    }


    public static Integer max(Integer n) {
        return Math.max(n.intValue(), 1);
    }

}

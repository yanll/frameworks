package com.yanll.framework.util.page;

/**
 * Created by YANLL on 2017/2/28.
 */
public class Pagination {
    private static final long serialVersionUID = -2429124473690465105L;
    /**
     * 分页大小
     */
    private Integer limit;
    /**
     * 页数
     */
    private Integer page;
    /**
     * 总记录数
     */
    private Integer total;

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}

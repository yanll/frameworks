package com.yanll.framework.util.page;


import com.github.miemiedev.mybatis.paginator.domain.Paginator;

import java.io.Serializable;

public class PaginateWrapper<T> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 2874371941548801172L;

    private Pagination pagination;

    private T items;

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public T getItems() {
        return items;
    }

    public void setItems(T items) {
        this.items = items;
    }
}

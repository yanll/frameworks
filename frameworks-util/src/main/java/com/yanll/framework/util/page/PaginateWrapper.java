package com.yanll.framework.util.page;


import com.github.miemiedev.mybatis.paginator.domain.Paginator;

import java.io.Serializable;

public class PaginateWrapper<T> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 2874371941548801172L;

    private Paginator paginator;

    private T items;

    public Paginator getPaginator() {
        return paginator;
    }

    public void setPaginator(Paginator paginator) {
        this.paginator = paginator;
    }

    public T getItems() {
        return items;
    }

    public void setItems(T items) {
        this.items = items;
    }
}

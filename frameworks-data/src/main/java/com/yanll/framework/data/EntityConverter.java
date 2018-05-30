package com.yanll.framework.data;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;
import com.yanll.framework.data.domain.POEntity;
import com.yanll.framework.facade.domain.DTOEntity;
import com.yanll.framework.facade.page.PaginateWrapper;
import com.yanll.framework.facade.page.Pagination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;

import java.util.ArrayList;
import java.util.List;

public class EntityConverter {

    private static final Logger logger = LoggerFactory.getLogger(EntityConverter.class);

    public static <PO extends POEntity, DTO extends DTOEntity> DTO toDTO(PO t, DTO v) {
        if (t == null) {
            return null;
        }
        try {
            BeanUtils.copyProperties(t, v);
        } catch (BeansException ex) {
            logger.error("EntityConverter toDTO BeansException:", ex);
        } catch (Exception ex) {
            logger.error("EntityConverter toDTO Exception:", ex);
        }
        return v;
    }

    public static <PO extends POEntity, DTO extends DTOEntity> List<DTO> toDTOList(List<PO> list, Class<DTO> classzz) {
        if (list == null || list.size() == 0) {
            return null;
        }
        if (list.size() == 0) {
            return new ArrayList<DTO>();
        }
        List<DTO> list_ = new ArrayList<>();
        for (PO po : list) {
            try {
                DTO v = BeanUtils.instantiateClass(classzz);
                BeanUtils.copyProperties(po, v);
                list_.add(v);
            } catch (BeansException ex) {
                logger.error("EntityConverter toDTOList BeansException:", ex);
            } catch (Exception ex) {
                logger.error("EntityConverter toDTOList Exception:", ex);
            }
        }
        return list_;
    }


    public static <PO extends POEntity, DTO extends DTOEntity> PaginateWrapper<List<DTO>> toPaginateWrapper(List<PO> list, Class<DTO> classzz, PageBounds pageBounds) {
        PaginateWrapper<List<DTO>> rs = new PaginateWrapper<>();
        if (list == null || list.size() == 0) {
            return rs;
        }
        List<DTO> list_ = toDTOList(list, classzz);
        rs.setItems(list_);
        Pagination pagination = new Pagination();
        if (list instanceof PageList) {
            PageList<PO> pl = (PageList<PO>) list;
            Paginator paginator = pl.getPaginator();
            if (paginator != null) {
                pagination.setPage(paginator.getPage());
                pagination.setLimit(paginator.getLimit());
                pagination.setTotal(paginator.getTotalCount());
                pagination.setLimit(paginator.getLimit());
            }
        } else {
            pagination.setPage(pageBounds.getPage());
            pagination.setLimit(pageBounds.getLimit());
        }
        rs.setPagination(pagination);
        return rs;
    }
}

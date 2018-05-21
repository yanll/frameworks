package com.yanll.framework.data;


import com.yanll.framework.data.domain.POEntity;

import java.util.List;

public interface BaseMapper<T extends POEntity> {

    T selectByPrimaryKey(Long id);

    int deleteByPrimaryKey(Long id);

    int deleteByPrimaryKeys(Long... id);

    int insert(T record);

    int batchInsert(List<T> list);

    int insertSelective(T record);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

}

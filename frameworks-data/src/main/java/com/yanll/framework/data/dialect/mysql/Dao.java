package com.yanll.framework.data.dialect.mysql;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by YAN on 14-2-21.
 */


@Repository
public class Dao extends AbstractDao {

    @Override
    public List<Map<String, Object>> queryForList(String sql, int index, int size, Object... args) {
        return null;
    }

}

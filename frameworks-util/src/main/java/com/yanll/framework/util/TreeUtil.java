package com.yanll.framework.util;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: YANLL
 * Date: 14-3-29
 * Time: 上午12:21
 * To change this template use File | Settings | File Templates.
 */
public class TreeUtil {

    public static final String CHILDREN = "children";
    public static final String LEAF = "leaf";
    public static final String CHECKED = "checked";
    public static final String CHECKED_UPPER = "CHECKED";
    public static final String CHECKBOX = "CHECKBOX";
    public static final String NULL = "null";
    public static final String NULLSTRING = "";

    /**
     * 将数据集合转换为树
     * <p>
     * <p>
     * childFieldName、parentFieldName一般为id,parent_id。
     * 用于指定描述父子级关系的字段
     *
     * @param src             Map集合，按照指定的父子字段构造树
     * @param childFieldName  id
     * @param parentFieldName parent_id
     * @return
     */
    public static List<Map<String, Object>> buildMapTree(List<Map<String, Object>> src, String childFieldName, String parentFieldName) {
        if (src == null || src.size() == 0) return new ArrayList<Map<String, Object>>();
        List<Map<String, Object>> parents = new ArrayList<Map<String, Object>>();
        List<Map<String, Object>> children = new ArrayList<Map<String, Object>>();
        for (Map<String, Object> ent : src) {
            ent.put(LEAF, true);
            if (ent.get(CHECKBOX) != null && ent.get(CHECKED_UPPER) != null) {
                ent.put(CHECKED, ent.get(CHECKED_UPPER));
            }
            if (ent.get(parentFieldName) == null || NULLSTRING.equals(ent.get(parentFieldName).toString()) || NULL.equals(ent.get(parentFieldName).toString())) {
                Map<String, Object> result = ent;
                result.put(CHILDREN, new ArrayList<Map<String, Object>>());
                parents.add(result);
            } else {
                children.add(ent);
            }
        }
        recurseMapTree(parents, children, childFieldName, parentFieldName);
        return parents;
    }


    /**
     * 将树（buildMapTree构造）转换为数据集合
     *
     * @param nodes
     * @return
     */
    public static List<Map<String, Object>> readMapTree(List<Map<String, Object>> nodes) {
        List<Map<String, Object>> rs = new ArrayList<Map<String, Object>>();
        if (nodes == null || nodes.size() == 0) return rs;
        recurseMapTree(rs, nodes);
        return rs;
    }

    private static void recurseMapTree(List<Map<String, Object>> parents, List<Map<String, Object>> others, String childFieldName, String parentFieldName) {
        List<Map<String, Object>> record = new ArrayList<Map<String, Object>>();
        for (Iterator<Map<String, Object>> it = parents.iterator(); it.hasNext(); ) {
            Map<String, Object> vi = it.next();
            if (vi.get(childFieldName) != null && !NULLSTRING.equals(vi.get(childFieldName).toString()) && !NULL.equals(vi.get(childFieldName).toString())) {
                for (Iterator<Map<String, Object>> otherIt = others.iterator(); otherIt.hasNext(); ) {
                    Map<String, Object> inVi = otherIt.next();
                    if (vi.get(childFieldName).toString().equals(inVi.get(parentFieldName).toString())) {
                        List<Map<String, Object>> temp = null;
                        if (vi.get(CHILDREN) != null) {
                            temp = (List<Map<String, Object>>) vi.get(CHILDREN);
                        }
                        if (null == temp || temp.size() == 0) {
                            vi.put(CHILDREN, new ArrayList<Map<String, Object>>());
                        }
                        vi.put(LEAF, false);
                        List<Map<String, Object>> c = (List<Map<String, Object>>) vi.get(CHILDREN);
                        c.add(inVi);
                        vi.put(CHILDREN, c);
                        record.add(inVi);
                        otherIt.remove();
                    }
                }
            }
        }
        if (others.size() == 0) {
            return;
        } else {
            recurseMapTree(record, others, childFieldName, parentFieldName);
        }
    }

    private static void recurseMapTree(List<Map<String, Object>> rs, List<Map<String, Object>> nodes) {
        for (Map<String, Object> node : nodes) {
            List<Map<String, Object>> children = (List<Map<String, Object>>) node.get(CHILDREN);
            rs.add(node);
            if (children != null && children.size() != 0) {
                recurseMapTree(rs, children);
            }
        }
    }


}

package com.egoist.parent.common.enums;

import com.egoist.parent.common.exception.EgoistException;
import com.egoist.parent.common.utils.json.EgoistJsonUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 表记录状态枚举
 */
public final class EgoistTableRecordStatusEnum {

    private EgoistTableRecordStatusEnum() {
    }

    /**
     * 定义Map
     */
    private static Map<Short, String> map = new LinkedHashMap<Short, String>();

    /**
     * 删除
     */
    public static final short DELETE = 0;

    /**
     * 正常
     */
    public static final short NORMAL = 1;

    static {
        map = new LinkedHashMap<Short, String>();
        map.put(DELETE, "已删除");
        map.put(NORMAL, "正常");
    }

    /**
     * 得到描述
     *
     * @param id 传入id
     * @return String
     */
    public static String getDescription(Short id) {
        return map.get(id);
    }

    /**
     * @return String
     */
    public static String toJson() {
        try {
            return EgoistJsonUtil.objectToJson(map);
        } catch (EgoistException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @return Map
     */
    public static Map getMap() {
        return map;
    }

    /**
     * 中文转成值
     *
     * @param description 中文描述
     * @return 值
     */
    public static Short parse(String description) {
        if (StringUtils.isBlank(description)) {
            return null;
        }

        for (Map.Entry entry : map.entrySet()) {
            String value = (String) entry.getValue();
            if (value.equals(description)) {
                return (Short) entry.getKey();
            }
        }

        return null;
    }

}

package com.egoist.parent.common.utils.collection;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public final class EgoistCollectionUtil {
    private EgoistCollectionUtil() {

    }

    /**
     * 判断是否为null 或者 list.size() == 0
     *
     * @param list 集合
     * @return 返回是否为null 或者 list.size() == 0
     * @Title: isEmpty
     * @Description: 判断是否为null 或者 list.size() == 0
     */
    public static boolean isEmpty(List<?> list) {
        if (null == list || list.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否不为null 或者 list.size() == 0
     *
     * @param list 集合
     * @return 返回是否不为null 或者 list.size() == 0
     * @Title: isNotEmpty
     * @Description: 判断是否不为null 或者 list.size() == 0
     */
    public static boolean isNotEmpty(List<?> list) {
        return !isEmpty(list);
    }

    /**
     * 判断Set集合是否为null 或者 set.size() == 0
     *
     * @param set Set集合
     * @return 返回Set集合是否为null 或者 set.size() == 0
     * @Title: isEmpty
     * @Description: 判断Set集合是否为null 或者 set.size() == 0
     */
    public static boolean isEmpty(Set<?> set) {
        if (null == set || set.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * 判断Set集合是否不为 null 或者 set.size() == 0
     *
     * @param set Set集合
     * @return 返回Set集合是否不为 null 或者 set.size() == 0
     * @Title: isNotEmpty
     * @Description: 判断Set集合是否不为 null 或者 set.size() == 0
     */
    public static boolean isNotEmpty(Set<?> set) {
        return !isEmpty(set);
    }

    /**
     * 判断是否为null 或者 list.size() == 0
     *
     * @param collection 集合
     * @return 返回是否为null 或者 list.size() == 0
     * @Title: isEmpty
     * @Description: 判断是否为null 或者 list.size() == 0
     */
    public static boolean isEmpty(Collection<?> collection) {
        if (null == collection || collection.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否不为null 或者 list.size() == 0
     *
     * @param collection 集合
     * @return 返回是否不为null 或者 list.size() == 0
     * @Title: isNotEmpty
     * @Description: 判断是否不为null 或者 list.size() == 0
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }
}

package com.egoist.parent.common.utils.json;

import com.egoist.parent.common.exception.EgoistException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 *  json工具类
 */
public final class EgoistJsonUtil {
    private EgoistJsonUtil () {

    }

    /**
     * 定义Jackson的ObjectMapper实例对象
     */
    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 将对象转换成json字符串。
     *
     * @param data 目标数据
     * @return 返回Json字符串
     * @throws EgoistException 异常
     */
    public static String objectToJson(Object data) throws EgoistException {
//        if (null == data) {
//            return null;
//        }
        try {
            return MAPPER.writeValueAsString(data);
        } catch (Exception e) {
            throw new EgoistException(e);
        }
    }

    /**
     * 将json结果集转化为对象
     *
     * @param json     json数据
     * @param beanType 对象中的object类型
     * @param <T>      POJO类型
     * @return 返回目标POJO实例对象
     * @throws EgoistException 异常
     */
    public static <T> T jsonToPojo(String json, Class<T> beanType) throws EgoistException {
        try {
            if (StringUtils.isBlank(json) || null == beanType) {
                return null;
            }
            T t = MAPPER.readValue(json, beanType);
            return t;
        } catch (Exception e) {
            throw new EgoistException(e);
        }
    }

    /**
     * 将json数据转换成pojo对象list
     *
     * @param json     Json字符串
     * @param beanType POJO的Class
     * @param <T>      POJO类型
     * @return 返回目标POJO的集合
     * @throws EgoistException 异常
     */
    public static <T> List<T> jsonToList(String json, Class<T> beanType) throws EgoistException {
        try {
            JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
            return MAPPER.readValue(json, javaType);
        } catch (Exception e) {
            throw new EgoistException(e);
        }
    }
}

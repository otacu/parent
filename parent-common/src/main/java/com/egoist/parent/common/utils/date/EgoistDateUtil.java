package com.egoist.parent.common.utils.date;

import com.egoist.parent.common.exception.EgoistException;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public final class EgoistDateUtil extends org.apache.commons.lang3.time.DateUtils {
    //  // Slash(/)：斜线 ，line(-):线 ， Dot(.)：点 ，中文(CHINESE)

    /**
     * 默认1970-01-01替换的值，用于显示的
     */
    public static final String DEFAULT_SINCE_1970_VALUE = "";

    /**
     * 默认认证码日期，由于是2017-07-20之后才上线的，因此可以设置这个时间。
     */
    public static final String DEFAULT_VERIFICATION_CODE_DATE = "2017-06-20";  // 2017-07-20

    /**
     * 东8区时区，北京时间
     */
    public static final TimeZone TIME_ZONE_GMT_8 = TimeZone.getTimeZone("GMT+8");

    /**
     * 一年365天
     */
    public static final int YEAR_OF_DAYS_365 = 365;

    /**
     * 一年366天
     */
    public static final int YEAR_OF_DAYS_366 = 366;

    /**
     * 一周的星期
     */
    public static final String[] WEEKDAYS = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};

    /////////////////// MyBatis 逆向工程支持的日期 ## Begin /////////////////////

    /////////////////// 中文日期格式 ## Begin  ///////////////////

    /**
     * MyBatis逆向工程生成日期格式：2017年05月02日 22:12:28:998
     */
    public static final String AT_CN_YYYY_MM_DD_HH_MM_SS_SSS = "@CnYyyyMMddHHmmssSSS";

    /**
     * MyBatis逆向工程生成日期格式：2017年05月02日 22:12:28
     */
    public static final String AT_CN_YYYY_MM_DD_HH_MM_SS = "@CnYyyyMMddHHmmss";

    /**
     * MyBatis逆向工程生成日期格式：2017年05月02日 22:12
     */
    public static final String AT_CN_YYYY_MM_DD_HH_MM = "@CnYyyyMMddHHmm";

    /**
     * MyBatis逆向工程生成日期格式：2017年05月02日 22
     */
    public static final String AT_CN_YYYY_MM_DD_HH = "@CnYyyyMMddHH";

    /**
     * MyBatis逆向工程生成日期格式：2017年05月02日
     */
    public static final String AT_CN_YYYY_MM_DD = "@CnYyyyMMdd";

    /**
     * MyBatis逆向工程生成日期格式：2017年05月
     */
    public static final String AT_CN_YYYY_MM = "@CnYyyyMM";

    /**
     * MyBatis逆向工程生成日期格式：2017年
     */
    public static final String AT_CN_YYYY = "@CnYyyy";

    /////////////////// 中文日期格式 ## End  ///////////////////

    /////////////////// 英文日期格式 ## Begin  ///////////////////

    /**
     * MyBatis逆向工程生成日期格式：2017年05月02日 22:12:28:998
     */
    public static final String AT_EN_YYYY_MM_DD_HH_MM_SS_SSS = "@EnYyyyMMddHHmmssSSS";

    /**
     * MyBatis逆向工程生成日期格式：2017-05-02 22:12:28
     */
    public static final String AT_EN_YYYY_MM_DD_HH_MM_SS = "@EnYyyyMMddHHmmss";

    /**
     * MyBatis逆向工程生成日期格式：2017-05-02 22:12
     */
    public static final String AT_EN_YYYY_MM_DD_HH_MM = "@EnYyyyMMddHHmm";

    /**
     * MyBatis逆向工程生成日期格式：2017-05-02 22
     */
    public static final String AT_EN_YYYY_MM_DD_HH = "@EnYyyyMMddHH";

    /**
     * MyBatis逆向工程生成日期格式：2017年05月02日
     */
    public static final String AT_EN_YYYY_MM_DD = "@EnYyyyMMdd";

    /**
     * MyBatis逆向工程生成日期格式：2017-05
     */
    public static final String AT_EN_YYYY_MM = "@EnYyyyMM";

    /**
     * MyBatis逆向工程生成日期格式：2017
     */
    public static final String AT_EN_YYYY = "@EnYyyy";

    /**
     * MyBatis逆向工程生成日期格式：22:12:28:998
     */
    public static final String AT_EN_HH_MM_SS_SSS = "@EnHHmmssSSS";

    /**
     * MyBatis逆向工程生成日期格式：22:12:28，小时:分钟:秒
     */
    public static final String AT_EN_HH_MM_SS = "@EnHHmmss";

    /**
     * MyBatis逆向工程生成日期格式：22:12，小时:分钟
     */
    public static final String AT_EN_HH_MM = "@EnHHmm";

    /**
     * MyBatis逆向工程生成日期格式：22，小时
     */
    public static final String AT_EN_HH = "@EnHH";

    //    /**
    //     * MyBatis逆向工程生成日期格式：12，月份
    //     */
    //    public static final String AT_EN_MONTH = "@EnMonth";

    //    /**
    //	 * MyBatis逆向工程生成日期格式：03，日
    //	 */
    //	public static final String AT_EN_DD = "@EnDD";

    //    /**
    //     * MyBatis逆向工程生成日期格式：38，分钟
    //     */
    //    public static final String AT_EN_MINUTE = "@EnMinute";

    /**
     * MyBatis逆向工程生成日期格式：38，分钟
     */
    public static final String AT_EN_MM = "@EnMM";


    /////////////////// 英文日期格式 ## End  ///////////////////

    /**
     * 1970-01-01 00:00:00
     */
    public static final String SINCE_1970 = "1971-01-01 00:00:00";

//    /**
//     * 1970-01-01
//     */
//    private static final String SINCE_1970_SHORT = "1970-01-01";

    /**
     * 1970-01
     */
    private static final String SINCE_1970_SHORT = "1971-01";


    /**
     * yyyy-MM-dd HH:mm:ss
     */
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";


    /////////////////// MyBatis 逆向工程支持的日期 ## End /////////////////////

    private EgoistDateUtil() {
        throw new AssertionError();
    }

    /////////////////////// 英文-日期格式，Begin  /////////////////////////////
    /**
     * 日期格式：yyyy-MM-dd，例如：2017-04-24
     */
    private static final ThreadLocal<SimpleDateFormat> YYYY_MM_DD_DOT_FORMAT = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            // Docker容器中，存在时区问题
            return new SimpleDateFormat("yyyy.MM.dd");
            // 默认设置东8区的时区，如果是国际化，就存在问题！！！
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            sdf.setTimeZone(TIME_ZONE_GMT_8);
//            return sdf;
        }
    };
    /**
     * 日期格式：yyyy-MM-dd HH:mm:ss:SSS，例如：2017-04-24 15:35:18:998
     */
    private static final ThreadLocal<SimpleDateFormat> YYYY_MM_DD_HH_MM_SS_SSS_FORMAT = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            // Docker容器中，存在时区问题
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
            // 默认设置东8区的时区，如果是国际化，就存在问题！！！
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
//            sdf.setTimeZone(TIME_ZONE_GMT_8);
//            return sdf;
        }
    };

    /**
     * 日期格式：yyyy-MM-dd HH:mm:ss，例如：2017-04-24 15:35:18
     */
    private static final ThreadLocal<SimpleDateFormat> YYYY_MM_DD_HH_MM_SS_FORMAT = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            // Docker容器中，存在时区问题
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            // 默认设置东8区的时区，如果是国际化，就存在问题！！！
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            sdf.setTimeZone(TIME_ZONE_GMT_8);
//            return sdf;
        }
    };

    /**
     * 日期格式：yyyy-MM-dd HH:mm，例如：2017-04-24 15:35
     */
    private static final ThreadLocal<SimpleDateFormat> YYYY_MM_DD_HH_MM_FORMAT = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            // Docker容器中，存在时区问题
            return new SimpleDateFormat("yyyy-MM-dd HH:mm");
            // 默认设置东8区的时区，如果是国际化，就存在问题！！！
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//            sdf.setTimeZone(TIME_ZONE_GMT_8);
//            return sdf;
        }
    };

    /**
     * 日期格式：yyyy-MM-dd HH，例如：2017-04-24 15
     */
    private static final ThreadLocal<SimpleDateFormat> YYYY_MM_DD_HH_FORMAT = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            // Docker容器中，存在时区问题
            return new SimpleDateFormat("yyyy-MM-dd HH");
            // 默认设置东8区的时区，如果是国际化，就存在问题！！！
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH");
//            sdf.setTimeZone(TIME_ZONE_GMT_8);
//            return sdf;
        }
    };

    /**
     * 日期格式：yyyy-MM-dd，例如：2017-04-24
     */
    private static final ThreadLocal<SimpleDateFormat> YYYY_MM_DD_FORMAT = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            // Docker容器中，存在时区问题
            return new SimpleDateFormat("yyyy-MM-dd");
            // 默认设置东8区的时区，如果是国际化，就存在问题！！！
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            sdf.setTimeZone(TIME_ZONE_GMT_8);
//            return sdf;
        }
    };

    /**
     * 日期格式：yyyy-MM，例如：2017-04
     */
    private static final ThreadLocal<SimpleDateFormat> YYYY_MM_FORMAT = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            // Docker容器中，存在时区问题
            return new SimpleDateFormat("yyyy-MM");
            // 默认设置东8区的时区，如果是国际化，就存在问题！！！
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
//            sdf.setTimeZone(TIME_ZONE_GMT_8);
//            return sdf;
        }
    };

    /**
     * 日期格式：yyyy，例如：2017
     */
    private static final ThreadLocal<SimpleDateFormat> YYYY_FORMAT = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            // Docker容器中，存在时区问题
            return new SimpleDateFormat("yyyy");
            // 默认设置东8区的时区，如果是国际化，就存在问题！！！
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
//            sdf.setTimeZone(TIME_ZONE_GMT_8);
//            return sdf;
        }
    };

    /**
     * 日期格式：HH:mm:ss:SSS，例如：15:37:18:998
     */
    private static final ThreadLocal<SimpleDateFormat> HH_MM_SS_SSS_FORMAT = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            // Docker容器中，存在时区问题
            return new SimpleDateFormat("HH:mm:ss:SSS");
            // 默认设置东8区的时区，如果是国际化，就存在问题！！！
//            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss:SSS");
//            sdf.setTimeZone(TIME_ZONE_GMT_8);
//            return sdf;
        }
    };

    /**
     * 日期格式：HH:mm:ss，例如：15:37:18
     */
    private static final ThreadLocal<SimpleDateFormat> HH_MM_SS_FORMAT = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            // Docker容器中，存在时区问题
            return new SimpleDateFormat("HH:mm:ss");
            // 默认设置东8区的时区，如果是国际化，就存在问题！！！
//            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
//            sdf.setTimeZone(TIME_ZONE_GMT_8);
//            return sdf;
        }
    };

    /**
     * 日期格式：HH:mm，例如：15:37
     */
    private static final ThreadLocal<SimpleDateFormat> HH_MM_FORMAT = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            // Docker容器中，存在时区问题
            return new SimpleDateFormat("HH:mm");
            // 默认设置东8区的时区，如果是国际化，就存在问题！！！
//            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
//            sdf.setTimeZone(TIME_ZONE_GMT_8);
//            return sdf;
        }
    };

    /**
     * 日期格式：HH，例如：15
     */
    private static final ThreadLocal<SimpleDateFormat> HH_FORMAT = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            // Docker容器中，存在时区问题
            return new SimpleDateFormat("HH");
            // 默认设置东8区的时区，如果是国际化，就存在问题！！！
//            SimpleDateFormat sdf = new SimpleDateFormat("HH");
//            sdf.setTimeZone(TIME_ZONE_GMT_8);
//            return sdf;
        }
    };

    /**
     * 日期格式：mm，例如：08（分钟）
     */
    private static final ThreadLocal<SimpleDateFormat> MM_FORMAT = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            // Docker容器中，存在时区问题
            return new SimpleDateFormat("mm");
            // 默认设置东8区的时区，如果是国际化，就存在问题！！！
//            SimpleDateFormat sdf = new SimpleDateFormat("mm");
//            sdf.setTimeZone(TIME_ZONE_GMT_8);
//            return sdf;
        }
    };

    /////////////////////// 英文-日期格式，End  /////////////////////////////

    ////////////////////////// Unity 格式 ## Begin ////////////////////////

    /**
     * 日期格式：yyyyMMddHHmmssSSS，例如：20170501195808988
     */
    private static final ThreadLocal<SimpleDateFormat> YYYY_MM_DD_HH_MM_SS_SSS_UNITY = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            // Docker容器中，存在时区问题
            return new SimpleDateFormat("yyyyMMddHHmmssSSS");
            // 默认设置东8区的时区，如果是国际化，就存在问题！！！
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
//            sdf.setTimeZone(TIME_ZONE_GMT_8);
//            return sdf;
        }
    };

    /**
     * 日期格式：yyyyMMddHHmmss，例如：20170501195808
     */
    private static final ThreadLocal<SimpleDateFormat> YYYY_MM_DD_HH_MM_SS_UNITY = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            // Docker容器中，存在时区问题
            return new SimpleDateFormat("yyyyMMddHHmmss");
            // 默认设置东8区的时区，如果是国际化，就存在问题！！！
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//            sdf.setTimeZone(TIME_ZONE_GMT_8);
//            return sdf;
        }
    };

    /**
     * 日期格式：yyyyMMddHHmm，例如：201705011958
     */
    private static final ThreadLocal<SimpleDateFormat> YYYY_MM_DD_HH_MM_UNITY = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            // Docker容器中，存在时区问题
            return new SimpleDateFormat("yyyyMMddHHmm");
            // 默认设置东8区的时区，如果是国际化，就存在问题！！！
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
//            sdf.setTimeZone(TIME_ZONE_GMT_8);
//            return sdf;
        }
    };

    /**
     * 日期格式：yyyyMMddHH，例如：2017050119
     */
    private static final ThreadLocal<SimpleDateFormat> YYYY_MM_DD_HH_UNITY = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            // Docker容器中，存在时区问题
            return new SimpleDateFormat("yyyyMMddHH");
            // 默认设置东8区的时区，如果是国际化，就存在问题！！！
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
//            sdf.setTimeZone(TIME_ZONE_GMT_8);
//            return sdf;
        }
    };

    /**
     * 日期格式：yyyyMMdd，例如：20170501
     */
    private static final ThreadLocal<SimpleDateFormat> YYYY_MM_DD_UNITY = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            // Docker容器中，存在时区问题
            return new SimpleDateFormat("yyyyMMdd");
            // 默认设置东8区的时区，如果是国际化，就存在问题！！！
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//            sdf.setTimeZone(TIME_ZONE_GMT_8);
//            return sdf;
        }
    };

    /**
     * 日期格式：yyyyMM，例如：201705
     */
    private static final ThreadLocal<SimpleDateFormat> YYYY_MM_UNITY = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            // Docker容器中，存在时区问题
            return new SimpleDateFormat("yyyyMM");
            // 默认设置东8区的时区，如果是国际化，就存在问题！！！
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
//            sdf.setTimeZone(TIME_ZONE_GMT_8);
//            return sdf;
        }
    };

    /**
     * 日期格式：yyyy，例如：2017
     */
    private static final ThreadLocal<SimpleDateFormat> YYYY_UNITY = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            // Docker容器中，存在时区问题
            return new SimpleDateFormat("yyyy");
            // 默认设置东8区的时区，如果是国际化，就存在问题！！！
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
//            sdf.setTimeZone(TIME_ZONE_GMT_8);
//            return sdf;
        }
    };

    /**
     * 日期格式：HHmmss，例如：18:28:38
     */
    private static final ThreadLocal<SimpleDateFormat> HH_MM_SS_UNITY = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            // Docker容器中，存在时区问题
            return new SimpleDateFormat("HHmmss");
            // 默认设置东8区的时区，如果是国际化，就存在问题！！！
//            SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
//            sdf.setTimeZone(TIME_ZONE_GMT_8);
//            return sdf;
        }
    };

    /**
     * 日期格式：HHmm，例如：1538
     */
    private static final ThreadLocal<SimpleDateFormat> HH_MM_UNITY = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            // Docker容器中，存在时区问题
            return new SimpleDateFormat("HHmm");
            // 默认设置东8区的时区，如果是国际化，就存在问题！！！
//            SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
//            sdf.setTimeZone(TIME_ZONE_GMT_8);
//            return sdf;
        }
    };

    ////////////////////////// Unity 格式 ## End ////////////////////////

    /////////////////////// 中文日期格式，Begin /////////////////////////////

    /**
     * 日期格式：yyyy年
     */
    private static final ThreadLocal<SimpleDateFormat> YYYY_CHINESE = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            // Docker容器中，存在时区问题
            return new SimpleDateFormat("yyyy年");
            // 默认设置东8区的时区，如果是国际化，就存在问题！！！
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年");
//            sdf.setTimeZone(TIME_ZONE_GMT_8);
//            return sdf;
        }
    };

    /**
     * 日期格式：yyyy年MM月
     */
    private static final ThreadLocal<SimpleDateFormat> YYYY_MM_CHINESE = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            // Docker容器中，存在时区问题
            return new SimpleDateFormat("yyyy年MM月");
            // 默认设置东8区的时区，如果是国际化，就存在问题！！！
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月");
//            sdf.setTimeZone(TIME_ZONE_GMT_8);
//            return sdf;
        }
    };

    /**
     * 日期格式：yyyy年MM月dd日
     */
    private static final ThreadLocal<SimpleDateFormat> YYYY_MM_DD_CHINESE = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            // Docker容器中，存在时区问题
            return new SimpleDateFormat("yyyy年MM月dd日");
            // 默认设置东8区的时区，如果是国际化，就存在问题！！！
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月");
//            sdf.setTimeZone(TIME_ZONE_GMT_8);
//            return sdf;
        }
    };

    /**
     * 日期格式：yyyy年MM月dd日 HH
     */
    private static final ThreadLocal<SimpleDateFormat> YYYY_MM_DD_HH_CHINESE = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            // Docker容器中，存在时区问题
            return new SimpleDateFormat("yyyy年MM月dd日 HH");
            // 默认设置东8区的时区，如果是国际化，就存在问题！！！
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH");
//            sdf.setTimeZone(TIME_ZONE_GMT_8);
//            return sdf;
        }
    };

    /**
     * 日期格式：yyyy年MM月dd日 HH:mm
     */
    private static final ThreadLocal<SimpleDateFormat> YYYY_MM_DD_HH_MM_CHINESE = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            // Docker容器中，存在时区问题
            return new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
            // 默认设置东8区的时区，如果是国际化，就存在问题！！！
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
//            sdf.setTimeZone(TIME_ZONE_GMT_8);
//            return sdf;
        }
    };

    /**
     * 日期格式：yyyy年MM月dd日 HH:mm:ss
     */
    private static final ThreadLocal<SimpleDateFormat> YYYY_MM_DD_HH_MM_SS_CHINESE = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            // Docker容器中，存在时区问题
            return new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            // 默认设置东8区的时区，如果是国际化，就存在问题！！！
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
//            sdf.setTimeZone(TIME_ZONE_GMT_8);
//            return sdf;
        }
    };

    /**
     * 日期格式：yyyy年MM月dd日 HH:mm:ss:SSS
     */
    private static final ThreadLocal<SimpleDateFormat> YYYY_MM_DD_HH_MM_SS_SSS_CHINESE = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            // Docker容器中，存在时区问题
            return new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss:SSS");
            // 默认设置东8区的时区，如果是国际化，就存在问题！！！
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss:SSS");
//            sdf.setTimeZone(TIME_ZONE_GMT_8);
//            return sdf;
        }
    };

    /////////////////////// 中文日期格式，End  /////////////////////////////

    /**
     * 日期格式：M.d
     */
    private static final ThreadLocal<SimpleDateFormat> M_D = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            // Docker容器中，存在时区问题
            return new SimpleDateFormat("M.d");
            // 默认设置东8区的时区，如果是国际化，就存在问题！！！
//            SimpleDateFormat sdf = new SimpleDateFormat("M.d");
//            sdf.setTimeZone(TIME_ZONE_GMT_8);
//            return sdf;
        }
    };

    /**
     * yyyy-MM-dd HH:mm
     *
     * @param dateStr 日期字符串
     * @return 返回日期格式：yyyy-MM-dd HH:mm
     * @throws EgoistException 异常
     */
    public static Date parseDate(String dateStr) throws EgoistException {
        try {
            return YYYY_MM_DD_HH_MM_FORMAT.get().parse(dateStr);
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
        // new SimpleDateFormat().parse(String )
        //        new SimpleDateFormat().format(new Date())
    }


    /**
     * 日期字符串格式：yyyy-MM，转换成日期，
     *
     * @param dateStr 日期字符串，格式：yyyy-MM，否则报错
     * @return 返回日期
     * @throws EgoistException 异常
     */
    public static Date parseWithYyyyMMLine(String dateStr) throws EgoistException {
        try {
            return YYYY_MM_FORMAT.get().parse(dateStr);
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    //    /**
    //     * yyyy-MM-dd HH:mm
    //     *
    //     * @param date 日期
    //     * @return
    //     */
    //    @Deprecated
    //    public static String formatMM(Date date) {
    //        return YYYY_MM_DD_HH_MM_FORMAT.get().format(date);
    //    }

    ////////////////////// 格式化格式 ， Begin ///////////////////////////

    ////////////////////// 格式化日期格式：中文格式 ， Begin ///////////////////////////

    /**
     * 日期格式：yyyy年MM月dd日 HH:mm:ss:SSS，例如：2017年04月24日 13:58:18:998
     *
     * @param date 日期
     * @return 返回日期格式：yyyy年MM月dd日 HH:mm:ss:SSS，例如：2017年04月24日 13:58:18:998
     * @throws EgoistException 异常
     */
    public static String formatYyyyMMddHHmmssSSSChinese(Date date) throws EgoistException {
        return YYYY_MM_DD_HH_MM_SS_SSS_CHINESE.get().format(date);
    }

    /**
     * 日期格式：yyyy年MM月dd日 HH:mm:ss，例如：2017年04月24日 13:58:18
     *
     * @param date 日期
     * @return 返回日期格式：yyyy年MM月dd日 HH:mm:ss，例如：2017年04月24日 13:58:18
     * @throws EgoistException 异常
     */
    public static String formatYyyyMMddHHmmssChinese(Date date) throws EgoistException {
        return YYYY_MM_DD_HH_MM_SS_CHINESE.get().format(date);
    }

    /**
     * 日期格式：yyyy年MM月dd日 HH:mm，例如：2017年04月24日 13:58
     *
     * @param date 日期
     * @return 返回日期格式：yyyy年MM月dd日 HH:mm，例如：2017年04月24日 13:58
     * @throws EgoistException 异常
     */
    public static String formatYyyyMMddHHmmChinese(Date date) throws EgoistException {
        return YYYY_MM_DD_HH_MM_CHINESE.get().format(date);
    }

    /**
     * 日期格式：yyyy年MM月dd日 HH，例如：2017年04月24日 13
     *
     * @param date 日期
     * @return 返回日期格式：yyyy年MM月dd日 HH，例如：2017年04月24日 13
     * @throws EgoistException 异常
     */
    public static String formatYyyyMMddHHChinese(Date date) throws EgoistException {
        return YYYY_MM_DD_HH_CHINESE.get().format(date);
    }

    /**
     * 日期格式：yyyy年MM月dd日，例如：2017年04月24日
     *
     * @param date 日期
     * @return 返回日期格式：yyyy年MM月dd日，例如：2017年04月24日
     * @throws EgoistException 异常
     */
    public static String formatYyyyMMddChinese(Date date) throws EgoistException {
        return YYYY_MM_DD_CHINESE.get().format(date);
    }

    /**
     * 格式化日期为：yyyy年MM月，例如：2017年04月
     *
     * @param date 日期
     * @return 返回日期为：yyyy年MM月，例如：2017年04月
     * @throws EgoistException 异常
     */
    public static String formatYyyyMMChinese(Date date) throws EgoistException {
        return YYYY_MM_CHINESE.get().format(date);
    }

    /**
     * 格式化日期为：yyyy年，例如：2017年
     *
     * @param date 日期
     * @return 返回日期为：yyyy年，例如：2017年
     * @throws EgoistException 异常
     */
    public static String formatYyyyChinese(Date date) throws EgoistException {
        return YYYY_CHINESE.get().format(date);
    }

    ////////////////////// 格式化日期格式：中文格式 ， Begin ///////////////////////////

    ////////////////////// 格式化日期格式：英文-格式 ， Begin ///////////////////////////

    /**
     * 期格式：yyyy-MM-dd HH:mm:ss:SSS，例如：2017-04-24 13:58:18:998
     *
     * @param date 期
     * @return 返回期格式：yyyy-MM-dd HH:mm:ss:SSS，例如：2017-04-24 13:58:18:998
     * @throws EgoistException 异常
     */
    public static String formatYyyyMMddHHmmssSSS(Date date) throws EgoistException {
        try {
//            return YYYY_MM_DD_HH_MM_SS_SSS_FORMAT.get().format(date);
            String dateStr = YYYY_MM_DD_HH_MM_SS_SSS_FORMAT.get().format(date);
            if (isSince1970(dateStr)) {
                return DEFAULT_SINCE_1970_VALUE;
            }
            return dateStr;
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    /**
     * 期格式：yyyy-MM-dd HH:mm:ss，例如：2017-04-24 13:58:18
     *
     * @param date 期
     * @return 返回期格式：yyyy-MM-dd HH:mm:ss，例如：2017-04-24 13:58:18
     * @throws EgoistException 异常
     */
    public static String formatYyyyMMddHHmmss(Date date) throws EgoistException {
        try {
//            return YYYY_MM_DD_HH_MM_SS_FORMAT.get().format(date);
            if (null == date) {
                return DEFAULT_SINCE_1970_VALUE;
            }

            String dateStr = YYYY_MM_DD_HH_MM_SS_FORMAT.get().format(date);
            if (isSince1970(dateStr)) {
                return DEFAULT_SINCE_1970_VALUE;
            }
            return dateStr;
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    /**
     * 期格式：yyyy-MM-dd HH:mm，例如：2017-04-24 13:58
     *
     * @param date 期
     * @return 返回期格式：yyyy-MM-dd HH:mm，例如：2017-04-24 13:58
     * @throws EgoistException 异常
     */
    public static String formatYyyyMMddHHmm(Date date) throws EgoistException {
        try {
//            return YYYY_MM_DD_HH_MM_FORMAT.get().format(date);
            String dateStr = YYYY_MM_DD_HH_MM_FORMAT.get().format(date);
            if (isSince1970(dateStr)) {
                return DEFAULT_SINCE_1970_VALUE;
            }
            return dateStr;
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    /**
     * 期格式：yyyy-MM-dd HH，例如：2017-04-24 13
     *
     * @param date 期
     * @return 返回期格式：yyyy-MM-dd HH，例如：2017-04-24 13
     * @throws EgoistException 异常
     */
    public static String formatYyyyMMddHH(Date date) throws EgoistException {
        try {
//            return YYYY_MM_DD_HH_FORMAT.get().format(date);
            String dateStr = YYYY_MM_DD_HH_FORMAT.get().format(date);
            if (isSince1970(dateStr)) {
                return DEFAULT_SINCE_1970_VALUE;
            }
            return dateStr;
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    /**
     * 期格式：yyyy.MM.dd，例如：2019.11.11
     *
     * @param date 期
     * @return 返回期格式：yyyy.MM.dd，例如：2019.11.11
     * @throws EgoistException 异常
     */
    public static String formatYyyyMMddDot(Date date) throws EgoistException {
        try {
//            return YYYY_MM_DD_HH_FORMAT.get().format(date);
            String dateStr = YYYY_MM_DD_DOT_FORMAT.get().format(date);
            if (isSince1970(dateStr)) {
                return DEFAULT_SINCE_1970_VALUE;
            }
            return dateStr;
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    /**
     * 期格式：yyyy-MM-dd，例如：2017-04-24
     *
     * @param date 期
     * @return 返回期格式：yyyy-MM-dd，例如：2017-04-24
     * @throws EgoistException 异常
     */
    public static String formatYyyyMMdd(Date date) throws EgoistException {
        try {
//            return YYYY_MM_DD_FORMAT.get().format(date);
            String dateStr = YYYY_MM_DD_FORMAT.get().format(date);
            if (isSince1970(dateStr)) {
                return DEFAULT_SINCE_1970_VALUE;
            }
            return dateStr;
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    /**
     * 格式化期为：yyyy-MM，例如：2017-04
     *
     * @param date 期
     * @return 返回期为：yyyy-MM，例如：2017-04
     * @throws EgoistException 异常
     */
    public static String formatYyyyMM(Date date) throws EgoistException {
        try {
//            return YYYY_MM_FORMAT.get().format(date);
            String dateStr = YYYY_MM_FORMAT.get().format(date);
            if (isSince1970(dateStr)) {
                return DEFAULT_SINCE_1970_VALUE;
            }
            return dateStr;
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    /**
     * 格式化期为：yyyy，例如：2017
     *
     * @param date 期
     * @return 返回期为：yyyy，例如：2017
     * @throws EgoistException 异常
     */
    public static String formatYyyy(Date date) throws EgoistException {
        try {
            return YYYY_FORMAT.get().format(date);
            // 暂时，不处理，没有年月的
//            String dateStr = YYYY_FORMAT.get().format(date);
//            if (isSince1970(dateStr)) {
//                return DEFAULT_SINCE_1970_VALUE;
//            }
//            return dateStr;
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    /**
     * 格式化期为：HH:mm:ss:SSS，例如：15:48:18:998
     *
     * @param date 期
     * @return 返回期为：HH:mm:ss:SSS，例如：15:48:18:998
     * @throws EgoistException 异常
     */
    public static String formatHHmmssSSS(Date date) throws EgoistException {
        try {
            return HH_MM_SS_SSS_FORMAT.get().format(date);
            // 暂时，不处理，没有年月日的
//            String dateStr = HH_MM_SS_SSS_FORMAT.get().format(date);
//            if (isSince1970(dateStr)) {
//                return DEFAULT_SINCE_1970_VALUE;
//            }
//            return dateStr;
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    /**
     * 格式化期为：HH:mm:ss，例如：15:48:18
     *
     * @param date 期
     * @return 返回期为：HH:mm:ss，例如：15:48:18
     * @throws EgoistException 异常
     */
    public static String formatHHmmss(Date date) throws EgoistException {
        try {
            return HH_MM_SS_FORMAT.get().format(date);
            // 暂时，不处理，没有年月日的
//            String dateStr = HH_MM_SS_FORMAT.get().format(date);
//            if (isSince1970(dateStr)) {
//                return DEFAULT_SINCE_1970_VALUE;
//            }
//            return dateStr;
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    /**
     * 格式化期为：HH:mm，例如：15:48
     *
     * @param date 期
     * @return 返回期为：HH:mm，例如：15:48
     * @throws EgoistException 异常
     */
    public static String formatHHmm(Date date) throws EgoistException {
        try {
            return HH_MM_FORMAT.get().format(date);
//            String dateStr = HH_MM_FORMAT.get().format(date);
//            if (isSince1970(dateStr)) {
//                return DEFAULT_SINCE_1970_VALUE;
//            }
//            return dateStr;
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    /**
     * 格式化期为：HH ，例如：15 (小时）
     *
     * @param date 期
     * @return 返回期为：HH ，例如：15 (小时）
     * @throws EgoistException 异常
     */
    public static String formatHH(Date date) throws EgoistException {
        try {
            return HH_FORMAT.get().format(date);
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    /**
     * 格式化期为：HH:mm，例如：15（分钟）
     *
     * @param date 期
     * @return 返回期为：HH:mm，例如：15（分钟）
     * @throws EgoistException 异常
     */
    public static String formatMM(Date date) throws EgoistException {
        try {
            return MM_FORMAT.get().format(date);
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    ////////////////////// 格式化日期格式：英文-格式 ， Begin ///////////////////////////

    //////////////////////// Unity ### Begin ////////////////////////////////////

    /**
     * 期格式：yyyyMMddHHmmssSSS，例如：20170501283848988
     *
     * @param date 期
     * @return 返回期格式：yyyyMMddHHmmssSSS，例如：20170501283848988
     * @throws EgoistException 异常
     */
    public static String formatYyyyMMddHHmmssSSSUnity(Date date) throws EgoistException {
        try {
            return YYYY_MM_DD_HH_MM_SS_SSS_UNITY.get().format(date);
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    /**
     * 期格式：yyyyMMddHHmmss，例如：20170501283848
     *
     * @param date 期
     * @return 返回期格式：yyyyMMddHHmmss，例如：20170501283848
     * @throws EgoistException 异常
     */
    public static String formatYyyyMMddHHmmssUnity(Date date) throws EgoistException {
        try {
            return YYYY_MM_DD_HH_MM_SS_UNITY.get().format(date);
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    /**
     * 期格式：yyyyMMddHHmm，例如：201705012006
     *
     * @param date 期
     * @return 返回期格式：yyyyMMddHHmm，例如：201705012006
     * @throws EgoistException 异常
     */
    public static String formatYyyyMMddHHmmUnity(Date date) throws EgoistException {
        try {
            return YYYY_MM_DD_HH_MM_UNITY.get().format(date);
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    /**
     * 期格式：yyyyMMddHH，例如：2017050120
     *
     * @param date 期
     * @return 返回期格式：yyyyMMddHH，例如：2017050120
     * @throws EgoistException 异常
     */
    public static String formatYyyyMMddHHUnity(Date date) throws EgoistException {
        try {
            return YYYY_MM_DD_HH_UNITY.get().format(date);
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    /**
     * 期格式：yyyyMMdd，例如：20170501
     *
     * @param date 期
     * @return 返回期格式：yyyyMMdd，例如：20170501
     * @throws EgoistException 异常
     */
    public static String formatYyyyMMddUnity(Date date) throws EgoistException {
        try {
            return YYYY_MM_DD_UNITY.get().format(date);
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    /**
     * 格式化期为：yyyyMM，例如：201705
     *
     * @param date 期
     * @return 返回期为：yyyyMM，例如：201705
     * @throws EgoistException 异常
     */
    public static String formatYyyyMMUnity(Date date) throws EgoistException {
        try {
            return YYYY_MM_UNITY.get().format(date);
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    /**
     * 格式化期为：yyyy，例如：2017
     *
     * @param date 期
     * @return 返回期为：yyyy，例如：2017
     * @throws EgoistException 异常
     */
    public static String formatYyyyUnity(Date date) throws EgoistException {
        try {
            return YYYY_UNITY.get().format(date);
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    /**
     * 格式化期为：HHmmss，例如：154818
     *
     * @param date 期
     * @return 返回期为：HHmmss，例如：154818
     * @throws EgoistException 异常
     */
    public static String formatHHmmssUnity(Date date) throws EgoistException {
        try {
            return HH_MM_SS_UNITY.get().format(date);
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    /**
     * 格式化期为：HHmm，例如：1548
     *
     * @param date 期
     * @return 返回期为：HHmm，例如：1548
     * @throws EgoistException 异常
     */
    public static String formatHHmmUnity(Date date) throws EgoistException {
        try {
            return HH_MM_UNITY.get().format(date);
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    //////////////////////// Unity ### End ////////////////////////////////////


    ////////////////////// 格式化格式 ， End  ///////////////////////////


    ////////////////////// 转换为日期Date ， Begin  ///////////////////////////

    ////////////////////// 中文日期，转换为日期 Date ， Begin  ///////////////////////////

    /**
     * 将中文日期格式：2017年04月24日 15:05:02 转换成 Date
     *
     * @param dateStr 日期格式字符串，例如：2017年04月24日 15:05:02
     * @return
     * @throws EgoistException 异常
     */
    public static Date parseWithYyyyMMddHHmmssChinese(String dateStr) throws EgoistException {
        try {
            if (StringUtils.isBlank(dateStr)) {
                return null;
            }
            dateStr = dateStr.trim();
            return YYYY_MM_DD_HH_MM_SS_CHINESE.get().parse(dateStr);
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    /**
     * 将中文日期格式：2017年04月24日 15:05 转换成 Date
     *
     * @param dateStr 日期格式字符串，例如：2017年04月24日 15:05
     * @return
     * @throws EgoistException 异常
     */
    public static Date parseWithYyyyMMddHHmmChinese(String dateStr) throws EgoistException {
        try {
            if (StringUtils.isBlank(dateStr)) {
                return null;
            }
            dateStr = dateStr.trim();
            return YYYY_MM_DD_HH_MM_CHINESE.get().parse(dateStr);
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    /**
     * 将中文日期格式：2017年04月24日 15 转换成 Date
     *
     * @param dateStr 日期格式字符串，例如：2017年04月24日 15
     * @return
     * @throws EgoistException 异常
     */
    public static Date parseWithYyyyMMddHHChinese(String dateStr) throws EgoistException {
        try {
            if (StringUtils.isBlank(dateStr)) {
                return null;
            }
            dateStr = dateStr.trim();
            return YYYY_MM_DD_HH_CHINESE.get().parse(dateStr);
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    /**
     * 将中文日期格式：2017年04月24日 转换成 Date
     *
     * @param dateStr 日期格式字符串，例如：2017年04月24日
     * @return
     * @throws EgoistException 异常
     */
    public static Date parseWithYyyyMMddChinese(String dateStr) throws EgoistException {
        try {
            if (StringUtils.isBlank(dateStr)) {
                return null;
            }
            dateStr = dateStr.trim();
            return YYYY_MM_DD_CHINESE.get().parse(dateStr);
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    /**
     * 将中文日期格式：2017年04月 转换成 Date
     *
     * @param dateStr 日期格式字符串，例如：2017年04月
     * @return
     * @throws EgoistException 异常
     */
    public static Date parseWithYyyyMMChinese(String dateStr) throws EgoistException {
        try {
            if (StringUtils.isBlank(dateStr)) {
                return null;
            }
            dateStr = dateStr.trim();
            return YYYY_MM_CHINESE.get().parse(dateStr);
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    /**
     * 将中文日期格式：2017年 转换成 Date
     *
     * @param dateStr 日期格式字符串，例如：2017年
     * @return
     * @throws EgoistException 异常
     */
    public static Date parseWithYyyyChinese(String dateStr) throws EgoistException {
        try {
            if (StringUtils.isBlank(dateStr)) {
                return null;
            }
            dateStr = dateStr.trim();
            return YYYY_CHINESE.get().parse(dateStr);
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    ////////////////////// 中文日期，转换为日期 Date ， End  ///////////////////////////


    ////////////////////// 英文-日期，转换为日期 Date ， Begin  ///////////////////////////

    /**
     * 将英文日期格式 转换成 Date
     *
     * @param dateStr 期格式字符串，例如：2017-04-24 15:05:02
     * @return
     * @throws EgoistException 异常
     */
    public static Date parseWithYyyyMMddHHmmss(String dateStr) throws EgoistException {
        try {
            if (StringUtils.isBlank(dateStr)) {
                return null;
            }
            dateStr = dateStr.trim();
            return YYYY_MM_DD_HH_MM_SS_FORMAT.get().parse(dateStr);
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    /**
     * 将英文日期格式 转换成 Date
     *
     * @param dateStr 英文日期格式字符串，例如：2017-04-24 15:05
     * @return
     * @throws EgoistException 异常
     */
    public static Date parseWithYyyyMMddHHmm(String dateStr) throws EgoistException {
        try {
            if (StringUtils.isBlank(dateStr)) {
                return null;
            }
            dateStr = dateStr.trim();
            return YYYY_MM_DD_HH_MM_FORMAT.get().parse(dateStr);
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    /**
     * 将英文日期格式 转换成 Date
     *
     * @param dateStr 英文日期格式字符串，例如：2017-04-24 15
     * @return
     * @throws EgoistException 异常
     */
    public static Date parseWithYyyyMMddHH(String dateStr) throws EgoistException {
        try {
            if (StringUtils.isBlank(dateStr)) {
                return null;
            }
            dateStr = dateStr.trim();
            return YYYY_MM_DD_HH_FORMAT.get().parse(dateStr);
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    /**
     * 将英文日期格式 转换成 Date
     *
     * @param dateStr 期格式字符串，例如：2017-04-24
     * @return
     * @throws EgoistException 异常
     */
    public static Date parseWithYyyyMMdd(String dateStr) throws EgoistException {
        try {
            if (StringUtils.isBlank(dateStr)) {
                return null;
            }
            dateStr = dateStr.trim();
            return YYYY_MM_DD_FORMAT.get().parse(dateStr);
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    /**
     * 将英文日期格式 转换成 Date
     *
     * @param dateStr 英文日期格式字符串，例如：2017-04
     * @return
     * @throws EgoistException 异常
     */
    public static Date parseWithYyyyMM(String dateStr) throws EgoistException {
        try {
            if (StringUtils.isBlank(dateStr)) {
                return null;
            }
            dateStr = dateStr.trim();
            return YYYY_MM_FORMAT.get().parse(dateStr);
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    /**
     * 年 转换成 Date
     *
     * @param dateStr 年字符串，例如：2017
     * @return
     * @throws EgoistException 异常
     */
    public static Date parseWithYyyy(String dateStr) throws EgoistException {
        try {
            if (StringUtils.isBlank(dateStr)) {
                return null;
            }
            dateStr = dateStr.trim();
            return YYYY_FORMAT.get().parse(dateStr);
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    ////////////////////// 英文-日期，转换为日期 Date ， End  ///////////////////////////

    ////////////////////// 转换为日期Date ， End  ///////////////////////////

    ////////////////////// 将日期的 long值转换成中文字符串日期 ， Begin  ///////////////////////////

    /**
     * 日期格式：yyyy年MM月dd日 HH:mm:ss，例如：2017年04月24日 13:58:18
     *
     * @param time 日期时间
     * @return 返回日期格式：yyyy年MM月dd日 HH:mm:ss，例如：2017年04月24日 13:58:18
     * @throws EgoistException 异常
     */
    public static String toYyyyMMddHHmmssChinese(long time) throws EgoistException {
        try {
            return formatYyyyMMddHHmmssChinese(new Date(time));
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    /**
     * 日期格式：yyyy年MM月dd日 HH:mm，例如：2017年04月24日 13:58
     *
     * @param time 日期时间
     * @return 返回日期格式：yyyy年MM月dd日 HH:mm，例如：2017年04月24日 13:58
     * @throws EgoistException 异常
     */
    public static String toYyyyMMddHHmmChinese(long time) throws EgoistException {
        try {
            return formatYyyyMMddHHmmChinese(new Date(time));
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    /**
     * 日期格式：yyyy年MM月dd日 HH，例如：2017年04月24日 13
     *
     * @param time 日期时间
     * @return 返回日期格式：yyyy年MM月dd日 HH，例如：2017年04月24日 13
     * @throws EgoistException 异常
     */
    public static String toYyyyMMddHHChinese(long time) throws EgoistException {
        try {
            return formatYyyyMMddHHChinese(new Date(time));
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    /**
     * 日期格式：yyyy年MM月dd日，例如：2017年04月24日
     *
     * @param time 日期时间
     * @return 返回日期格式：yyyy年MM月dd日，例如：2017年04月24日
     * @throws EgoistException 异常
     */
    public static String toYyyyMMddChinese(long time) throws EgoistException {
        try {
            return formatYyyyMMddChinese(new Date(time));
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    /**
     * 格式化日期为：yyyy年MM月，例如：2017年04月
     *
     * @param time 日期时间
     * @return 返回日期为：yyyy年MM月，例如：2017年04月
     * @throws EgoistException 异常
     */
    public static String toYyyyMMChinese(long time) throws EgoistException {
        try {
            return formatYyyyMMChinese(new Date(time));
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    /**
     * 格式化日期为：yyyy年，例如：2017年
     *
     * @param time 日期时间
     * @return 返回日期为：yyyy年，例如：2017年
     * @throws EgoistException 异常
     */
    public static String toYyyyChinese(long time) throws EgoistException {
        try {
            return formatYyyyChinese(new Date(time));
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    ////////////////////// 将日期的 long值转换成中文字符串日期 ， End  ///////////////////////////

    ////////////////////// 将日期的 long值转换成字英文符串日期 ， End  ///////////////////////////

    /**
     * 日期格式：yyyy-MM-dd HH:mm:ss，例如：2017-04-24 13:58:18
     *
     * @param time 日期时间
     * @return 返回日期格式：yyyy-MM-dd HH:mm:ss，例如：2017-04-24 13:58:18
     * @throws EgoistException 异常
     */
    public static String toYyyyMMddHHmmss(long time) throws EgoistException {
        try {
            return formatYyyyMMddHHmmss(new Date(time));
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    /**
     * 日期格式：yyyy-MM-dd HH:mm，例如：2017-04-24 13:58
     *
     * @param time 日期时间
     * @return 返回日期格式：yyyy-MM-dd HH:mm，例如：2017-04-24 13:58
     * @throws EgoistException 异常
     */
    public static String toYyyyMMddHHmm(long time) throws EgoistException {
        try {
            return formatYyyyMMddHHmm(new Date(time));
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    /**
     * 日期格式：yyyy-MM-dd HH，例如：2017-04-24 13
     *
     * @param time 日期时间
     * @return 返回日期格式：yyyy-MM-dd HH，例如：2017-04-24 13
     * @throws EgoistException 异常
     */
    public static String toYyyyMMddHH(long time) throws EgoistException {
        try {
            return formatYyyyMMddHH(new Date(time));
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    /**
     * 日期格式：yyyy-MM-dd，例如：2017-04-24
     *
     * @param time 日期时间
     * @return 返回日期格式：yyyy-MM-dd，例如：2017-04-24
     * @throws EgoistException 异常
     */
    public static String toYyyyMMdd(long time) throws EgoistException {
        try {
            return formatYyyyMMdd(new Date(time));
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    /**
     * 格式化日期为：yyyy-MM，例如：2017-04
     *
     * @param time 日期时间
     * @return 返回日期为：yyyy-MM，例如：2017-04
     * @throws EgoistException 异常
     */
    public static String toYyyyMM(long time) throws EgoistException {
        try {
            return formatYyyyMM(new Date(time));
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    /**
     * 格式化日期为：yyyy，例如：2017
     *
     * @param time 日期时间
     * @return 返回日期为：yyyy，例如：2017
     * @throws EgoistException 异常
     */
    public static String toYyyy(long time) throws EgoistException {
        try {
            return formatYyyy(new Date(time));
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    ///////////////////// Unity ## Begin ///////////////////

    /**
     * 日期格式：yyyyMMddHHmmssSSS，例如：20170501201128988
     *
     * @param time 日期时间
     * @return 返回日期格式：yyyyMMddHHmmssSSS，例如：20170501201128988
     * @throws EgoistException 异常
     */
    public static String toYyyyMMddHHmmssSSSUnity(long time) throws EgoistException {
        try {
            return formatYyyyMMddHHmmssSSSUnity(new Date(time));
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    /**
     * 日期格式：yyyyMMddHHmmss，例如：20170501201128
     *
     * @param time 日期时间
     * @return 返回日期格式：yyyyMMddHHmmss，例如：20170501201128
     * @throws EgoistException 异常
     */
    public static String toYyyyMMddHHmmssUnity(long time) throws EgoistException {
        try {
            return formatYyyyMMddHHmmssUnity(new Date(time));
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    /**
     * 日期格式：yyyyMMddHHmm，例如：201705011358
     *
     * @param time 日期时间
     * @return 返回日期格式：yyyyMMddHHmm，例如：201705011358
     * @throws EgoistException 异常
     */
    public static String toYyyyMMddHHmmUnity(long time) throws EgoistException {
        try {
            return formatYyyyMMddHHmmUnity(new Date(time));
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    /**
     * 日期格式：yyyyMMddHH，例如：2017050113
     *
     * @param time 日期时间
     * @return 返回日期格式：yyyyMMddHH，例如：2017050113
     * @throws EgoistException 异常
     */
    public static String toYyyyMMddHHUnity(long time) throws EgoistException {
        try {
            return formatYyyyMMddHHUnity(new Date(time));
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    /**
     * 日期格式：yyyyMMdd，例如：20170501
     *
     * @param time 日期时间
     * @return 返回日期格式：yyyyMMdd，例如：20170501
     * @throws EgoistException 异常
     */
    public static String toYyyyMMddUnity(long time) throws EgoistException {
        try {
            return formatYyyyMMddUnity(new Date(time));
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    /**
     * 格式化日期为：yyyyMM，例如：201705
     *
     * @param time 日期时间
     * @return 返回日期为：yyyyMM，例如：201705
     * @throws EgoistException 异常
     */
    public static String toYyyyMMUnity(long time) throws EgoistException {
        try {
            return formatYyyyMMUnity(new Date(time));
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    //    /**
    //     * 格式化日期为：yyyy，例如：2017
    //     *
    //     * @param time 日期时间
    //     * @return 返回日期为：yyyy，例如：2017
    //     * @throws EgoistException 异常
    //     */
    //    public static String toYyyyForUnity(long time) throws EgoistException {
    //        try {
    //            return formatYyyy(new Date(time));
    //        } catch (Exception ex) {
    //            throw new EgoistException(ex);
    //        }
    //    }

    ///////////////////// Unity ## End  ///////////////////

    ////////////////////// 将日期的 long值转换成英文字符串日期 ， End  ///////////////////////////

    /**
     * 将yyyyMMddHHmmss日期格式 转换成 Date
     *
     * @param dateStr 期格式字符串，例如：20180118150502、yyyyMMddHHmmss
     * @return
     * @throws EgoistException 异常
     */
    public static Date parseWithYyyyMMddHHmmssUnity(String dateStr) throws EgoistException {
        try {
            if (StringUtils.isBlank(dateStr)) {
                return null;
            }
            dateStr = dateStr.trim();
            return YYYY_MM_DD_HH_MM_SS_UNITY.get().parse(dateStr);
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    ////////////////////// 解决Docker容器中，时间存在时区问题 ， Begin  ///////////////////////////


    /**
     * 获取东8区的时区，当前时间（北京时间、上海时间）
     *
     * @return 返回东8区的时区，当前时间（北京时间、上海时间）
     * @throws EgoistException 异常
     */
    public static Date getNowDate() throws EgoistException {
        try {
//            SimpleDateFormat sdf = YYYY_MM_DD_HH_MM_SS_FORMAT.get();
//            sdf.setTimeZone(TIME_ZONE_GMT_8);
//            String dateStr = sdf.format(new Date());
//            return parseWithYyyyMMddHHmmss(dateStr);
            return new Date();
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    /**
     * 获取东8区的时区，当前时间（北京时间、上海时间）
     *
     * @return 返回东8区的时区，当前时间（北京时间、上海时间）
     * @throws EgoistException 异常
     */
    public static Date getNowDateWithTimeZone() throws EgoistException {
        try {
            SimpleDateFormat sdf = YYYY_MM_DD_HH_MM_SS_FORMAT.get();
            sdf.setTimeZone(TIME_ZONE_GMT_8);
            String dateStr = sdf.format(new Date());
            return parseWithYyyyMMddHHmmss(dateStr);
//            return new Date();
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }


    ////////////////////// 解决Docker容器中，时间存在时区问题 ， End  ///////////////////////////

    /**
     * yyyy-MM-dd HH:mm:ss
     *
     * @param dateStr 日期
     * @return 返回日期
     * @throws EgoistException 异常
     */
    @Deprecated
    public static Date parseSS(String dateStr) throws EgoistException {
        try {
            return YYYY_MM_DD_HH_MM_SS_FORMAT.get().parse(dateStr);
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    @Deprecated
    public static Date parseSimpleSS(String dateStr) throws EgoistException {
        try {
            return HH_MM_SS_FORMAT.get().parse(dateStr);
        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    /**
     * yyyy-MM-dd HH:mm:ss
     *
     * @param date
     * @return
     */
    @Deprecated
    public static String formatSS(Date date) {
        if (date == null) {
            return null;
        }
        return YYYY_MM_DD_HH_MM_SS_FORMAT.get().format(date);
    }

    @Deprecated
    public static String formatSimpleSS(Date date) {
        return HH_MM_SS_FORMAT.get().format(date);
    }

    /**
     * yyyy-MM-dd
     *
     * @param dateStr
     * @return
     * @throws EgoistException
     */
    @Deprecated
    public static Date parseDD(String dateStr) {
        try {
            return YYYY_MM_DD_FORMAT.get().parse(dateStr);
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * yyyy-MM-dd
     *
     * @param date
     * @return
     */
    @Deprecated
    public static String formatDD(Date date) {
        return YYYY_MM_DD_FORMAT.get().format(date);
    }

    /**
     * @param offsetDays 当前时间的偏移：-2前天，-1昨天，0今天，1明天，2后天
     * @return yyyy-MM-dd
     * @author yangxuehua
     */
    @Deprecated
    public static String getYYYY_MM_DD(int offsetDays) {
        Calendar calendar = Calendar.getInstance();
        if (offsetDays != 0) {
            calendar.add(Calendar.DATE, offsetDays);
        }
        Date date = calendar.getTime();
        return formatDD(date);
    }

    /**
     * @param offsetDays 当前时间的偏移：-2前天，-1昨天，0今天，1明天，2后天
     * @return M.d or 明天(M.d)
     */
    public static String getDisplayName(int offsetDays) {
        Calendar calendar = Calendar.getInstance();
        if (offsetDays != 0) {
            calendar.add(Calendar.DATE, offsetDays);
        }
        Date date = calendar.getTime();
        String md = M_D.get().format(date); // e.g：5.2
        switch (offsetDays) {
            case -2:
                return "前天(" + md + ")";
            case -1:
                return "昨天(" + md + ")";
            case 0:
                return "今天(" + md + ")";
            case 1:
                return "明天(" + md + ")";
            case 2:
                return "后天(" + md + ")";
            default:
                return md;
        }
    }

    @Deprecated
    public static String getDisplayForMovieShow(String yyyy_MM_dd) throws EgoistException {
        SimpleDateFormat parse = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = parse.parse(yyyy_MM_dd);

            SimpleDateFormat monthAndDay = new SimpleDateFormat("M月dd日");
            String monthAndDayString = monthAndDay.format(date);

            String today = EgoistDateUtil.getYYYY_MM_DD(0);
            if (today.equals(yyyy_MM_dd)) {
                return "今天 " + monthAndDayString;
            }
            String tomorrow = EgoistDateUtil.getYYYY_MM_DD(1);
            if (tomorrow.equals(yyyy_MM_dd)) {
                return "明天 " + monthAndDayString;
            }
            String dayAfterTomorrow = EgoistDateUtil.getYYYY_MM_DD(2);
            if (dayAfterTomorrow.equals(yyyy_MM_dd)) {
                return "后天 " + monthAndDayString;
            }

            SimpleDateFormat format = new SimpleDateFormat("E M月dd日");
            String ret = format.format(date);
            ret = ret.replaceAll("星期", "周");
            return ret;

        } catch (Exception ex) {
            throw new EgoistException(ex);
        }
    }

    /**
     * 到第二天0点的时间间隔
     *
     * @param date
     * @return
     */
    @Deprecated
    public static long getMilliSecondToTomorrow(Date date) {
        String today = formatDD(date);
        Date today0 = parseDD(today);
        return (86400000 - (date.getTime() - today0.getTime()));
    }

    /**
     * 今年多少天，闰年（366天），平年（365天）
     *
     * @return 返回：闰年（366天），平年（365天）
     */
    public static int getYearDays() {
        //        GregorianCalendar calendar = new GregorianCalendar();
        //        int year = calendar.get(Calendar.YEAR);
        // 判断今年是闰年还是平年
        if (isLeapYear()) {
            return YEAR_OF_DAYS_366;
        } else {
            return YEAR_OF_DAYS_365;
        }
    }

    /**
     * 判断今年是闰年还是平年
     *
     * @return 返回true：是闰年（366天），false：平年（365天）
     */
    public static boolean isLeapYear() {
        GregorianCalendar calendar = new GregorianCalendar();
        int year = calendar.get(Calendar.YEAR);
        // 判断今年是闰年还是平年
        return calendar.isLeapYear(year);
    }

    /**
     * 判断两个时间是否相差指定毫秒
     *
     * @param start   开始时间
     * @param expires 结束时间
     * @param ms      指定毫秒
     * @return 大于返回true 或者返回 flase
     */
    public static Boolean isDurationDate(Date start, Date expires, long ms) {
        long time = expires.getTime() - start.getTime();
        return time >= ms ? true : false;
    }

    ///////////////// 默认时间 1970-01-01 00:00:00 ## Begin ////////////////////////////

    /**
     * 获取1970-01-01 00:00:00 日期
     *
     * @return 1970-01-01 00:00:00 日期
     * @throws EgoistException 异常
     */
    public static Date getSince1970() throws EgoistException {
        return parseWithYyyyMMddHHmmss(SINCE_1970);
    }

    /**
     * 是否默认的1970-01-01 日期
     *
     * @param dateStr 日期字符串
     * @return true：是默认的1970-01-01 日期，false：不是1970-01-01 日期
     */
    public static boolean isSince1970(String dateStr) {
        if (StringUtils.isBlank(dateStr)) {
            return false;
        }
        // 为了简单一点，不需要判断各种格式，隐藏只要包括 1970-01 都符合
        return dateStr.trim().contains(SINCE_1970_SHORT);
    }

    ///////////////// 默认时间 1970-01-01 00:00:00 ## End ////////////////////////////

    ///////////////// java8 获取当前时间一些操作 ## BEGIN ////////////////////////////

    /**
     * 格式化 localDateTime
     *
     * @param localDateTime localDateTime
     * @param formatStr     formatStr
     * @return 格式化后日期格式
     */
    public static String formatLocalDateTime(LocalDateTime localDateTime, String formatStr) {
        return localDateTime.format(DateTimeFormatter.ofPattern(formatStr));
    }

    /**
     * 这一天的开始时间
     *
     * @param today         today
     * @param formatPattern 格式化表达式，默认yyyy-MM-dd HH:mm:ss
     * @return 格式化后的时间
     */
    public static String firstOfDay(LocalDate today, String formatPattern) {
        if (StringUtils.isBlank(formatPattern)) {
            formatPattern = YYYY_MM_DD_HH_MM_SS;
        }
        LocalDateTime localDateTime = LocalDateTime.of(today, LocalTime.of(0, 0, 0));
        return formatLocalDateTime(localDateTime, formatPattern);

    }

    /**
     * 这一天的开始时间
     *
     * @return date
     */
    public static Date firstOfDay() {
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.of(0, 0, 0));
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        Date date = Date.from(instant);
        return date;
    }

    /**
     * 这一天的最后时间
     *
     * @param today         today
     * @param formatPattern 格式化表达式，默认yyyy-MM-dd HH:mm:ss
     * @return 格式化后的时间
     */
    public static String lastOfDay(LocalDate today, String formatPattern) {
        if (StringUtils.isBlank(formatPattern)) {
            formatPattern = YYYY_MM_DD_HH_MM_SS;
        }
        LocalDateTime localDateTime = LocalDateTime.of(today, LocalTime.of(23, 59, 59));
        return formatLocalDateTime(localDateTime, formatPattern);

    }

    /**
     * 这一天的最后时间
     */
    public static Date lastOfDay() {
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.of(23, 59, 59));
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        Date date = Date.from(instant);
        return date;

    }


    /**
     * 这个月的第一天
     *
     * @param today         today
     * @param formatPattern 格式化表达式，默认yyyy-MM-dd HH:mm:ss
     * @return 格式化后的时间
     */
    public static String firstDayOfMonth(LocalDate today, String formatPattern) {
        if (StringUtils.isBlank(formatPattern)) {
            formatPattern = YYYY_MM_DD_HH_MM_SS;
        }
        LocalDate firstDay = today.with(TemporalAdjusters.firstDayOfMonth());
        LocalDateTime localDateTime = LocalDateTime.of(firstDay, LocalTime.of(0, 0, 0));
        return formatLocalDateTime(localDateTime, formatPattern);

    }

    /**
     * 某月的第一天
     *
     * @param localDate 当前时间
     * @return date
     */
    public static Date firstDayOfMonth(LocalDate localDate) {
        LocalDate firstDay = localDate.with(TemporalAdjusters.firstDayOfMonth());
        LocalDateTime localDateTime = LocalDateTime.of(firstDay, LocalTime.of(0, 0, 0));
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * 本月的第一天
     *
     * @return date
     */
    public static Date firstDayOfMonth() {
        LocalDate today = LocalDate.now();
        return firstDayOfMonth(today);
    }

    /**
     * 这个月的最后一天
     *
     * @param today         today
     * @param formatPattern 格式化表达式，默认yyyy-MM-dd HH:mm:ss
     * @return 格式化后的时间
     */
    public static String lastDayOfMonth(LocalDate today, String formatPattern) {
        if (StringUtils.isBlank(formatPattern)) {
            formatPattern = YYYY_MM_DD_HH_MM_SS;
        }
        LocalDate lastDay = today.with(TemporalAdjusters.lastDayOfMonth());
        LocalDateTime localDateTime = LocalDateTime.of(lastDay, LocalTime.of(23, 59, 59));
        return formatLocalDateTime(localDateTime, formatPattern);
    }

    /**
     * 本月的最后一天
     *
     * @return 本月的最后一天
     */
    public static Date lastDayOfMonth() {
        LocalDate today = LocalDate.now();
        return lastDayZeroTimeOfMonth(today);
    }

    /**
     * 某月的最后一天（0点）
     *
     * @param localDate 日期
     * @return 某月的最后一天
     */
    public static Date lastDayZeroTimeOfMonth(LocalDate localDate) {
        LocalTime localTime = LocalTime.of(0, 0, 0);
        return lastDayTimeOfMonth(localDate, localTime);
    }

    /**
     * 某月的最后一天（最后一秒）
     *
     * @param localDate 日期
     * @return 某月的最后一天
     */
    public static Date lastDayTimeOfMonth(LocalDate localDate) {
        LocalTime localTime = LocalTime.of(23, 59, 59);
        return lastDayTimeOfMonth(localDate, localTime);
    }

    /**
     * 某月的最后一天
     *
     * @param localDate 日期
     * @param localTime 时间
     * @return 某月的最后一天
     */
    public static Date lastDayTimeOfMonth(LocalDate localDate, LocalTime localTime) {
        LocalDate lastDay = localDate.with(TemporalAdjusters.lastDayOfMonth());
        LocalDateTime localDateTime = LocalDateTime.of(lastDay, localTime);
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * 这个年的第一天
     *
     * @param today         today
     * @param formatPattern 格式化表达式，默认yyyy-MM-dd HH:mm:ss
     * @return 格式化后的时间
     */
    public static String firstDayOfYear(LocalDate today, String formatPattern) {
        if (StringUtils.isBlank(formatPattern)) {
            formatPattern = YYYY_MM_DD_HH_MM_SS;
        }
        LocalDate firstDay = today.with(TemporalAdjusters.firstDayOfYear());
        LocalDateTime localDateTime = LocalDateTime.of(firstDay, LocalTime.of(0, 0, 0));
        return formatLocalDateTime(localDateTime, formatPattern);

    }

    /**
     * 这个年的最后一天
     *
     * @param today         today
     * @param formatPattern 格式化表达式，默认yyyy-MM-dd HH:mm:ss
     * @return 格式化后的时间
     */
    public static String lastDayOfYear(LocalDate today, String formatPattern) {
        if (StringUtils.isBlank(formatPattern)) {
            formatPattern = YYYY_MM_DD_HH_MM_SS;
        }
        LocalDate lastDay = today.with(TemporalAdjusters.lastDayOfYear());
        LocalDateTime localDateTime = LocalDateTime.of(lastDay, LocalTime.of(23, 59, 59));
        return formatLocalDateTime(localDateTime, formatPattern);

    }

    /**
     * CRON 表达式格式
     */
    private static final String CRON_DATE_FORMAT = "ss mm HH dd MM ? yyyy";

    /***
     * @param date 时间
     * @return cron类型的日期
     */
    public static String getCron(final Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(CRON_DATE_FORMAT);
        String formatTimeStr = "";
        if (date != null) {
            formatTimeStr = sdf.format(date);
        }
        return formatTimeStr;
    }

    /**
     * 获取当前时间并且格式化
     *
     * @return yyyyMMddHHmmss
     */
    public static String getNowYyyyMmDdHhMmSs() {
        //自定义格式化器
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        //获取当前日期和时间
        LocalDateTime ldt = LocalDateTime.now();
        return ldt.format(dtf);
    }
    ///////////////// java8 获取当前时间一些操作 ## END ////////////////////////////

    //    public static

    /**
     * 获取7天之前的时间
     *
     * @param date 日期
     * @return
     */
    public static Date getWeetDay(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, -7);
        Date d = c.getTime();
        return d;
    }


    /**
     * 获取一个月之前的时间
     *
     * @param date 日期
     * @return
     */
    public static Date getMonthDay(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, -1);
        Date m = c.getTime();
        return m;
    }
}

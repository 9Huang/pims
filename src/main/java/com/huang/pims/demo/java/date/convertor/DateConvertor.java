package com.huang.pims.demo.java.date.convertor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * 日期类型转换器
 * @author huang
 */
public class DateConvertor {

    /**
     * java.util.Date --> java.time.LocalDateTime
     */
    public static LocalDateTime toLocalDateTime(@NotNull Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * java.util.Date --> java.time.LocalDate
     */
    public static LocalDate toLocalDate(@NotNull Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * java.util.Date --> java.time.LocalTime
     */
    public static LocalTime toLocalTime(@NotNull Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).toLocalTime();
    }

    /**
     * java.time.LocalDate --> java.util.Date
     */
    public static Date toDate(@NotNull LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * java.time.LocalTime & java.time.LocalDate --> java.util.Date
     */
    public static Date toDate(@NotNull LocalDate localDate, @NotNull LocalTime localTime) {
        return Date.from(LocalDateTime.of(localDate, localTime).atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * java.time.LocalDateTime --> java.util.Date
     */
    public static Date toDate(@NotNull LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

}

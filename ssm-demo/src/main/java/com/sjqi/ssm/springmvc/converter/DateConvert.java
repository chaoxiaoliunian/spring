package com.sjqi.ssm.springmvc.converter;

import org.springframework.core.convert.converter.Converter;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @ClassName DateConvert
 * @Description 日期转换器
 * @Author sjqi
 * @Date 9:14 2019/4/11
 * @Version 1.0
 **/
public class DateConvert implements Converter<String, Date> {
    /**
     * 参数绑定阶段当一个类持有Date类型的属性时，必须编写类型转换器，否则会导致404.
     * @param s
     * @return
     */
    @Override
    public Date convert(String s) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(s, dateTimeFormatter);
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = date.atStartOfDay().atZone(zone).toInstant();
        return Date.from(instant);
    }

    public static void main(String[] args) {
        System.out.println(new DateConvert().convert("2018-09-10"));
    }
}

package com.zdatbit.jdk8.localDate;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Set;

public class LocalDatePractice {

    @Test
    public void test6(){
        Instant instant = Instant.now();
        System.out.println(instant);
    }

    /**
     * ZonedDateTime
     */
    @Test
    public void test5(){
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
    }
    /**
     * DateTimeFormatter
     */
    @Test
    public void test4(){
        LocalDateTime localDateTime = LocalDateTime.now();
        String time2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(localDateTime);
        String time3 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).format(localDateTime);
        System.out.println(time3);
        System.out.println(time2);

    }

    /**
     * localTime
     */
    @Test
    public void test3(){
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
    }

    /**
     * localDateTime
     */
    @Test
    public void test2(){
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
    }

    /**
     * localDate
     */
    @Test
    public void test1(){
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
    }
}

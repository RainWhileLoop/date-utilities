/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rwl.dateutils;

import java.text.SimpleDateFormat;
import java.time.chrono.ThaiBuddhistDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author rainwhileloop
 */
public class DateUtils {

    public static final String YEAR_PATTERN = "yyyy";
    public static final String DEFALUT_DATE_PATTERN = "dd-MMM-yyyy";

    /**
     * get year in Buddhist Era (B.E. Year)
     * @param date
     * @return 
     */
    public static Integer getBuddhistEra(Date date) {
        String year = format(date, YEAR_PATTERN);
        return Integer.parseInt(year) + 543;
    }

    public static Integer getBuddhistEra(Integer CEYear) {
        return CEYear + 543;
    }

    public static String format(Date date, String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(date);
    }

    public static String getThaiBuddhistDate(int thaiYear, int monthOfYear, int dayOfMonth, String pattern) {
        String date = null;
        if (isNull(pattern)) {
            pattern = DEFALUT_DATE_PATTERN;
        }
        try {
            date = ThaiBuddhistDate.of(thaiYear, monthOfYear, dayOfMonth).format(DateTimeFormatter.ofPattern(pattern));
        } catch (Exception e) {

        }
        return date;
    }

    public static String getNowThaiBuddhistDate(String pattern) {
        String date = null;
        if (isNull(pattern)) {
            pattern = DEFALUT_DATE_PATTERN;
        }
        try {
            date = ThaiBuddhistDate.now().format(DateTimeFormatter.ofPattern(pattern));
        } catch (Exception e) {

        }
        return date;
    }

    private static boolean isNull(String text) {
        return text == null || text.isEmpty();
    }
}

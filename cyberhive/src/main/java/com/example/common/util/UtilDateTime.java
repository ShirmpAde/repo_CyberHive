package com.example.common.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.example.module.product.ProductVo;

public class UtilDateTime {

    public static String addNowTimeString(String date) {
        LocalDateTime localDateTime = LocalDateTime.now();
        String localDateTimeString = localDateTime.format(DateTimeFormatter.ofPattern("yy:MM:dd")); 
        return date + " " + localDateTimeString;
    }

    public static String add00TimeString(String date) {
        return date + " 00:00:00";
    }

    public static String add59TimeString(String date) {
        return date + " 23:59:59";
    }
    
    public static String nowString() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
    
    // ProductVo의 날짜 필드를 조정하는 메서드
    public static void adjustProductVoDates(ProductVo vo) {
        if (vo != null) {
            vo.setShDateStart(
                vo.getShDateStart() == null || vo.getShDateStart().equals("")
                ? null
                : UtilDateTime.add00TimeString(vo.getShDateStart())
            );

            vo.setShDateEnd(
                vo.getShDateEnd() == null || vo.getShDateEnd().equals("")
                ? null
                : UtilDateTime.add59TimeString(vo.getShDateEnd())
            );
        }
    }
}

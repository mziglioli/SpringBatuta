package com.batuta.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by MicheleeMarcelo on 16/01/2016.
 */
public class DateFormatter {
    private static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private static DateFormat timeFormat = new SimpleDateFormat("K:mma");
    private static DateFormat horaFormat = new SimpleDateFormat("HH:mm");
    private static DateFormat fullDataFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public static String getCurrentTime() {
        Date today = Calendar.getInstance().getTime();
        return timeFormat.format(today);
    }

    public static String getCurrentDate() {
        Date today = Calendar.getInstance().getTime();
        return dateFormat.format(today);
    }

    public static String getDateOnlyFormatada(Date date){
        return dateFormat.format(date);
    }

    public static String getHoraFormatada(Date date){
        return horaFormat.format(date);
    }

    public static String getFullDataFormatada(Date date){
        return fullDataFormat.format(date);
    }
}

package data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateHelper {

    public static final DateTimeFormatter DATE_TIME_FMT_ISO = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        //2025-06-01T20:30:01.763-03:00
        String dataStr = "2025-06-01 20:30:01";
        final LocalDateTime localDateTime = LocalDateTime.parse(dataStr, DATE_TIME_FMT_ISO);
        System.out.println(localDateTime);
    }

}

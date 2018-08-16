package eight;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by yunshen.ljy on 2015/7/28.
 */
public class DateTimeHandle {

    public static void main(String[] args) throws InterruptedException {
        // Get the system clock as UTC offset
        final Clock clock = Clock.systemUTC();
        System.out.println(clock.instant());
        System.out.println(clock.millis());
        System.out.println(System.currentTimeMillis());

        // 获取日期 Get the local date
        final LocalDate date = LocalDate.now();
        final LocalDate dateFromClock = LocalDate.now(clock);
        LocalDateTime localDate = LocalDate.of(2016, 1, 12).atTime(0, 0, 0);
        LocalDateTime nowLocalDate = LocalDateTime.now();

        System.out.println(date);
        System.out.println(dateFromClock);
        System.out.println(localDate);
        System.out.println("时间比较:" + (localDate.isAfter(nowLocalDate)));

        // 获取时间 Get the local time
        final LocalTime time = LocalTime.now();
        final LocalTime timeFromClock = LocalTime.now(clock);

        System.out.println(time);
        System.out.println(timeFromClock);

        // 日期和时间合并 Get the local date/time
        final LocalDateTime datetime = LocalDateTime.now();
        final LocalDateTime datetimeFromClock = LocalDateTime.now(clock);

        System.out.println(datetime);
        System.out.println(datetimeFromClock);
        Long start = System.currentTimeMillis();
        System.out.println("local time long:" + start);
        Long first = getStartOfDay(start).atZone(ZoneId.of("Asia/Shanghai")).toInstant().toEpochMilli();
        System.out.println("local date time:" + first);
        System.out.println(new Date(first).toString());

        //有时区信息的日期和时间 Get the zoned date/time
        final ZonedDateTime zonedDatetime = ZonedDateTime.now();
        final ZonedDateTime zonedDatetimeFromClock = ZonedDateTime.now(clock);
        final ZonedDateTime zonedDatetimeFromZone = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));

        System.out.println(zonedDatetime);
        System.out.println(zonedDatetimeFromClock);
        System.out.println(zonedDatetimeFromZone);

        //纳秒级别时间，计算日期间隔，是否相同 Get duration between two dates
        final LocalDateTime from = LocalDateTime.of(2014, Month.APRIL, 16, 0, 0, 0);
        final LocalDateTime to = LocalDateTime.of(2015, Month.APRIL, 16, 23, 59, 59);

        final Duration duration = Duration.between(from, to);
        System.out.println("Duration in days: " + duration.toDays());
        System.out.println("Duration in hours: " + duration.toHours());

        Instant instant = Instant.now();
        //        Instant.ofEpochMilli();

        System.out.println("instant in days: " + instant.toEpochMilli());

        Instant instantY = Instant.ofEpochMilli(System.currentTimeMillis());
        YearMonth yearMonth = YearMonth.from(instant.atZone(ZoneId.of("Asia/Shanghai")));
        ZonedDateTime zonedDateTime = yearMonth.atDay(1).atStartOfDay(ZoneId.of("Asia/Shanghai"));
        System.out.println("month first day :" + zonedDateTime + ">>>>" + zonedDateTime.format(DateTimeFormatter.ofPattern
                ("yyyyMMddHHmmss")));


        LocalDate java8Release = LocalDate.of(2016, Month.APRIL, 14);
        Period periodToNextJavaRelease = Period.between(java8Release, LocalDate.now());
        System.out.println("Months left between today and Java 8 release : " + periodToNextJavaRelease.getDays());


        ZonedDateTime zs = LocalDate.of(2016, 5, 3).atTime(23, 0, 0).atZone(CHINA);
        Instant starts = zs.toInstant();
//        Thread.sleep(60*1000);
        ZonedDateTime dateTime = LocalDate.of(2016, 5, 2).atTime(23, 0, 0).atZone(CHINA);
        Instant end = dateTime.toInstant();
        Duration times = Duration.between(end,starts);
        System.out.println(times.toMinutes());
        System.out.println(times.toDays());
        System.out.println(times.toHours());


    }

    public static ZoneId CHINA = ZoneId.of("Asia/Shanghai");

    public static LocalDateTime getStartOfDay(Long milliTime) {
        LocalDate date = LocalDateTime.ofInstant(Instant.ofEpochMilli(milliTime), ZoneId.of("Asia/Shanghai")).toLocalDate();
        return getStartOfDay(date);
    }

    public static LocalDateTime getStartOfDay(LocalDate dateTime) {
        return LocalDateTime.of(dateTime, getStartOfDay());
    }

    public static LocalTime getStartOfDay() {
        return LocalTime.of(0, 0, 0, 0);
    }

}

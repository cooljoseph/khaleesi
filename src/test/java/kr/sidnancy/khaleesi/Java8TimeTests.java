package kr.sidnancy.khaleesi;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Java8Time 에 대해 모르는 것이 많이 있어서 테스트 케이스로 만들어서 라이브러리에 대한 이해 증진
 * */
public class Java8TimeTests {

    private static final Logger log = LoggerFactory.getLogger(Java8TimeTests.class);

    @Test
    public void shouldGetAfterOneDay() {
        LocalDate theDay = LocalDate.of(1582, 10, 4);
        String pattern = "yyyy.MM.dd";

        assertThat(theDay.format(DateTimeFormatter.ofPattern(pattern)), is("1582.10.04"));

        assertThat(theDay.plusDays(1).format(DateTimeFormatter.ofPattern(pattern)), is("1582.10.05"));
    }

    @Test
    public void shouldGetAfterOneHour() {
        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime.plusHours(1);
        String pattern = "yyyy.MM.dd HH:mm:ss";

        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern(pattern)));
    }

    @Test
    public void getCurrentDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime.getMonthValue();
        localDateTime.getDayOfWeek();

        log.debug("MINUTE:{}, HOUR:{}, DAYOFWEEK:{}, DAY:{}, MONTH:{}"
                , localDateTime.getMinute()
                , localDateTime.getHour()
                , localDateTime.getDayOfWeek().getValue()
                , localDateTime.getDayOfMonth()
                , localDateTime.getMonthValue()
        );

        // 일요일의 값이 뭐일까 궁금해서 찍어봄
        LocalDate theDay = LocalDate.of(2018, 2, 21);

        log.debug("일요일 ==> {}", theDay.getDayOfWeek().getValue());

        log.debug("{} to {} ==> 29Ok? {}", theDay.range(ChronoField.DAY_OF_MONTH).getMinimum(), theDay.range(ChronoField.DAY_OF_MONTH).getMaximum());


    }
}

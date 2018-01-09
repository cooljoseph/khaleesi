package kr.sidnancy.khaleesi;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Java8Time 에 대해 모르는 것이 많이 있어서 테스트 케이스로 만들어서 라이브러리에 대한 이해 증진
 * */
public class Java8TimeTests {
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
}

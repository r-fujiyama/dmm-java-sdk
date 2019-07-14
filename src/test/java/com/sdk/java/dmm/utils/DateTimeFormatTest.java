package com.sdk.java.dmm.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class DateTimeFormatTest {

  @Test
  public void 正常系_LocalDateTimeへparse() {
    LocalDateTime actual = DateTimeFormat.uuuuMMddTHHmmss_HYPHEN
        .parse("2019-05-26T21:50:10");
    LocalDateTime expected = LocalDateTime.of(2019, 05, 26, 21, 50, 10, 000000000);
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void 正常系_LocalDateTimeをformat() {
    String actual = DateTimeFormat.uuuuMMddTHHmmss_HYPHEN
        .format(LocalDateTime.of(2019, 05, 26, 21, 50, 10, 000000000));
    assertThat(actual).isEqualTo("2019-05-26T21:50:10");
  }

  @Nested
  public class check {

    @Test
    public void 正常系_TRUE() {
      assertThat(DateTimeFormat.uuuuMMddTHHmmss_HYPHEN.check("2019-05-26T21:50:10")).isTrue();
    }

    @Test
    public void 正常系_フォーマットが不正の場合_FALSE() {
      assertThat(DateTimeFormat.uuuuMMddTHHmmss_HYPHEN.check("2019-05-26")).isFalse();
    }

    @Test
    public void 正常系_存在しない日付の場合_FALSE() {
      assertThat(DateTimeFormat.uuuuMMddTHHmmss_HYPHEN.check("2019-06-31T21:50:10"))
          .isFalse();
    }

    @Test
    public void 正常系_NULLの場合_FALSE() {
      assertThat(DateTimeFormat.uuuuMMddTHHmmss_HYPHEN.check(null)).isFalse();
    }

  }

}

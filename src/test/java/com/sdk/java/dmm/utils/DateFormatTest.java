package com.sdk.java.dmm.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class DateFormatTest {

  @Test
  public void 正常系_parse() {
    LocalDate actual = DateFormat.uuuuMMdd_HYPHEN.parse("2019-05-26");
    LocalDate expected = LocalDate.of(2019, 05, 26);
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void 正常系_format() {
    String actual = DateFormat.uuuuMMdd_HYPHEN.format(LocalDate.of(2019, 05, 26));
    assertThat(actual).isEqualTo("2019-05-26");
  }

  @Nested
  public class check {

    @Test
    public void 正常系_TRUE() {
      assertThat(DateFormat.uuuuMMdd_HYPHEN.check("2019-05-26")).isTrue();
    }

    @Test
    public void 正常系_フォーマットが不正の場合_FALSE() {
      assertThat(DateFormat.uuuuMMdd_HYPHEN.check("2019-05-26 21:50:10.510")).isFalse();
    }

    @Test
    public void 正常系_存在しない日付の場合_FALSE() {
      assertThat(DateFormat.uuuuMMdd_HYPHEN.check("2019-06-31")).isFalse();
    }

    @Test
    public void 正常系_NULLの場合_FALSE() {
      assertThat(DateFormat.uuuuMMdd_HYPHEN.check(null)).isFalse();
    }

  }

}

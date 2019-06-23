package com.sdk.java.dmm.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

public class DateFormatTest {

  @Test
  public void 正常系_getValue() {
    DateFormat.uuuuMMdd_HYPHEN.getValue();
  }

  @Test
  public void 正常系_localDateへparse() {
    LocalDate actual = DateFormat.uuuuMMdd_HYPHEN
        .parse("2019-05-26");
    LocalDate expected = LocalDate.of(2019, 05, 26);
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void 正常系_DateTimeをformat() {
    String actual = DateFormat.uuuuMMdd_HYPHEN
        .format(LocalDate.of(2019, 05, 26));
    assertThat(actual).isEqualTo("2019-05-26");
  }

  @Test
  public void 正常系_フォマットチェック_TRUE() {
    assertThat(DateFormat.uuuuMMdd_HYPHEN.isFormatCheck("2019-05-26"))
        .isTrue();
  }

  @Test
  public void 正常系_フォマットチェック_FALSE() {
    assertThat(DateFormat.uuuuMMdd_HYPHEN.isFormatCheck("2019-05-26 21:50:10.510"))
        .isFalse();
  }

  @Test
  public void 正常系_フォマットチェック_NULLの場合_FALSE() {
    assertThat(DateFormat.uuuuMMdd_HYPHEN.isFormatCheck(null))
        .isFalse();
  }

}

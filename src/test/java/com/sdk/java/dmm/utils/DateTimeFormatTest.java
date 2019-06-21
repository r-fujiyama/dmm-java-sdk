package com.sdk.java.dmm.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

public class DateTimeFormatTest {

  @Test
  public void 正常系_getValue() {
    DateTimeFormat.uuuuMMdd_HHmmssSSS_HYPHEN.getValue();
  }

  @Test
  public void 正常系_LocalDateTimeへparse() {
    LocalDateTime actual = DateTimeFormat.uuuuMMdd_HHmmssSSS_HYPHEN
        .parse("2019-05-26 21:50:10.510");
    LocalDateTime expected = LocalDateTime.of(2019, 05, 26, 21, 50, 10, 510000000);
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void 正常系_LocalDateTimeをformat() {
    String actual = DateTimeFormat.uuuuMMdd_HHmmssSSS_HYPHEN
        .format(LocalDateTime.of(2019, 05, 26, 21, 50, 10, 510000000));
    assertThat(actual).isEqualTo("2019-05-26 21:50:10.510");
  }

  @Test
  public void 正常系_フォマットチェック_TRUE() {
    assertThat(DateTimeFormat.uuuuMMdd_HHmmssSSS_HYPHEN.isFormatCheck("2019-05-26 21:50:10.510"))
        .isTrue();
  }

  @Test
  public void 正常系_フォマットチェック_FALSE() {
    assertThat(DateTimeFormat.uuuuMMdd_HHmmssSSS_HYPHEN.isFormatCheck("2019-05-26"))
        .isFalse();
  }

  @Test
  public void 正常系_フォマットチェック_NULLの場合_FALSE() {
    assertThat(DateTimeFormat.uuuuMMdd_HHmmssSSS_HYPHEN.isFormatCheck(null))
        .isFalse();
  }

}

package com.sdk.java.dmm.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * LocalDateTimeをparse、formatするためのクラスです。
 */
@Getter
@AllArgsConstructor
public enum DateTimeFormat {

  /** uuuu-MM-dd HH:mm:ss.SSS" */
  uuuuMMdd_HHmmssSSS_HYPHEN("uuuu-MM-dd HH:mm:ss.SSS");

  private String value;

  /**
   * 文字列をLocalDateTimeへparseします
   *
   * @param str 文字列
   * @return LocalDateTime
   */
  public LocalDateTime parse(String str) {
    return LocalDateTime.parse(str, DateTimeFormatter.ofPattern(this.value));
  }

  /**
   * LocalDateTimeを指定された形式にフォーマットします。
   *
   * @param ldt LocalDateTime
   * @return 指定されたフォーマットの文字列
   */
  public String format(LocalDateTime ldt) {
    return ldt.format(DateTimeFormatter.ofPattern(this.value));
  }

  /**
   * 文字列が指定された形式かを判定します。
   *
   * @param str 文字列
   * @return 指定された形式であれば{@code true}を返却します。
   */
  public boolean isFormatCheck(String str) {
    if (StringUtil.isNullOrEmpty(str)) {
      return false;
    }
    try {
      DateTimeFormatter.ofPattern(this.value).parse(str);
    } catch (DateTimeParseException e) {
      return false;
    }
    return true;
  }

}

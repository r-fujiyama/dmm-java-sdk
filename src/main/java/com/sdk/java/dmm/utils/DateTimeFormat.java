package com.sdk.java.dmm.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * LocalDateTimeをparse、formatするためのクラスです。
 */
@Getter
@AllArgsConstructor
public enum DateTimeFormat {

  /** uuuu-MM-dd HH:mm:ss.SSS */
  uuuuMMdd_HHmmssSSS_HYPHEN(DateTimeFormatConstants.uuuuMMdd_HHmmssSSS_HYPHEN);

  private final DateTimeFormatter dateTimeFormatter;

  /**
   * DateTimeFormatterを初期化する。
   *
   * @param value フォーマット
   */
  DateTimeFormat(String value) {
    this.dateTimeFormatter = DateTimeFormatter.ofPattern(value)
        .withResolverStyle(ResolverStyle.STRICT);
  }

  /**
   * 文字列をLocalDateTimeへparseします
   *
   * @param str 文字列
   * @return LocalDateTime
   */
  public LocalDateTime parse(String str) {
    return LocalDateTime.parse(str, dateTimeFormatter);
  }

  /**
   * LocalDateTimeを指定された形式にフォーマットします。
   *
   * @param ldt LocalDateTime
   * @return 指定されたフォーマットの文字列
   */
  public String format(LocalDateTime ldt) {
    return dateTimeFormatter.format(ldt);
  }

  /**
   * 文字列が指定された形式かを判定します。
   *
   * @param str 文字列
   * @return 指定された形式であれば{@code true}を返却します。
   */
  public boolean check(String str) {
    if (StringUtil.isBlank(str)) {
      return false;
    }
    try {
      dateTimeFormatter.parse(str);
    } catch (DateTimeParseException e) {
      return false;
    }
    return true;
  }

}

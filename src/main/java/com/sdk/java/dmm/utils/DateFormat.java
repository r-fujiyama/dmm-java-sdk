package com.sdk.java.dmm.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * LocalDateをparse、formatするためのクラスです。
 */
@Getter
@AllArgsConstructor
public enum DateFormat {

  /** uuuu-MM-dd */
  uuuuMMdd_HYPHEN(DateTimeFormatConstants.uuuuMMdd_HYPHEN);

  private final DateTimeFormatter dateTimeFormatter;

  /**
   * DateTimeFormatterを初期化する。
   *
   * @param value フォーマット
   */
  DateFormat(String value) {
    this.dateTimeFormatter = DateTimeFormatter.ofPattern(value)
        .withResolverStyle(ResolverStyle.STRICT);
  }

  /**
   * 文字列をLocalDateへparseします
   *
   * @param str 文字列
   * @return LocalDate
   */
  public LocalDate parse(String str) {
    return LocalDate.parse(str, dateTimeFormatter);
  }

  /**
   * LocalDateを指定された形式にフォーマットします。
   *
   * @param ld LocalDate
   * @return 指定されたフォーマットの文字列
   */
  public String format(LocalDate ld) {
    return dateTimeFormatter.format(ld);
  }

  /**
   * 文字列が指定されたフォーマットかを判定します。
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

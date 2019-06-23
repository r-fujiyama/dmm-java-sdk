package com.sdk.java.dmm.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * LocalDateをparse、formatするためのクラスです。
 */
@Getter
@AllArgsConstructor
public enum DateFormat {

  /** uuuu-MM-dd */
  uuuuMMdd_HYPHEN("uuuu-MM-dd");

  private String value;

  public static final String CONST_uuuuMMdd_HYPHEN = "uuuu-MM-dd";

  /**
   * 文字列をLocalDateへparseします
   *
   * @param str 文字列
   * @return LocalDate
   */
  public LocalDate parse(String str) {
    return LocalDate.parse(str, DateTimeFormatter.ofPattern(this.value));
  }

  /**
   * LocalDateを指定された形式にフォーマットします。
   *
   * @param ld LocalDate
   * @return 指定されたフォーマットの文字列
   */
  public String format(LocalDate ld) {
    return ld.format(DateTimeFormatter.ofPattern(this.value));
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

package com.sdk.java.dmm.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 商品検索APIにて使用する絞りこみ項目列挙型
 */
@AllArgsConstructor
@Getter
public enum Article implements CodeEnum<String> {

  /** 女優 */
  ACTRESS("actress", "女優"),
  /** 作者 */
  AUTHOR("author", "作者"),
  /** ジャンル */
  GENRE("genre", "ジャンル"),
  /** シリーズ */
  SERIES("series", "シリーズ"),
  /** メーカー */
  MAKER("maker", "メーカー");

  /** 値 */
  private String value;
  /** ラベル */
  private String label;

  /**
   * 指定された値を持つ列挙型を返却します。
   *
   * @param value 列挙型の値
   * @return 指定された値を持つ列挙型
   */
  @JsonCreator
  public static Article of(String value) throws IllegalArgumentException {
    return CodeEnum.of(Article.class, value);
  }

}

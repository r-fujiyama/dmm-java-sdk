package com.sdk.java.dmm.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 商品検索APIにて使用する検索結果ソート列挙型
 */
@AllArgsConstructor
@Getter
public enum ItemSearchSort implements CodeEnum<String> {

  /** 人気 */
  RANK("rank", "人気"),
  /** 価格が安い順 */
  PRICE_ASC("-price", "価格が安い順"),
  /** 価格が高い順 */
  PRICE_DESC("price", "価格が高い順"),
  /** 新着 */
  DATE("date", "新着"),
  /** 評価 */
  REVIEW("review", "評価");

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
  public static ItemSearchSort of(String value) {
    return CodeEnum.of(ItemSearchSort.class, value);
  }

}

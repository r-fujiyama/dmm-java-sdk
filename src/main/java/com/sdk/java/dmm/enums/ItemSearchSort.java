package com.sdk.java.dmm.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 商品検索APIにて使用する検索結果ソートEnum。
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

  /** ソート順 */
  private String value;
  /** 名前 */
  private String name;

  /**
   * 指定されたvalue持つEnumを返します。
   *
   * @param value Enumのvalue
   * @return 指定されたvalueを持つEnum
   */
  @JsonCreator
  public static ItemSearchSort of(String value) {
    return CodeEnum.of(ItemSearchSort.class, value);
  }

}

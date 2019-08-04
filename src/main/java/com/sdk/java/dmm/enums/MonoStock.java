package com.sdk.java.dmm.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 商品検索APIにて使用する在庫絞り込みEnum。
 */
@AllArgsConstructor
@Getter
public enum MonoStock implements CodeEnum<String> {

  /** 在庫あり */
  STOCK("stock", "在庫あり"),
  /** 予約受付中 */
  RESERVE("reserve", "予約受付中"),
  /** DMM通販のみ */
  MONO("mono", "DMM通販のみ"),
  /** マーケットプレイスのみ */
  DMP("dmp", "マーケットプレイスのみ");

  /** 在庫絞り込み */
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
  public static MonoStock of(String value) throws IllegalArgumentException {
    return CodeEnum.of(MonoStock.class, value);
  }

}

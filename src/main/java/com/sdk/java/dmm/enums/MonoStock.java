package com.sdk.java.dmm.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 商品検索APIにて使用する在庫絞り込み列挙型
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
  public static MonoStock of(String value) throws IllegalArgumentException {
    return CodeEnum.of(MonoStock.class, value);
  }

}

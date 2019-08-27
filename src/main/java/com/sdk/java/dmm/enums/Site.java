package com.sdk.java.dmm.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 商品検索APIにて使用するサイト列挙型
 */
@AllArgsConstructor
@Getter
public enum Site implements CodeEnum<String> {

  /** DMM.com */
  DMM("DMM.com", "DMM.com"),
  /** FANZA */
  FANZA("FANZA", "FANZA");

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
  public static Site of(String value) throws IllegalArgumentException {
    return CodeEnum.of(Site.class, value);
  }

}

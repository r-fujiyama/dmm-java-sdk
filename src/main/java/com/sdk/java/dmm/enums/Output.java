package com.sdk.java.dmm.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 出力形式列挙型
 */
@AllArgsConstructor
@Getter
public enum Output implements CodeEnum<String> {

  /** JSON */
  JSON("json", "JSON"),
  /** XML */
  XML("xml", "XML");

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
  public static Output of(String value) {
    return CodeEnum.of(Output.class, value);
  }

}

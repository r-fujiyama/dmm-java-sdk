package com.sdk.java.dmm.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 出力形式Enum。
 */
@AllArgsConstructor
@Getter
public enum Output implements CodeEnum<String> {

  /** JSON */
  JSON("json", "JSON"),
  /** XML */
  XML("xml", "XML");

  /** 出力形式 */
  private String value;
  /** ラベル */
  private String label;

  /**
   * 指定されたvalue持つEnumを返します。
   *
   * @param value Enumのvalue
   * @return 指定されたvalueを持つEnum
   */
  @JsonCreator
  public static Output of(String value) {
    return CodeEnum.of(Output.class, value);
  }

}

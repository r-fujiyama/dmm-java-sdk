package com.sdk.java.dmm.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 女優検索APIにて使用する出力形式enum
 */
@AllArgsConstructor
@Getter
public enum Output implements CodeEnum<String> {

  /** JSON */
  JSON("json"),
  /** XML */
  XML("xml");

  /** アウトプット形式 */
  private String value;

  /**
   * 指定されたvalue持つEnumを返します。
   *
   * @param value Enumのvalue
   * @return 指定されたvalueを持つEnum
   */
  @JsonCreator
  public static Output of(String value) throws IllegalArgumentException {
    return CodeEnum.of(Output.class, value);
  }

}

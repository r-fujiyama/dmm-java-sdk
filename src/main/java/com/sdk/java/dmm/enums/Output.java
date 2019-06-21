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

  private String value;

  /**
   * 指定されたvalue持つenum定数を返します。
   *
   * @param value enum定数のvalue
   * @return 指定されたvalueをenum定数
   * @throws IllegalArgumentException この列挙型に、指定したvalueの定数がない場合
   */
  @JsonCreator
  public static Output of(String value) throws IllegalArgumentException {
    return CodeEnum.of(Output.class, value);
  }

}

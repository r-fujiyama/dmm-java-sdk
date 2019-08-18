package com.sdk.java.dmm.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * フラグEnum。
 */
@AllArgsConstructor
@Getter
public enum Flag implements CodeEnum<Integer> {

  /** ON */
  ITEM_SEARCH(1, "ON"),
  /** OFF */
  ACTRESS_SEARCH(0, "OFF");

  /** フラグ */
  private Integer value;
  /** ラベル */
  private String label;

  /**
   * 指定されたvalue持つEnumを返します。
   *
   * @param value Enumのvalue
   * @return 指定されたvalueを持つEnum
   */
  @JsonCreator
  public static Flag of(int value) {
    return CodeEnum.of(Flag.class, value);
  }

}

package com.sdk.java.dmm.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * フラグ列挙型
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
   * 指定された値を持つ列挙型を返却します。
   *
   * @param value 列挙型の値
   * @return 指定された値を持つ列挙型
   */
  @JsonCreator
  public static Flag of(int value) {
    return CodeEnum.of(Flag.class, value);
  }

}

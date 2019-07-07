package com.sdk.java.dmm.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 女優検索APIにて使用するソート用enum
 */
@AllArgsConstructor
@Getter
public enum ActressSearchSort implements CodeEnum<String> {

  /** 名前(昇順) */
  NAME_ASC("name"),
  /** 名前(降順) */
  NAME_DESC("-name"),
  /** バスト(昇順) */
  BUST_ASC("bust"),
  /** バスト(降順) */
  BUST_DESC("-bust"),
  /** ウエスト(昇順) */
  WAIST_ASC("waist"),
  /** ウエスト(降順) */
  WAIST_DESC("-waist"),
  /** ヒップ(昇順) */
  HIP_ASC("hip"),
  /** ヒップ(降順) */
  HIP_DESC("-hip"),
  /** 身長(昇順) */
  HEIGHT_ASC("height"),
  /** 身長(降順) */
  HEIGHT_DESC("-height"),
  /** 生年月日(昇順) */
  BIRTHDAY_ASC("birthday"),
  /** 生年月日(降順) */
  BIRTHDAY_DESC("-birthday"),
  /** 女優ID(昇順) */
  ID_ASC("id"),
  /** 女優ID(降順) */
  ID_DESC("-id");

  /** ソート順 */
  private String value;

  /**
   * 指定されたvalue持つEnumを返します。
   *
   * @param value Enumのvalue
   * @return 指定されたvalueを持つEnum
   */
  @JsonCreator
  public static ActressSearchSort of(String value) throws IllegalArgumentException {
    return CodeEnum.of(ActressSearchSort.class, value);
  }

}

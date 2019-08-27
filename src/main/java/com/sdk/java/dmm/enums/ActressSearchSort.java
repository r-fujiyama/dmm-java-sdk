package com.sdk.java.dmm.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 女優検索APIにて使用する検索結果ソート列挙型
 */
@AllArgsConstructor
@Getter
public enum ActressSearchSort implements CodeEnum<String> {

  /** 名前(昇順) */
  NAME_ASC("name", "名前(昇順)"),
  /** 名前(降順) */
  NAME_DESC("-name", "名前(降順)"),
  /** バスト(昇順) */
  BUST_ASC("bust", "バスト(昇順)"),
  /** バスト(降順) */
  BUST_DESC("-bust", "バスト(降順)"),
  /** ウエスト(昇順) */
  WAIST_ASC("waist", "ウエスト(昇順)"),
  /** ウエスト(降順) */
  WAIST_DESC("-waist", "ウエスト(降順)"),
  /** ヒップ(昇順) */
  HIP_ASC("hip", "ヒップ(昇順)"),
  /** ヒップ(降順) */
  HIP_DESC("-hip", "ヒップ(降順)"),
  /** 身長(昇順) */
  HEIGHT_ASC("height", "身長(昇順)"),
  /** 身長(降順) */
  HEIGHT_DESC("-height", "身長(降順)"),
  /** 生年月日(昇順) */
  BIRTHDAY_ASC("birthday", "生年月日(昇順)"),
  /** 生年月日(降順) */
  BIRTHDAY_DESC("-birthday", "生年月日(降順)"),
  /** 女優ID(昇順) */
  ID_ASC("id", "女優ID(昇順)"),
  /** 女優ID(降順) */
  ID_DESC("-id", "女優ID(降順)");

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
  public static ActressSearchSort of(String value) {
    return CodeEnum.of(ActressSearchSort.class, value);
  }

}

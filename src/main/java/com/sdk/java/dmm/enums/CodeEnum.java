package com.sdk.java.dmm.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;

/**
 * 全ての列挙型が実装しなければならない列挙型インタフェース
 *
 * @param <T> {@code getValue}が返却する型
 */
public interface CodeEnum<T> {

  /**
   * 指定された列挙型に指定された値が存在する場合、列挙型を返却します。<br>
   * そうでない場合、{@code IllegalArgumentException}をスローします。
   *
   * @param <T>      {@code getValue}が返却する型
   * @param <E>      CodeEnumを実装したした列挙型
   * @param enumType CodeEnumを実装したした列挙型
   * @param value    列挙型の値
   * @return 列挙型
   */
  static <T, E extends Enum<?> & CodeEnum<T>> E of(Class<E> enumType, T value) {
    return Arrays.stream(enumType.getEnumConstants())
        .filter(e -> e.getValue().equals(value))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException(enumType.getName() + ":" + value));
  }

  /**
   * 値を取得する。
   *
   * @return 値
   */
  @JsonValue
  T getValue();

  /**
   * ラベルを取得する。
   *
   * @return ラベル
   */
  String getLabel();

}

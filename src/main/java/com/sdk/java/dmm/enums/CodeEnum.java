package com.sdk.java.dmm.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;

/**
 * API実行結果とバインドされるenumのインタフェース
 *
 * @param <T> getValueが返却する型
 */
public interface CodeEnum<T> {

  /**
   * 指定されたEnumに指定されたvalueが存在する場合は、Enumを返却します。<br>
   * そうでない場合は、{@code IllegalArgumentException}をスローします。
   *
   * @param <T> {@code CodeEnum}の仮型パラメータ
   * @param <E> CodeEnumをimplementsしたEnum
   * @param enumType CodeEnumをimplementsしたEnum
   * @param value T型の値
   * @return Enum
   */
  static <T, E extends Enum<?> & CodeEnum<T>> E of(Class<E> enumType, T value) {
    return Arrays.stream(enumType.getEnumConstants())
        .filter(e -> e.getValue().equals(value))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException(enumType.getName() + ":" + value));
  }

  /**
   * valueを取得する。
   *
   * @return value
   */
  @JsonValue
  T getValue();

}

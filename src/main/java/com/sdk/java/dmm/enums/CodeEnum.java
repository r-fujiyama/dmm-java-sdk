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
   * 指定された名前を持つ指定されたenum型のenum定数を返します。
   *
   * @param <T> getValueの返却する型
   * @param <E> CodeEnumをimplementsしたenum
   * @param enumType 定数が返されるenum型のClassオブジェクト
   * @param value 返される定数のvalue
   * @return 指定されたvalueを持つ指定されたenum定数
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

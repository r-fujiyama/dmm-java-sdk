package com.sdk.java.dmm.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.UncheckedIOException;

/**
 * JSONを操作するためのクラスです。
 */
public final class JsonUtil {

  /** オブジェクトマッパー */
  private static final ObjectMapper MAPPER = new ObjectMapper();

  /**
   * コンストラクタ
   */
  private JsonUtil() {
    throw new AssertionError("com.sdk.java.dmm.utils.JsonUtil instances for you!");
  }

  /**
   * JSON文字列を指定されたクラスにマッピングします。
   *
   * @param json  JSON文字列
   * @param clazz マッピングクラス
   * @param <T>   マッピングクラス型
   * @return マッピングオブジェクト
   */
  public static <T> T read(String json, Class<T> clazz) {
    try {
      return MAPPER.readValue(json, clazz);
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    }
  }

  /**
   * オブジェクトをJSON文字列に変換します。
   *
   * @param obj オブジェクト
   * @return JSON文字列
   */
  public static String write(Object obj) {
    try {
      return MAPPER.writeValueAsString(obj);
    } catch (JsonProcessingException e) {
      throw new UncheckedIOException(e);
    }
  }

}

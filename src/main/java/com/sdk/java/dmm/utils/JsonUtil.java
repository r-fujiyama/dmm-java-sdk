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
   * JSONを指定されたClassにマッピングします。
   *
   * @param json JSON
   * @param clazz Classオブジェクト
   * @param <T> JSONとマッピングされるオブジェクトのClassの型
   * @return JSONがマッピングされたオブジェクト
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

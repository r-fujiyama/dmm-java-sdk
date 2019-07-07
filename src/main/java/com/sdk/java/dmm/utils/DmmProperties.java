package com.sdk.java.dmm.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * dmm.propertiesの値を取得するクラスです。
 */
public final class DmmProperties {

  /** Properties */
  private final static Properties PROPERTIES;
  /** プロパティ名 */
  private final static String PROPERTIES_NAME = "dmm.properties";

  static {
    try (InputStream is = DmmProperties.class.getClassLoader()
        .getResourceAsStream(PROPERTIES_NAME);
        BufferedReader br = new BufferedReader(
            new InputStreamReader(is, StandardCharsets.UTF_8))) {
      PROPERTIES = new Properties();
      PROPERTIES.load(br);
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    }
  }

  /**
   * コンストラクタ
   */
  private DmmProperties() {
    throw new AssertionError("com.sdk.java.dmm.utils.DmmProperties instances for you!");
  }

  /**
   * dmm.propertiesの値を取得する。
   *
   * @param key キー
   * @return キーに紐付くプロパティの値
   */
  public static String getValue(String key) {
    return PROPERTIES.getProperty(key);
  }

}

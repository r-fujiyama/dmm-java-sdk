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
public class DmmProperties {

  private final static Properties PROPERTIES;
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
   * dmm.propertiesの値を取得する。
   *
   * @param key キー
   * @return キーに紐付くプロパティの値
   */
  public static String getValue(String key) {
    return PROPERTIES.getProperty(key);
  }

}

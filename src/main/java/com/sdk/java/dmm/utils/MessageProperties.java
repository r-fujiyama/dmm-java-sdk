package com.sdk.java.dmm.utils;

import com.sdk.java.dmm.enums.Message;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * message.propertiesの値を取得するクラスです。
 */
public final class MessageProperties {

  /** Properties */
  private final static Properties PROPERTIES;
  /** プロパティ名 */
  private final static String PROPERTIES_NAME = "message.properties";

  static {
    try (InputStream is = MessageProperties.class.getClassLoader()
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
  private MessageProperties() {
    throw new AssertionError("com.sdk.java.dmm.utils.MessageProperties instances for you!");
  }

  /**
   * message.propertiesの値を取得する。
   *
   * @param key キー
   * @return メッセージ
   */
  public static String getMsg(Message key) {
    return PROPERTIES.getProperty(key.getValue());
  }

  /**
   * message.propertiesの値に引数がバインドされた値を取得する。
   *
   * @param key キー
   * @param bindStrArray エラーメッセージにバインドされる文字列
   * @return メッセージ
   */
  public static String getMsg(Message key, String... bindStrArray) {
    String msg = PROPERTIES.getProperty(key.getValue());
    for (String bindStr : bindStrArray) {
      msg = msg.replaceFirst("\\{\\}", bindStr);
    }
    return msg;
  }


}

package com.sdk.java.dmm.exception;

import com.sdk.java.dmm.enums.Message;
import com.sdk.java.dmm.utils.MessageResolver;

/**
 * DMM_APIに関する例外の汎用クラスです。
 */
public class DmmException extends RuntimeException {

  /**
   * エラー詳細メッセージとして{@code null}を設定して{@code DmmException}を構築します。
   */
  public DmmException() {
  }


  /**
   * 指定された詳細メッセージを持つ{@code DmmException}を構築します。
   *
   * @param message メッセージ
   * @param param   パラメータ
   */
  public DmmException(Message message, String... param) {
    super(MessageResolver.getMessage(message, param));
  }

  /**
   * 指定された詳細メッセージと原因を持つ{@code DmmException}を構築します。
   *
   * @param cause   原因
   * @param message メッセージ
   * @param param   パラメータ
   */
  public DmmException(Throwable cause, Message message, String... param) {
    super(MessageResolver.getMessage(message, param), cause);
  }

  /**
   * 指定された原因を持つ{@code DmmException}を構築します。
   *
   * @param cause 原因
   */
  public DmmException(Throwable cause) {
    super(cause);
  }

}

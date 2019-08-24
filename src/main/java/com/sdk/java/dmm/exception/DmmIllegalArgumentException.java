package com.sdk.java.dmm.exception;

import com.sdk.java.dmm.enums.Message;

/**
 * 不正な引数、または不適切な引数をメソッドに渡したことを示すためにスローされます。
 */
public class DmmIllegalArgumentException extends DmmException {

  /**
   * エラー詳細メッセージとして{@code null}を設定して{@code DmmIllegalArgumentException}を構築します。
   */
  public DmmIllegalArgumentException() {
  }

  /**
   * 指定された詳細メッセージを持つ{@code DmmIllegalArgumentException}を構築します。
   *
   * @param message メッセージ
   * @param param   パラメータ
   */
  public DmmIllegalArgumentException(Message message, String... param) {
    super(message, param);
  }

  /**
   * 指定された詳細メッセージと原因を持つ{@code DmmIllegalArgumentException}を構築します。
   *
   * @param cause   原因
   * @param message メッセージ
   * @param param   パラメータ
   */
  public DmmIllegalArgumentException(Throwable cause, Message message, String... param) {
    super(cause, message, param);
  }

  /**
   * 指定された原因を持つ{@code DmmIllegalArgumentException}を構築します。
   *
   * @param cause 原因
   */
  public DmmIllegalArgumentException(Throwable cause) {
    super(cause);
  }

}

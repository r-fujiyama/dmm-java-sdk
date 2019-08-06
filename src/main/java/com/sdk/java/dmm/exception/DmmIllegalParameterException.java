package com.sdk.java.dmm.exception;

import com.sdk.java.dmm.enums.Message;

/**
 * DMM_API実行時に不正なパラメータが設定されていた場合にスローされます。
 */
public class DmmIllegalParameterException extends DmmException {

  /**
   * エラー詳細メッセージとして{@code null}を設定して{@code DmmIllegalParameterException}を構築します。
   */
  public DmmIllegalParameterException() {
  }

  /**
   * 指定された詳細メッセージを持つ{@code DmmIllegalParameterException}を構築します。
   *
   * @param message メッセージ
   * @param param 　パラメータ
   */
  public DmmIllegalParameterException(Message message, String... param) {
    super(message, param);
  }

  /**
   * 指定された詳細メッセージと原因を持つ{@code DmmIllegalParameterException}を構築します。
   *
   * @param cause 原因
   * @param message メッセージ
   * @param param 　パラメータ
   */
  public DmmIllegalParameterException(Throwable cause, Message message, String... param) {
    super(cause, message, param);
  }

  /**
   * 指定された原因を持つ{@code DmmIllegalParameterException}を構築します。
   *
   * @param cause 原因
   */
  public DmmIllegalParameterException(Throwable cause) {
    super(cause);
  }

}

package com.sdk.java.dmm.exception;

import com.sdk.java.dmm.enums.Message;

public class DmmIllegalParameterException extends DmmException {

  public DmmIllegalParameterException() {
  }

  public DmmIllegalParameterException(Message message, String... param) {
    super(message, param);
  }

  public DmmIllegalParameterException(Throwable e, Message message, String... param) {
    super(e, message, param);
  }

  public DmmIllegalParameterException(Throwable e) {
    super(e);
  }

}

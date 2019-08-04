package com.sdk.java.dmm.exception;

import com.sdk.java.dmm.enums.Message;

public class DmmIllegalArgumentException extends DmmException {

  public DmmIllegalArgumentException() {
  }

  public DmmIllegalArgumentException(Message message, String... param) {
    super(message, param);
  }

  public DmmIllegalArgumentException(Throwable e, Message message, String... param) {
    super(e, message, param);
  }

  public DmmIllegalArgumentException(Throwable e) {
    super(e);
  }

}

package com.sdk.java.dmm.exception;

import com.sdk.java.dmm.enums.Message;
import com.sdk.java.dmm.utils.MessageResolver;

public class DmmException extends RuntimeException {

  public DmmException() {
  }

  public DmmException(Message message, String... param) {
    super(MessageResolver.getMsg(message, param));
  }

  public DmmException(Throwable e, Message message, String... param) {
    super(MessageResolver.getMsg(message, param), e);
  }

  public DmmException(Throwable e) {
    super(e);
  }

}

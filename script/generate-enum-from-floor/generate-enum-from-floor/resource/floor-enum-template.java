print(package com.sdk.java.dmm.enums;

print(import com.fasterxml.jackson.annotation.JsonCreator;
print(import lombok.AllArgsConstructor;
print(import lombok.Getter;

print(/**
print( * フロアID指定時に使用する列挙型
print( */
print(@AllArgsConstructor
print(@Getter
print(public enum Floor implements CodeEnum<String> {



print(  /**
print(   * 指定された値を持つ列挙型を返却します。
print(   *
print(   * @param value 列挙型の値
print(   * @return 指定された値を持つ列挙型
print(   */
print(  @JsonCreator
print(  public static ActressSearchSort of(String value) {
print(    return CodeEnum.of(ActressSearchSort.class, value);
print(  }
print(
print(}
print(
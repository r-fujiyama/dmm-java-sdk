package com.sdk.java.dmm.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class StringUtilTest {

  @Test
  public void 正常系_isNullOrEmpty_NULLの場合はTRUE() {
    assertThat(StringUtil.isNullOrEmpty(null)).isTrue();
  }

  @Test
  public void 正常系_isNullOrEmpty_空文字の場合はTRUE() {
    assertThat(StringUtil.isNullOrEmpty("")).isTrue();
  }

  @Test
  public void 正常系_isNullOrEmpty_半角スペースの場合はFALSE() {
    assertThat(StringUtil.isNullOrEmpty(" ")).isFalse();
  }

  @Test
  public void 正常系_isNullOrEmpty_NULLまたは空文字でない場合はFALSE() {
    assertThat(StringUtil.isNullOrEmpty("test")).isFalse();
  }

  @Test
  public void 正常系_isAnyNullOrEmpty_NULLの場合はTRUE() {
    String[] strArray = null;
    assertThat(StringUtil.isAnyNullOrEmpty(strArray)).isTrue();
  }

  @Test
  public void 正常系_isAnyNullOrEmpty_配列が0の場合() {
    assertThat(StringUtil.isAnyNullOrEmpty(new String[0])).isTrue();
  }

  @Test
  public void 正常系_isAnyNullOrEmpty_NULLが含まれる場合はTRUE() {
    assertThat(StringUtil.isAnyNullOrEmpty("test", null)).isTrue();
  }

  @Test
  public void 正常系_isAnyNullOrEmpty_空文字が含まれる場合はTRUE() {
    assertThat(StringUtil.isAnyNullOrEmpty("test", "")).isTrue();
  }

  @Test
  public void 正常系_isAnyNullOrEmpty_半角スペースが含まれる場合はTRUE() {
    assertThat(StringUtil.isAnyNullOrEmpty("test", " ")).isFalse();
  }

  @Test
  public void 正常系_isAnyNullOrEmpty_NULLまたは空文字でない場合はFALSE() {
    assertThat(StringUtil.isAnyNullOrEmpty("test1", "test2")).isFalse();
  }

  @Test
  public void 正常系_isBlank_NULLの場合はTRUE() {
    assertThat(StringUtil.isBlank(null)).isTrue();
  }

  @Test
  public void 正常系isBlank_空文字の場合はTRUE() {
    assertThat(StringUtil.isBlank("")).isTrue();
  }

  @Test
  public void 正常系isBlank_空白の場合はTRUE() {
    assertThat(StringUtil.isBlank(" ")).isTrue();
  }

  @Test
  public void 正常系_isBlank_NULLまたは空白でない場合はFALSE() {
    assertThat(StringUtil.isBlank("test")).isFalse();
  }

  @Test
  public void 正常系_isAnyBlank_NULLの場合はTRUE() {
    String[] strArray = null;
    assertThat(StringUtil.isAnyBlank(strArray)).isTrue();
  }

  @Test
  public void 正常系_isAnyBlank_配列が0の場合() {
    assertThat(StringUtil.isAnyBlank(new String[0])).isTrue();
  }

  @Test
  public void 正常系_isAnyBlank_NULLが含まれる場合はTRUE() {
    assertThat(StringUtil.isAnyBlank("test", null)).isTrue();
  }

  @Test
  public void 正常系_isAnyBlank_空白の場合はTRUE() {
    assertThat(StringUtil.isAnyBlank("test", " ")).isTrue();
  }

  @Test
  public void 正常系_isAnyBlank_半角スペースの場合はTRUE() {
    assertThat(StringUtil.isAnyBlank("test", " ")).isTrue();
  }

  @Test
  public void 正常系_isAnyBlank_NULLまたは空白でない場合はFALSE() {
    assertThat(StringUtil.isAnyBlank("test1", "test2")).isFalse();
  }

  @Test
  public void 正常系_isJapaneseSyllabary_50音の場合はTRUE() {
    assertThat(StringUtil.isJapaneseSyllabary("あいうえおかきくけこさしすせそたちつてとなにぬねのはひふへほまみむめもやゆよらりるれろわをん"))
        .isTrue();
  }

  @Test
  public void 正常系_isJapaneseSyllabary_NULLの場合はFALSE() {
    assertThat(StringUtil.isJapaneseSyllabary(null)).isFalse();
  }

  @Test
  public void 正常系_isJapaneseSyllabary_空文字の場合はFALSE() {
    assertThat(StringUtil.isJapaneseSyllabary("")).isFalse();
  }

  @Test
  public void 正常系_isJapaneseSyllabary_半角スペースの場合はFALSE() {
    assertThat(StringUtil.isJapaneseSyllabary(" ")).isFalse();
  }

  @Test
  public void 正常系_isJapaneseSyllabary_50音以外の場合はTRUE() {
    assertThat(StringUtil.isJapaneseSyllabary("aiueo")).isFalse();
  }

  @Test
  public void 正常系_addParam_パラメータが付与されること() {
    assertThat(StringUtil.addParam("", "paramName", "paramVal")).isEqualTo("&paramName=paramVal");
  }

  @Test
  public void 正常系_addParam_パラメータが付与されないこと_paramNameがBlankの場合() {
    assertThat(StringUtil.addParam("NONE", " ", "paramVal")).isEqualTo("NONE");
  }

  @Test
  public void 正常系_addParam_パラメータが付与されないこと_paramValがBlankの場合() {
    assertThat(StringUtil.addParam("NONE", "paramName", " ")).isEqualTo("NONE");
  }

}

package com.sdk.java.dmm.utils;

/**
 * 文字列操作のためのクラスです。
 */
public final class StringUtil {

  /** 五十音 */
  public static final String JAPANESE_SYLLABARY_MATCHES = "^[\\u3042\\u3044\\u3046\\u3048\\u304A"
      + "\\u304B\\u304D\\u304F\\u3051\\u3053\\u3055\\u3057\\u3059\\u305B\\u305D\\u305F\\u3061"
      + "\\u3064\\u3066\\u3068\\u306A\\u306B\\u306C\\u306D\\u306E\\u306F\\u3072\\u3075\\u3078"
      + "\\u307B\\u307E\\u307F\\u3080\\u3081\\u3082\\u3084\\u3086\\u3088\\u3089\\u308A\\u308B"
      + "\\u308C\\u308D\\u308F\\u3092\\u3093]+$";

  /**
   * 文字列が{@code null}または空文字であった場合、{@code true}を返却します。<br>
   * それ以外の場合、{@code false}を返却します。
   *
   * @param str 文字列
   * @return boolean
   */
  public static boolean isNullOrEmpty(String str) {
    return str == null || str.isEmpty();
  }

  /**
   * {@code null}または空文字の文字列が含まれる場合、{@code true}を返却します。<br>
   * それ以外の場合、{@code false}を返却します。
   *
   * @param strArray 文字列
   * @return boolean
   */
  public static boolean isAnyNullOrEmpty(String... strArray) {
    if (strArray == null || strArray.length == 0) {
      return true;
    }
    for (String str : strArray) {
      if (isNullOrEmpty(str)) {
        return true;
      }
    }
    return false;
  }

  /**
   * 文字列が空白であった場合、{@code true}を返却します。<br>
   * それ以外の場合、{@code false}を返却します。
   *
   * @param str 文字列
   * @return boolean
   */
  public static boolean isBlank(String str) {
    return (str == null || str.strip().isEmpty());
  }

  /**
   * 空白の文字列が含まれる場合、{@code true}を返却します。<br>
   * それ以外の場合、{@code false}を返却します。
   *
   * @param strArray 文字列
   * @return boolean
   */
  public static boolean isAnyBlank(String... strArray) {
    if (strArray == null || strArray.length == 0) {
      return true;
    }
    for (String str : strArray) {
      if (isBlank(str)) {
        return true;
      }
    }
    return false;
  }

  /**
   * 文字列が五十音の場合、{@code true}を返却します。<br>
   * それ以外の場合、{@code false}を返却します。
   * <pre>
   *   isJapaneseSyllabary("あいうえお") = true
   *   isJapaneseSyllabary("not") = false
   *   isJapaneseSyllabary("") = false
   *   isJapaneseSyllabary(" ") = false
   *   isJapaneseSyllabary(null) = false
   * </pre>
   *
   * @param str 文字列
   * @return boolean
   */
  public static boolean isJapaneseSyllabary(String str) {
    if (str == null) {
      return false;
    }
    return str.matches(JAPANESE_SYLLABARY_MATCHES);
  }

  /**
   * パラメータを付与する。
   *
   * @param str パラメータを付与する文字列
   * @param paramName パラメータ名
   * @param paramVal パラメータ値
   * @return パラーメタを付与した文字列
   */
  public static String addParam(String str, String paramName, String paramVal) {
    if (isAnyBlank(paramName, paramVal)) {
      return str;
    }
    return str + "&" + paramName + "=" + paramVal;
  }

}

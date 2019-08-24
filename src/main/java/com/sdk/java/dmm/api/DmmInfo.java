package com.sdk.java.dmm.api;

/**
 * API実行結果のインタフェース
 *
 * @param <request> リクエストの型
 * @param <result>  リザルトの型
 */
public interface DmmInfo<request, result> {

  request getRequest();

  result getResult();

}

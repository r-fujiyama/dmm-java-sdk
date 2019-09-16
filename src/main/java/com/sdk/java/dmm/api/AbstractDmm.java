package com.sdk.java.dmm.api;

import com.sdk.java.dmm.enums.BaseURL;
import com.sdk.java.dmm.utils.JsonUtil;
import com.sdk.java.dmm.utils.StringUtil;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * 全てのDMM_API実行クラスが継承しなければならない抽象クラス。
 *
 * @param <T> APIより返却されるJSONのマッピング対象となるDTO
 */
@Slf4j
@EqualsAndHashCode
@ToString
public abstract class AbstractDmm<T extends DmmInfo> {

  /** API_ID */
  private final String API_ID;
  /** アフェリエイトID */
  private final String AFFILIATE_ID;

  /**
   * 検索オブジェクトを生成します。
   *
   * @param apiId       API_ID
   * @param affiliateId AFFILIATE_ID
   */
  public AbstractDmm(String apiId, String affiliateId) {
    this.API_ID = apiId;
    this.AFFILIATE_ID = affiliateId;
  }

  /**
   * APIを実行しJSON文字列を取得する。<br>
   *
   * @return JSON文字列
   */
  public String getJson() {
    String json = this.fetchJson();
    log.info("End {}_API -> INFO:{}", this.getBaseURL(), json);
    return json;
  }

  /**
   * APIを実行し結果を取得する。
   *
   * @return API実行結果DTO
   */
  public T execute() {
    T result = JsonUtil.read(this.fetchJson(), this.getResultClass());
    log.info("End {}_API -> Result:{}", this.getBaseURL(), result.toString());
    return result;
  }

  /**
   * APIを実行しJSON文字列を取得する。
   *
   * @return JSON文字列
   */
  private String fetchJson() {
    log.info("Start {}_API", this.getBaseURL());
    String url = this.getURL();
    log.info("Execute {}_API -> URL:{}", this.getBaseURL(), url);
    HttpClient client = HttpClient.newBuilder().build();
    HttpRequest request = HttpRequest.newBuilder(URI.create(url)).GET().build();
    try {
      HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
      return response.body();
    } catch (IOException e) {
      throw new UncheckedIOException("APIの実行に失敗しました:" + url, e);
    } catch (InterruptedException e) {
      throw new AssertionError("APIの実行に失敗しました:" + url, e);
    }
  }

  /**
   * APIを実行するためのURLを取得します。
   *
   * @return URL URL文字列
   */
  private String getURL() {
    String url = StringUtil.addParam(this.getBaseURL().getValue(), "api_id", API_ID);
    url = StringUtil.addParam(url, "affiliate_id", AFFILIATE_ID);
    url += this.getParam();
    return url;
  }

  /**
   * パラメータをクリアする。
   */
  public abstract void clear();

  /**
   * APIを実行するためのパラメータを取得する。
   *
   * @return パラメータ
   */
  protected abstract String getParam();

  /**
   * DMM_APIを実行するためのURLを管理する列挙型を返却する。
   *
   * @return BaseURL ベースURL
   */
  protected abstract BaseURL getBaseURL();

  /**
   * JSONとマッピングされるDTOのクラスオブジェクトを取得する。
   *
   * @return クラスオブジェクト
   */
  protected abstract Class<T> getResultClass();

}

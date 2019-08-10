package com.sdk.java.dmm.api.genre;


import com.sdk.java.dmm.api.AbstractDmm;
import com.sdk.java.dmm.api.genre.dto.GenreSearchResult;
import com.sdk.java.dmm.enums.BaseURL;
import com.sdk.java.dmm.enums.Message;
import com.sdk.java.dmm.enums.Output;
import com.sdk.java.dmm.exception.DmmIllegalArgumentException;
import com.sdk.java.dmm.exception.DmmIllegalParameterException;
import com.sdk.java.dmm.utils.StringUtil;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * <p>
 * ジャンル検索を実行するためのクラスです。<br>
 * 下記は使用方法になります。
 * </p>
 * <pre>
 * GenreSearch genreSearch = new GenreSearch();
 * genreSearch.setFloorId(40);
 * GenreSearchResult result = genreSearch.execute();
 * </pre>
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
public class GenreSearch extends AbstractDmm<GenreSearchResult> {

  /** フロアID */
  public Long floorId;
  /** ジャンルの頭文字(50音) */
  public String initial;
  /** 取得件数 */
  public Integer hits;
  /** 検索開始位置 */
  public Long offset;

  /**
   * フロアIDを設定する。<br>
   * <a href="https://affiliate.dmm.com/api/v3/floorlist.html">フロア検索API</a>から取得可能なフロアID
   *
   * @param floorId フロアID
   * @return this GenreSearch
   */
  public GenreSearch setFloorId(long floorId) {
    this.floorId = floorId;
    return this;
  }

  /**
   * ジャンルの頭文字を設定する。<br>
   * 50音をUTF-8で指定。<br>
   * 例:あい
   *
   * @param initial 頭文字
   * @return this GenreSearch
   * @throws DmmIllegalArgumentException 引数が不正な場合にスローされる
   */
  public GenreSearch setInitial(String initial) throws DmmIllegalArgumentException {
    if (!StringUtil.isJapaneseSyllabary(initial)) {
      throw new DmmIllegalArgumentException(Message.M0001, initial);
    }
    this.initial = URLEncoder.encode(initial, StandardCharsets.UTF_8);
    return this;
  }

  /**
   * 取得件数を設定する。<br>
   * 初期値：100　最大：500
   *
   * @param hits 取得件数
   * @return this GenreSearch
   */
  public GenreSearch setHits(Integer hits) {
    this.hits = hits;
    return this;
  }

  /**
   * 検索開始位置を設定する。<br>
   * 初期値：1
   *
   * @param offset 検索開始位置
   * @return this GenreSearch
   */
  public GenreSearch setOffset(long offset) {
    this.offset = offset;
    return this;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void clear() {
    // フロアID
    this.floorId = null;
    // ジャンルの頭文字(50音)
    this.initial = null;
    // 取得件数
    this.hits = null;
    // 検索開始位置
    this.offset = null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected String getParam() {
    this.paramCheck();
    String param = "";
    // フロアID
    param = StringUtil.addParam(param, "floor_id", this.floorId);
    // ジャンルの頭文字(50音)
    param = StringUtil.addParam(param, "initial", this.initial);
    // 取得件数
    param = StringUtil.addParam(param, "hits", this.hits);
    // 検索開始位置
    param = StringUtil.addParam(param, "offset", this.offset);
    // 出力形式
    param = StringUtil.addParam(param, "output", Output.JSON);
    return param;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected BaseURL getBaseURL() {
    return BaseURL.GENRE_SEARCH;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected Class<GenreSearchResult> getResultClass() {
    return GenreSearchResult.class;
  }

  /**
   * パラメータの相関チェックを行う。<br>
   * 入力値が不正な場合は、{@code DmmIllegalParameterException}をスローする。
   *
   * @throws DmmIllegalParameterException パラメータが不正な場合にスローされる
   */
  private void paramCheck() throws DmmIllegalParameterException {
    if (this.floorId == null) {
      throw new DmmIllegalParameterException(Message.M0007);
    }
  }

}

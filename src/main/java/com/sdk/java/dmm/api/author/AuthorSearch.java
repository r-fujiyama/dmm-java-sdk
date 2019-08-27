package com.sdk.java.dmm.api.author;


import com.sdk.java.dmm.api.AbstractDmm;
import com.sdk.java.dmm.api.author.dto.AuthorSearchResult;
import com.sdk.java.dmm.enums.BaseURL;
import com.sdk.java.dmm.enums.Message;
import com.sdk.java.dmm.enums.Output;
import com.sdk.java.dmm.exception.DmmIllegalArgumentException;
import com.sdk.java.dmm.exception.DmmIllegalParameterException;
import com.sdk.java.dmm.utils.StringUtil;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * <p>
 * 作者検索を実行するためのクラスです。<br>
 * 使用するにあたって下記の事項に注意してください。<br>
 * フロアIDは必須です。<br>
 * </p>
 * <p>
 * 下記は使用方法になります。
 * </p>
 * <pre>
 * AuthorSearch authorSearch = new AuthorSearch();
 * authorSearch.setFloorId(43);
 * AuthorSearchResult result = authorSearch.execute();
 * </pre>
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
public class AuthorSearch extends AbstractDmm<AuthorSearchResult> {

  /** フロアID */
  public String floorId;
  /** 作者名の頭文字(50音) */
  public String initial;
  /** 取得件数 */
  public Integer hits;
  /** 検索開始位置 */
  public Long offset;

  /**
   * MakerSearchオブジェクトを生成します。
   */
  public AuthorSearch() {
  }

  /**
   * フロアIDを設定する。<br>
   * <a href="https://affiliate.dmm.com/api/v3/floorlist.html">フロア検索API</a>から取得可能なフロアID
   *
   * @param floorId フロアID
   * @return this GenreSearch
   */
  public AuthorSearch setFloorId(String floorId) {
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
  public AuthorSearch setInitial(String initial) throws DmmIllegalArgumentException {
    if (initial == null) {
      this.initial = null;
      return this;
    }
    if (!StringUtil.isJapaneseSyllabary(initial)) {
      throw new DmmIllegalArgumentException(Message.M0001, "initial", initial);
    }
    this.initial = initial;
    return this;
  }

  /**
   * 取得件数を設定する。<br>
   * 初期値：100　最大：500
   *
   * @param hits 取得件数
   * @return this GenreSearch
   */
  public AuthorSearch setHits(Integer hits) {
    if (hits == null) {
      this.hits = null;
      return this;
    }
    if (hits == 0) {
      throw new DmmIllegalArgumentException(Message.M0008, "hits");
    }
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
  public AuthorSearch setOffset(Long offset) {
    if (offset == null) {
      this.offset = null;
      return this;
    }
    if (offset == 0) {
      throw new DmmIllegalArgumentException(Message.M0008, "offset");
    }
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
    param = StringUtil.addParam(param, "floor_id", StringUtil.URLEncode(this.floorId));
    // ジャンルの頭文字(50音)
    param = StringUtil.addParam(param, "initial", StringUtil.URLEncode(this.initial));
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
    return BaseURL.AUTHOR_SEARCH;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected Class<AuthorSearchResult> getResultClass() {
    return AuthorSearchResult.class;
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

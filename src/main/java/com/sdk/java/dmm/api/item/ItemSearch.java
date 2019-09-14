package com.sdk.java.dmm.api.item;


import com.sdk.java.dmm.api.AbstractDmm;
import com.sdk.java.dmm.api.item.dto.ItemSearchResult;
import com.sdk.java.dmm.enums.Article;
import com.sdk.java.dmm.enums.BaseURL;
import com.sdk.java.dmm.enums.ItemSearchSort;
import com.sdk.java.dmm.enums.Message;
import com.sdk.java.dmm.enums.MonoStock;
import com.sdk.java.dmm.enums.Site;
import com.sdk.java.dmm.exception.DmmIllegalArgumentException;
import com.sdk.java.dmm.exception.DmmIllegalParameterException;
import com.sdk.java.dmm.utils.DateTimeFormat;
import com.sdk.java.dmm.utils.StringUtil;
import java.time.LocalDateTime;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * <p>
 * 商品検索を実行するためのクラスです。<br>
 * 使用するにあたって下記の事項に注意してください。<br>
 * サイトは必須です。<br>
 * フロアが指定されている場合は、サービスは必須です。<br>
 * 絞りこみ項目が指定されている場合は、絞り込みIDが必須です。<br>
 * </p>
 * <p>
 * 下記は使用方法になります。
 * </p>
 * <pre>
 * ItemSearch itemSearch = new ItemSearch();
 * itemSearch.setSite(Site.DMM);
 * itemSearch.setService("digital");
 * itemSearch.setFloor("video");
 * ItemSearchResult result = itemSearch.execute();
 * </pre>
 */
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString
public class ItemSearch extends AbstractDmm<ItemSearchResult> {

  /** サイト */
  private Site site;
  /** サービス */
  private String service;
  /** フロア */
  private String floor;
  /** 取得件数 */
  private Integer hits;
  /** 検索開始位置 */
  private Integer offset;
  /** ソート順 */
  private ItemSearchSort sort;
  /** キーワード */
  private String keyword;
  /** 商品ID */
  private String cid;
  /** 絞りこみ項目 */
  private Article article;
  /** 絞り込みID */
  private String articleId;
  /** 発売日絞り込み_以上 */
  private LocalDateTime gteDate;
  /** 発売日絞り込み_以下 */
  private LocalDateTime lteDate;
  /** 在庫絞り込み */
  private MonoStock monoStock;

  /**
   * 商品検索オブジェクトを生成します。
   *
   * @param apiId       API_ID
   * @param affiliateId AFFILIATE_ID
   */
  public ItemSearch(String apiId, String affiliateId) {
    super(apiId, affiliateId);
  }

  /**
   * サイトを設定する。<br>
   * 必須項目です。必ず設定してください。<br>
   * 一般（DMM.com）かアダルト（FANZA）。
   *
   * @param site サイト
   * @return ItemSearch
   */
  public ItemSearch setSite(Site site) {
    this.site = site;
    return this;
  }

  /**
   * サービスを設定する。<br>
   * <a href="https://affiliate.dmm.com/api/v3/floorlist.html">フロア検索API</a>から取得できるサービスコードを指定。<br>
   * 例：digital
   *
   * @param service サービス
   * @return ItemSearch
   */
  public ItemSearch setService(String service) {
    this.service = service;
    return this;
  }

  /**
   * フロアを設定する。<br>
   * <a href="https://affiliate.dmm.com/api/v3/floorlist.html">フロア検索API</a>から取得できるフロアコードを指定。<br>
   * フロアを設定する場合は、サービスが必須です。<br>
   * 例：videoa
   *
   * @param floor フロア
   * @return ItemSearch
   */
  public ItemSearch setFloor(String floor) {
    this.floor = floor;
    return this;
  }

  /**
   * 取得件数を設定する。<br>
   * 初期値：20　最大：100
   *
   * @param hits 取得件数
   * @return ItemSearch
   * @throws DmmIllegalArgumentException 引数が不正な場合にスローされる
   */
  public ItemSearch setHits(Integer hits) throws DmmIllegalArgumentException {
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
   * 初期値：1　最大：50000
   *
   * @param offset 検索開始位置
   * @return ItemSearch
   * @throws DmmIllegalArgumentException 引数が不正な場合にスローされる
   */
  public ItemSearch setOffset(Integer offset) throws DmmIllegalArgumentException {
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
   * ソート順を設定する。<br>
   * 初期値：RANK<br>
   * 人気：RANK<br>
   * 価格が高い順：PRICE_DESC<br>
   * 価格が安い順：PRICE_ASC<br>
   * 新着：DATE<br>
   * 評価：REVIEW<br>
   *
   * @param sort ソート順
   * @return ItemSearch
   */
  public ItemSearch setSort(ItemSearchSort sort) {
    this.sort = sort;
    return this;
  }

  /**
   * キーワードを設定する。<br>
   * UTF-8で指定<br>
   * 例：上原亜衣
   *
   * @param keyword キーワード
   * @return ItemSearch
   */
  public ItemSearch setKeyword(String keyword) {
    this.keyword = keyword;
    return this;
  }

  /**
   * 商品IDを設定する。<br>
   * 商品に振られているcontent_id<br>
   * 例：15dss00145
   *
   * @param cid 商品ID
   * @return ItemSearch
   */
  public ItemSearch setCid(String cid) {
    this.cid = cid;
    return this;
  }

  /**
   * 絞りこみ項目を設定する。<br>
   * 絞り込み項目を設定する場合は、絞り込みIDが必須です。<br>
   * <a href="https://affiliate.dmm.com/api/v3/actresssearch.html">女優</a>：ACTRESS<br>
   * <a href="https://affiliate.dmm.com/api/v3/authorsearch.html">作者</a>：AUTHOR<br>
   * <a href="https://affiliate.dmm.com/api/v3/genresearch.html">ジャンル</a>：GENRE<br>
   * <a href="https://affiliate.dmm.com/api/v3/seriessearch.html">シリーズ</a>：SERIES<br>
   * <a href="https://affiliate.dmm.com/api/v3/makersearch.html">メーカー</a>：MAKER<br>
   *
   * @param article 絞りこみ項目
   * @return ItemSearch
   */
  public ItemSearch setArticle(Article article) {
    this.article = article;
    return this;
  }

  /**
   * 絞り込みIDを設定する。<br>
   * 絞り込み項目のIDは各検索APIから取得可能です。<br>
   * 絞り込みIDを設定する場合は、絞り込み項目が必須です。<br>
   * 例：1011199
   *
   * @param articleId 絞り込みID
   * @return ItemSearch
   */
  public ItemSearch setArticleId(String articleId) {
    this.articleId = articleId;
    return this;
  }

  /**
   * 発売日絞り込みを設定する。<br>
   * このパラメータで指定した日付以降に発売された商品を絞り込むことができます。
   *
   * @param gteDate 発売日絞り込み(以上)
   * @return ItemSearch
   */
  public ItemSearch setGteDate(LocalDateTime gteDate) {
    this.gteDate = gteDate;
    return this;
  }

  /**
   * 発売日絞り込みを設定する。<br>
   * このパラメータで指定した日付以降に発売された商品を絞り込むことができます。<br>
   * 例:2019-05-26T21:50:10
   *
   * @param gteDate 発売日絞り込み(以上)
   * @return ItemSearch
   * @throws DmmIllegalArgumentException 引数が不正な場合にスローされる
   */
  public ItemSearch setGteDate(String gteDate) throws DmmIllegalArgumentException {
    if (gteDate == null) {
      this.gteDate = null;
      return this;
    }
    if (!DateTimeFormat.uuuuMMddTHHmmss_HYPHEN.check(gteDate)) {
      throw new DmmIllegalArgumentException(Message.M0003, "gteDate", gteDate);
    }
    this.gteDate = DateTimeFormat.uuuuMMddTHHmmss_HYPHEN.parse(gteDate);
    return this;
  }

  /**
   * 発売日絞り込みを設定する。<br>
   * このパラメータで指定した日付以前に発売された商品を絞り込むことができます。
   *
   * @param lteDate 発売日絞り込み(以下)
   * @return ItemSearch
   */
  public ItemSearch setLteDate(LocalDateTime lteDate) {
    this.lteDate = lteDate;
    return this;
  }

  /**
   * 発売日絞り込みを設定する。<br>
   * このパラメータで指定した日付以降に発売された商品を絞り込むことができます。<br>
   * 例:2016-04-30T23:59:59
   *
   * @param lteDate 発売日絞り込み(以上)
   * @return ItemSearch
   * @throws DmmIllegalArgumentException 引数が不正な場合にスローされる
   */
  public ItemSearch setLteDate(String lteDate) throws DmmIllegalArgumentException {
    if (lteDate == null) {
      this.lteDate = null;
      return this;
    }
    if (!DateTimeFormat.uuuuMMddTHHmmss_HYPHEN.check(lteDate)) {
      throw new DmmIllegalArgumentException(Message.M0003, "lteDate", lteDate);
    }
    this.lteDate = DateTimeFormat.uuuuMMddTHHmmss_HYPHEN.parse(lteDate);
    return this;
  }

  /**
   * 在庫絞り込みを設定する。<br>
   * 初期値：絞り込みなし<br>
   * 在庫あり：STOCK<br>
   * 予約受付中：RESERVE<br>
   * DMM通販のみ：MONO<br>
   * マーケットプレイスのみ：DMP<br>
   * ※通販サービスのみ指定可能
   *
   * @param monoStock 在庫絞り込み
   * @return ItemSearch
   */
  public ItemSearch setMonoStock(MonoStock monoStock) {
    this.monoStock = monoStock;
    return this;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void clear() {
    // サイト
    this.site = null;
    // サービス
    this.service = null;
    // フロア
    this.floor = null;
    // 取得件数
    this.hits = null;
    // 検索開始位置
    this.offset = null;
    // ソート順
    this.sort = null;
    // キーワード
    this.keyword = null;
    // 商品id
    this.cid = null;
    // 絞りこみ項目
    this.article = null;
    // 絞り込みid
    this.articleId = null;
    // 発売日絞り込み_以上
    this.gteDate = null;
    // 発売日絞り込み_以下
    this.lteDate = null;
    // 在庫絞り込み
    this.monoStock = null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected String getParam() {
    this.paramCheck();
    String param = "";
    param = StringUtil.addParam(param, "site", this.site);
    // サービス
    param = StringUtil.addParam(param, "service", StringUtil.URLEncode(this.service));
    // フロア
    param = StringUtil.addParam(param, "floor", StringUtil.URLEncode(this.floor));
    // 取得件数
    param = StringUtil.addParam(param, "hits", this.hits);
    // 検索開始位置
    param = StringUtil.addParam(param, "offset", this.offset);
    // ソート順
    param = StringUtil.addParam(param, "sort", this.sort);
    // キーワード
    param = StringUtil.addParam(param, "keyword", StringUtil.URLEncode(this.keyword));
    // 商品id
    param = StringUtil.addParam(param, "cid", StringUtil.URLEncode(this.cid));
    // 絞りこみ項目
    param = StringUtil.addParam(param, "article", this.article);
    // 絞り込みid
    param = StringUtil.addParam(param, "article_id", StringUtil.URLEncode(this.articleId));
    // 発売日絞り込み_以上
    if (this.gteDate != null) {
      param = StringUtil.addParam(param, "gte_date",
          DateTimeFormat.uuuuMMddTHHmmss_HYPHEN.format(this.gteDate));
    }
    // 発売日絞り込み_以下
    if (this.lteDate != null) {
      param = StringUtil.addParam(param, "lte_date",
          DateTimeFormat.uuuuMMddTHHmmss_HYPHEN.format(this.lteDate));
    }
    // 在庫絞り込み
    param = StringUtil.addParam(param, "mono_stock", this.monoStock);
    return param;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected BaseURL getBaseURL() {
    return BaseURL.ITEM_SEARCH;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected Class<ItemSearchResult> getResultClass() {
    return ItemSearchResult.class;
  }

  /**
   * パラメータの相関チェックを行う。<br>
   * 入力値が不正な場合は、{@code DmmIllegalParameterException}をスローする。
   *
   * @throws DmmIllegalParameterException パラメータが不正な場合にスローされる
   */
  private void paramCheck() throws DmmIllegalParameterException {
    if (this.site == null) {
      throw new DmmIllegalParameterException(Message.M0004);
    }
    if (this.service == null && this.floor != null) {
      throw new DmmIllegalParameterException(Message.M0005);
    }
    if ((this.article != null && this.articleId == null) ||
        (this.article == null && this.articleId != null)) {
      throw new DmmIllegalParameterException(Message.M0006);
    }
  }

}

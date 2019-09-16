package com.sdk.java.dmm.api.item;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.sdk.java.dmm.api.ApiTestBase;
import com.sdk.java.dmm.api.actress.ActressSearch;
import com.sdk.java.dmm.api.actress.dto.ActressSearchResult;
import com.sdk.java.dmm.api.item.dto.Item;
import com.sdk.java.dmm.api.item.dto.ItemSearchResult;
import com.sdk.java.dmm.enums.Article;
import com.sdk.java.dmm.enums.ItemSearchSort;
import com.sdk.java.dmm.enums.Message;
import com.sdk.java.dmm.enums.MonoStock;
import com.sdk.java.dmm.enums.Site;
import com.sdk.java.dmm.exception.DmmIllegalArgumentException;
import com.sdk.java.dmm.exception.DmmIllegalParameterException;
import com.sdk.java.dmm.utils.DateTimeFormat;
import com.sdk.java.dmm.utils.JsonUtil;
import com.sdk.java.dmm.utils.MessageResolver;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ItemSearchTest extends ApiTestBase {

  private final ItemSearch itemSearch = create(ItemSearch.class);

  @AfterEach
  public void tearDown() {
    itemSearch.clear();
  }

  @Nested
  public class 正常系_execute {

    @Nested
    public class サイト_DMM {

      @BeforeEach
      public void setUp() {
        itemSearch.setSite(Site.DMM);
      }

      @Test
      public void 正常系_商品検索API実行_サイト() {
        ItemSearchResult result = execute();
        assertThat(result.getRequest().getParameters().getSite()).isEqualTo(Site.DMM);
      }

      @Test
      public void 正常系_商品検索API実行_サービスコード() {
        String cond = "digital";
        itemSearch.setService(cond);
        ItemSearchResult result = execute();
        result.getResult().getItems()
            .forEach(item -> assertThat(item.getServiceCode()).isEqualTo(cond));
      }

      @Test
      public void 正常系_商品検索API実行_フロアコード() {
        // フロアコードによる検索は、サービスコードが必須
        itemSearch.setService("digital");
        String cond = "video";
        itemSearch.setFloor(cond);
        ItemSearchResult result = execute();
        result.getResult().getItems()
            .forEach(item -> assertThat(item.getFloorCode()).isEqualTo(cond));
      }

      @Test
      public void 正常系_商品検索API実行_取得件数() {
        int cond = 100;
        itemSearch.setHits(cond);
        ItemSearchResult result = execute();
        assertThat(result.getResult().getResultCount()).isEqualTo(cond);
      }

      @Test
      public void 正常系_商品検索API実行_検索開始位置() {
        int cond = 10000;
        itemSearch.setOffset(cond);
        ItemSearchResult result = execute();
        assertThat(result.getResult().getFirstPosition()).isEqualTo(cond);
      }

      @Test
      public void 正常系_商品検索API実行_キーワード() {
        String cond = "あああ";
        itemSearch.setKeyword(cond);
        ItemSearchResult result = execute();
        assertThat(result.getRequest().getParameters().getKeyword()).isEqualTo(cond);
      }

      @Test
      public void 正常系_商品検索API実行_商品ID() {
        String cond = "b950nshes00953";
        itemSearch.setCid(cond);
        ItemSearchResult result = execute();
        assertThat(result.getResult().getItems().get(0).getContentId()).isEqualTo(cond);
      }

      @Nested
      public class 正常系_商品検索API実行_ソート {

        @Test
        public void 人気() {
          ItemSearchSort cond = ItemSearchSort.RANK;
          itemSearch.setSort(cond);
          ItemSearchResult result = execute();
          assertThat(result.getRequest().getParameters().getSort()).isEqualTo(cond);
        }

        @Test
        public void 価格_昇順() {
          ItemSearchSort cond = ItemSearchSort.PRICE_ASC;
          itemSearch.setSort(cond);
          ItemSearchResult result = execute();
          assertThat(result.getRequest().getParameters().getSort()).isEqualTo(cond);
        }

        @Test
        public void 価格_降順() {
          ItemSearchSort cond = ItemSearchSort.PRICE_ASC;
          itemSearch.setSort(cond);
          ItemSearchResult result = execute();
          assertThat(result.getRequest().getParameters().getSort()).isEqualTo(cond);
        }

        @Test
        public void 新着() {
          itemSearch.setSort(ItemSearchSort.DATE);
          ItemSearchResult result = execute();
          List<Item> itemList = result.getResult().getItems();
          assertThat(itemList).isNotEmpty();
          for (int i = 1; i < itemList.size(); i++) {
            LocalDateTime actual = itemList.get(i - 1).getDate();
            LocalDateTime expected = itemList.get(i).getDate();
            assertThat(actual).isAfterOrEqualTo(expected);
          }
        }

        @Test
        public void 評価() {
          itemSearch.setSort(ItemSearchSort.REVIEW);
          ItemSearchResult result = execute();
          List<Item> itemList = result.getResult().getItems();
          assertThat(itemList).isNotEmpty();
          for (int i = 1; i < itemList.size(); i++) {
            double actualAverage = itemList.get(i - 1).getReview().getAverage();
            double expectedAverage = itemList.get(i).getReview().getAverage();
            if (actualAverage == expectedAverage) {
              int actualCount = itemList.get(i - 1).getReview().getCount();
              int expectedCount = itemList.get(i).getReview().getCount();
              assertThat(actualCount).isGreaterThanOrEqualTo(expectedCount);
            }
            assertThat(actualAverage).isGreaterThanOrEqualTo(expectedAverage);
          }
        }

      }

      /**
       * 絞りこみ項目による検索は、絞り込みIDが必須
       */
      @Nested
      public class 正常系_商品検索API実行_絞りこみ項目と絞り込みID {

        @Test
        public void 女優() {
          itemSearch.setArticle(Article.ACTRESS);
          itemSearch.setArticleId("15365");
          ItemSearchResult itemSearchResult = execute();
          List<List<String>> nameListList = new ArrayList<List<String>>();
          itemSearchResult.getResult().getItems().forEach(item -> nameListList.add(
              item.getIteminfo().getActor().stream().map(actor -> actor.getName())
                  .collect(Collectors.toList())));

          ActressSearch actressSearch = create(ActressSearch.class);
          actressSearch.setActressId("15365");
          ActressSearchResult actressSearchResult = actressSearch.execute();
          String expected = actressSearchResult.getResult().getActress().get(0).getName();
          nameListList
              .forEach(nameList -> assertThat(nameList).isNotEmpty().contains(expected));
        }

        @Test
        public void 作者() {
          itemSearch.setArticle(Article.AUTHOR);
          String cond = "25";
          itemSearch.setArticleId(cond);
          ItemSearchResult itemSearchResult = execute();
          List<List<String>> idListList = new ArrayList<List<String>>();
          itemSearchResult.getResult().getItems().forEach(item -> idListList.add(
              item.getIteminfo().getAuthor().stream().map(genre -> genre.getId())
                  .collect(Collectors.toList())));
          idListList.forEach(idList -> assertThat(idList).isNotEmpty().contains(cond));
        }

        @Test
        public void ジャンル() {
          itemSearch.setArticle(Article.GENRE);
          String cond = "1";
          itemSearch.setArticleId(cond);
          ItemSearchResult itemSearchResult = execute();
          List<List<String>> idListList = new ArrayList<List<String>>();
          itemSearchResult.getResult().getItems().forEach(item -> idListList.add(
              item.getIteminfo().getGenre().stream().map(genre -> genre.getId())
                  .collect(Collectors.toList())));
          idListList.forEach(idList -> assertThat(idList).isNotEmpty().contains(cond));
        }

        @Test
        public void シリーズ() {
          itemSearch.setArticle(Article.SERIES);
          String cond = "69800";
          itemSearch.setArticleId(cond);
          ItemSearchResult itemSearchResult = execute();
          List<List<String>> idListList = new ArrayList<List<String>>();
          itemSearchResult.getResult().getItems().forEach(item -> idListList.add(
              item.getIteminfo().getSeries().stream().map(genre -> genre.getId())
                  .collect(Collectors.toList())));
          idListList.forEach(idList -> assertThat(idList).isNotEmpty().contains(cond));
        }

        @Test
        public void メーカー() {
          itemSearch.setArticle(Article.MAKER);
          String cond = "1";
          itemSearch.setArticleId(cond);
          ItemSearchResult itemSearchResult = execute();
          List<List<String>> idListList = new ArrayList<List<String>>();
          itemSearchResult.getResult().getItems().forEach(item -> idListList.add(
              item.getIteminfo().getMaker().stream().map(maker -> maker.getId())
                  .collect(Collectors.toList())));
          idListList.forEach(idList -> assertThat(idList).isNotEmpty().contains(cond));
        }

      }

      @Test
      public void 正常系_商品検索API実行_発売日絞り込みをLocalDateTimeで指定_以上() {
        LocalDateTime cond = DateTimeFormat.uuuuMMddTHHmmss_HYPHEN.parse("2019-07-01T00:00:00");
        itemSearch.setGteDate(cond);
        ItemSearchResult result = execute();
        result.getResult().getItems()
            .forEach(item -> assertThat(item.getDate()).isAfterOrEqualTo(cond));
      }

      @Test
      public void 正常系_商品検索API実行_発売日絞り込みを文字列で指定_以上() {
        String cond = "2019-07-01T00:00:00";
        itemSearch.setGteDate(cond);
        ItemSearchResult result = execute();
        result.getResult().getItems()
            .forEach(item -> assertThat(item.getDate()).isAfterOrEqualTo(cond));
      }

      @Test
      public void 正常系_商品検索API実行_発売日絞り込みをLocalDateTimeで指定_以下() {
        LocalDateTime cond = DateTimeFormat.uuuuMMddTHHmmss_HYPHEN.parse("2019-06-01T00:00:00");
        itemSearch.setLteDate(cond);
        ItemSearchResult result = execute();
        result.getResult().getItems()
            .forEach(item -> assertThat(item.getDate()).isBeforeOrEqualTo(cond));
      }

      @Test
      public void 正常系_商品検索API実行_発売日絞り込みを文字列で指定_以下() {
        String cond = "2019-06-01T00:00:00";
        itemSearch.setLteDate(cond);
        ItemSearchResult result = execute();
        result.getResult().getItems()
            .forEach(item -> assertThat(item.getDate()).isBeforeOrEqualTo(cond));
      }

      @Nested
      public class 正常系_商品検索API実行_在庫絞り込み {

        @BeforeEach
        public void setUp() {
          // 通販サービスのみ指定可能なため、サービスコード、フロアコードを指定する
          itemSearch.setService("mono");
          itemSearch.setFloor("dvd");
        }

        @Test
        public void 在庫あり() {
          MonoStock cond = MonoStock.STOCK;
          itemSearch.setMonoStock(cond);
          ItemSearchResult result = execute();
          result.getResult().getItems()
              .forEach(item -> assertThat(item.getStock()).isEqualTo(cond.getValue()));
        }

        @Test
        public void 予約受付中() {
          MonoStock cond = MonoStock.RESERVE;
          itemSearch.setMonoStock(cond);
          ItemSearchResult result = execute();
          result.getResult().getItems()
              .forEach(item -> assertThat(item.getStock()).isEqualTo(cond.getValue()));
        }

        @Test
        public void DMM通販のみ() {
          MonoStock cond = MonoStock.MONO;
          itemSearch.setMonoStock(cond);
          ItemSearchResult result = execute();
          assertThat(result.getRequest().getParameters().getMonoStock()).isEqualTo(cond);
        }

        @Test
        public void マーケットプレイスのみ() {
          MonoStock cond = MonoStock.DMP;
          itemSearch.setMonoStock(cond);
          ItemSearchResult result = execute();
          assertThat(result.getRequest().getParameters().getMonoStock()).isEqualTo(cond);
        }

      }

    }

    @Nested
    public class サイト_FANZA {

      @BeforeEach
      public void setUp() {
        itemSearch.setSite(Site.FANZA);
      }

      @Test
      public void 正常系_商品検索API実行_サイト() {
        ItemSearchResult result = execute();
        assertThat(result.getRequest().getParameters().getSite()).isEqualTo(Site.FANZA);
      }

      @Test
      public void 正常系_商品検索API実行_サービスコード() {
        String cond = "digital";
        itemSearch.setService(cond);
        ItemSearchResult result = execute();
        result.getResult().getItems()
            .forEach(item -> assertThat(item.getServiceCode()).isEqualTo(cond));
      }

      @Test
      public void 正常系_商品検索API実行_フロアコード() {
        // フロアコードによる検索は、サービスコードが必須
        itemSearch.setService("digital");
        String cond = "videoa";
        itemSearch.setFloor(cond);
        ItemSearchResult result = execute();
        result.getResult().getItems()
            .forEach(item -> assertThat(item.getFloorCode()).isEqualTo(cond));
      }

      @Test
      public void 正常系_商品検索API実行_取得件数() {
        int cond = 100;
        itemSearch.setHits(cond);
        ItemSearchResult result = execute();
        assertThat(result.getResult().getResultCount()).isEqualTo(cond);
      }

      @Test
      public void 正常系_商品検索API実行_検索開始位置() {
        int cond = 10000;
        itemSearch.setOffset(cond);
        ItemSearchResult result = execute();
        assertThat(result.getResult().getFirstPosition()).isEqualTo(cond);
      }

      @Test
      public void 正常系_商品検索API実行_キーワード() {
        String cond = "あああ";
        itemSearch.setKeyword(cond);
        ItemSearchResult result = execute();
        assertThat(result.getRequest().getParameters().getKeyword()).isEqualTo(cond);
      }

      @Test
      public void 正常系_商品検索API実行_商品ID() {
        String cond = "b915awnmg00944";
        itemSearch.setCid(cond);
        ItemSearchResult result = execute();
        assertThat(result.getResult().getItems().get(0).getContentId()).isEqualTo(cond);
      }

      @Nested
      public class 正常系_商品検索API実行_ソート {

        @Test
        public void 人気() {
          ItemSearchSort cond = ItemSearchSort.RANK;
          itemSearch.setSort(cond);
          ItemSearchResult result = execute();
          assertThat(result.getRequest().getParameters().getSort()).isEqualTo(cond);
        }

        @Test
        public void 価格_昇順() {
          ItemSearchSort cond = ItemSearchSort.PRICE_ASC;
          itemSearch.setSort(cond);
          ItemSearchResult result = execute();
          assertThat(result.getRequest().getParameters().getSort()).isEqualTo(cond);
        }

        @Test
        public void 価格_降順() {
          ItemSearchSort cond = ItemSearchSort.PRICE_ASC;
          itemSearch.setSort(cond);
          ItemSearchResult result = execute();
          assertThat(result.getRequest().getParameters().getSort()).isEqualTo(cond);
        }

        @Test
        public void 新着() {
          itemSearch.setSort(ItemSearchSort.DATE);
          ItemSearchResult result = execute();
          List<Item> itemList = result.getResult().getItems();
          assertThat(itemList).isNotEmpty();
          for (int i = 1; i < itemList.size(); i++) {
            LocalDateTime actual = itemList.get(i - 1).getDate();
            LocalDateTime expected = itemList.get(i).getDate();
            assertThat(actual).isAfterOrEqualTo(expected);
          }
        }

        @Test
        public void 評価() {
          itemSearch.setSort(ItemSearchSort.REVIEW);
          ItemSearchResult result = execute();
          List<Item> itemList = result.getResult().getItems();
          assertThat(itemList).isNotEmpty();
          for (int i = 1; i < itemList.size(); i++) {
            double actualAverage = itemList.get(i - 1).getReview().getAverage();
            double expectedAverage = itemList.get(i).getReview().getAverage();
            if (actualAverage == expectedAverage) {
              int actualCount = itemList.get(i - 1).getReview().getCount();
              int expectedCount = itemList.get(i).getReview().getCount();
              assertThat(actualCount).isGreaterThanOrEqualTo(expectedCount);
            }
            assertThat(actualAverage).isGreaterThanOrEqualTo(expectedAverage);
          }
        }

      }

      /**
       * 絞りこみ項目による検索は、絞り込みIDが必須
       */
      @Nested
      public class 正常系_商品検索API実行_絞りこみ項目と絞り込みID {

        @Test
        public void 女優() {
          itemSearch.setArticle(Article.ACTRESS);
          itemSearch.setArticleId("26225");
          ItemSearchResult itemSearchResult = execute();
          List<List<String>> idListList = new ArrayList<List<String>>();
          itemSearchResult.getResult().getItems().forEach(item -> idListList.add(
              item.getIteminfo().getActress().stream().map(actress -> actress.getId())
                  .collect(Collectors.toList())));

          ActressSearch actressSearch = create(ActressSearch.class);
          actressSearch.setActressId("26225");
          ActressSearchResult actressSearchResult = actressSearch.execute();
          String expected = actressSearchResult.getResult().getActress().get(0).getId();
          idListList.forEach(idList -> assertThat(idList).isNotEmpty().contains(expected));
        }

        @Test
        public void 作者() {
          itemSearch.setArticle(Article.AUTHOR);
          String cond = "3";
          itemSearch.setArticleId(cond);
          ItemSearchResult itemSearchResult = execute();
          List<List<String>> idListList = new ArrayList<List<String>>();
          itemSearchResult.getResult().getItems().forEach(item -> idListList.add(
              item.getIteminfo().getAuthor().stream().map(genre -> genre.getId())
                  .collect(Collectors.toList())));
          idListList.forEach(idList -> assertThat(idList).isNotEmpty().contains(cond));
        }

        @Test
        public void ジャンル() {
          itemSearch.setArticle(Article.GENRE);
          String cond = "1";
          itemSearch.setArticleId(cond);
          ItemSearchResult itemSearchResult = execute();
          List<List<String>> idListList = new ArrayList<List<String>>();
          itemSearchResult.getResult().getItems().forEach(item -> idListList.add(
              item.getIteminfo().getGenre().stream().map(genre -> genre.getId())
                  .collect(Collectors.toList())));
          idListList.forEach(idList -> assertThat(idList).isNotEmpty().contains(cond));
        }

        @Test
        public void シリーズ() {
          itemSearch.setArticle(Article.SERIES);
          String cond = "16015";
          itemSearch.setArticleId(cond);
          ItemSearchResult itemSearchResult = execute();
          List<List<String>> idListList = new ArrayList<List<String>>();
          itemSearchResult.getResult().getItems().forEach(item -> idListList.add(
              item.getIteminfo().getSeries().stream().map(genre -> genre.getId())
                  .collect(Collectors.toList())));
          idListList.forEach(idList -> assertThat(idList).isNotEmpty().contains(cond));
        }

        @Test
        public void メーカー() {
          itemSearch.setArticle(Article.MAKER);
          String cond = "5786";
          itemSearch.setArticleId(cond);
          ItemSearchResult itemSearchResult = execute();
          List<List<String>> idListList = new ArrayList<List<String>>();
          itemSearchResult.getResult().getItems().forEach(item -> idListList.add(
              item.getIteminfo().getMaker().stream().map(maker -> maker.getId())
                  .collect(Collectors.toList())));
          idListList.forEach(idList -> assertThat(idList).isNotEmpty().contains(cond));
        }

      }

      @Test
      public void 正常系_商品検索API実行_発売日絞り込みをLocalDateTimeで指定_以上() {
        LocalDateTime cond = DateTimeFormat.uuuuMMddTHHmmss_HYPHEN.parse("2019-07-01T00:00:00");
        itemSearch.setGteDate(cond);
        ItemSearchResult result = execute();
        result.getResult().getItems()
            .forEach(item -> assertThat(item.getDate()).isAfterOrEqualTo(cond));
      }

      @Test
      public void 正常系_商品検索API実行_発売日絞り込みを文字列で指定_以上() {
        String cond = "2019-07-01T00:00:00";
        itemSearch.setGteDate(cond);
        ItemSearchResult result = execute();
        result.getResult().getItems()
            .forEach(item -> assertThat(item.getDate()).isAfterOrEqualTo(cond));
      }

      @Test
      public void 正常系_商品検索API実行_発売日絞り込みをLocalDateTimeで指定_以下() {
        LocalDateTime cond = DateTimeFormat.uuuuMMddTHHmmss_HYPHEN.parse("2019-06-01T00:00:00");
        itemSearch.setLteDate(cond);
        ItemSearchResult result = execute();
        result.getResult().getItems()
            .forEach(item -> assertThat(item.getDate()).isBeforeOrEqualTo(cond));
      }

      @Test
      public void 正常系_商品検索API実行_発売日絞り込みを文字列で指定_以下() {
        String cond = "2019-06-01T00:00:00";
        itemSearch.setLteDate(cond);
        ItemSearchResult result = execute();
        result.getResult().getItems()
            .forEach(item -> assertThat(item.getDate()).isBeforeOrEqualTo(cond));
      }

      @Nested
      public class 正常系_商品検索API実行_在庫絞り込み {

        @BeforeEach
        public void setUp() {
          // 通販サービスのみ指定可能なため、サービスコード、フロアコードを指定する
          itemSearch.setService("mono");
          itemSearch.setFloor("dvd");
        }

        @Test
        public void 在庫あり() {
          MonoStock cond = MonoStock.STOCK;
          itemSearch.setMonoStock(cond);
          ItemSearchResult result = execute();
          result.getResult().getItems()
              .forEach(item -> assertThat(item.getStock()).isEqualTo(cond.getValue()));
        }

        @Test
        public void 予約受付中() {
          MonoStock cond = MonoStock.RESERVE;
          itemSearch.setMonoStock(cond);
          ItemSearchResult result = execute();
          result.getResult().getItems()
              .forEach(item -> assertThat(item.getStock()).isEqualTo(cond.getValue()));
        }

        @Test
        public void DMM通販のみ() {
          MonoStock cond = MonoStock.MONO;
          itemSearch.setMonoStock(cond);
          ItemSearchResult result = execute();
          assertThat(result.getRequest().getParameters().getMonoStock()).isEqualTo(cond);
        }

        @Test
        public void マーケットプレイスのみ() {
          MonoStock cond = MonoStock.DMP;
          itemSearch.setMonoStock(cond);
          ItemSearchResult result = execute();
          assertThat(result.getRequest().getParameters().getMonoStock()).isEqualTo(cond);
        }

      }

    }

  }

  @Test
  public void 正常系_getJson() {
    itemSearch.setSite(Site.DMM);
    ItemSearchResult expected = execute();
    ItemSearchResult actual = JsonUtil.read(itemSearch.getJson(), ItemSearchResult.class);
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void 正常系_clear() {
    itemSearch.setSite(Site.DMM);
    itemSearch.setService("");
    itemSearch.setFloor("");
    itemSearch.setHits(100);
    itemSearch.setOffset(1);
    itemSearch.setSort(ItemSearchSort.PRICE_ASC);
    itemSearch.setKeyword("aaa");
    itemSearch.setCid("aaa");
    itemSearch.setArticle(Article.GENRE);
    itemSearch.setArticleId("1");
    itemSearch.setGteDate(DateTimeFormat.uuuuMMddTHHmmss_HYPHEN.parse("2019-07-01T00:00:00"));
    itemSearch.setLteDate(DateTimeFormat.uuuuMMddTHHmmss_HYPHEN.parse("2019-07-01T00:00:00"));
    itemSearch.setMonoStock(MonoStock.STOCK);
    itemSearch.clear();
    assertThat(itemSearch).isEqualTo(create(ItemSearch.class));
  }

  @Test
  public void 正常系_setterからItemSearchが返却されていることを確認() {
    assertThat(itemSearch.setSite(Site.DMM)).isEqualTo(itemSearch);
    assertThat(itemSearch.setService("a")).isEqualTo(itemSearch);
    assertThat(itemSearch.setFloor("a")).isEqualTo(itemSearch);
    assertThat(itemSearch.setHits(1)).isEqualTo(itemSearch);
    assertThat(itemSearch.setOffset(1)).isEqualTo(itemSearch);
    assertThat(itemSearch.setSort(ItemSearchSort.RANK)).isEqualTo(itemSearch);
    assertThat(itemSearch.setKeyword("あ")).isEqualTo(itemSearch);
    assertThat(itemSearch.setCid("a")).isEqualTo(itemSearch);
    assertThat(itemSearch.setArticle(Article.ACTRESS)).isEqualTo(itemSearch);
    assertThat(itemSearch.setArticleId("1")).isEqualTo(itemSearch);
    assertThat(
        itemSearch.setGteDate(DateTimeFormat.uuuuMMddTHHmmss_HYPHEN.parse("2019-07-01T00:00:00")))
        .isEqualTo(itemSearch);
    assertThat(itemSearch.setGteDate("2019-07-01T00:00:00")).isEqualTo(itemSearch);
    assertThat(
        itemSearch.setLteDate(DateTimeFormat.uuuuMMddTHHmmss_HYPHEN.parse("2019-07-01T00:00:00")))
        .isEqualTo(itemSearch);
    assertThat(itemSearch.setLteDate("2019-07-01T00:00:00")).isEqualTo(itemSearch);
    assertThat(itemSearch.setMonoStock(MonoStock.STOCK)).isEqualTo(itemSearch);
  }

  @Test
  public void 正常系_setterの引数にNULLをセットした場合にエラーとならないこと() {
    assertThat(itemSearch.setSite(null)).isEqualTo(itemSearch);
    assertThat(itemSearch.setService(null)).isEqualTo(itemSearch);
    assertThat(itemSearch.setFloor(null)).isEqualTo(itemSearch);
    assertThat(itemSearch.setHits(null)).isEqualTo(itemSearch);
    assertThat(itemSearch.setOffset(null)).isEqualTo(itemSearch);
    assertThat(itemSearch.setSort(ItemSearchSort.RANK)).isEqualTo(itemSearch);
    assertThat(itemSearch.setKeyword(null)).isEqualTo(itemSearch);
    assertThat(itemSearch.setCid(null)).isEqualTo(itemSearch);
    assertThat(itemSearch.setArticle(Article.ACTRESS)).isEqualTo(itemSearch);
    assertThat(itemSearch.setArticleId(null)).isEqualTo(itemSearch);
    LocalDateTime ldtIsNull = null;
    String strIsNull = null;
    assertThat(itemSearch.setGteDate(ldtIsNull)).isEqualTo(itemSearch);
    assertThat(itemSearch.setGteDate(strIsNull)).isEqualTo(itemSearch);
    assertThat(itemSearch.setLteDate(ldtIsNull)).isEqualTo(itemSearch);
    assertThat(itemSearch.setLteDate(strIsNull)).isEqualTo(itemSearch);
    assertThat(itemSearch.setMonoStock(MonoStock.STOCK)).isEqualTo(itemSearch);
  }

  @Nested
  public class 異常系 {

    @Test
    public void 異常系_setHits_0の場合() {
      assertThatThrownBy(() -> itemSearch.setHits(0))
          .isInstanceOf(DmmIllegalArgumentException.class)
          .hasMessage(MessageResolver.getMessage(Message.M0008, "hits"));
    }

    @Test
    public void 異常系_setOffset_0の場合() {
      assertThatThrownBy(() -> itemSearch.setOffset(0))
          .isInstanceOf(DmmIllegalArgumentException.class)
          .hasMessage(MessageResolver.getMessage(Message.M0008, "offset"));
    }

    @Test
    public void 異常系_setGteDate_フォーマット不正() {
      String argument = "2019/01/01";
      assertThatThrownBy(() -> itemSearch.setGteDate(argument))
          .isInstanceOf(DmmIllegalArgumentException.class)
          .hasMessage(MessageResolver.getMessage(Message.M0003, "gteDate", argument));
    }

    @Test
    public void 異常系_setLteDate_フォーマット不正() {
      String argument = "2019/01/01";
      assertThatThrownBy(() -> itemSearch.setLteDate(argument))
          .isInstanceOf(DmmIllegalArgumentException.class)
          .hasMessage(MessageResolver.getMessage(Message.M0003, "lteDate", argument));
    }

    @Test
    public void 異常系_execute_サイトが設定されていない場合() {
      assertThatThrownBy(() -> itemSearch.execute())
          .isInstanceOf(DmmIllegalParameterException.class)
          .hasMessage(MessageResolver.getMessage(Message.M0004));
    }

    @Test
    public void 異常系_execute_フロアが設定されていてサービスが設定されていない場合() {
      itemSearch.setSite(Site.DMM);
      itemSearch.setFloor("floor");
      assertThatThrownBy(() -> itemSearch.execute())
          .isInstanceOf(DmmIllegalParameterException.class)
          .hasMessage(MessageResolver.getMessage(Message.M0005));
    }

    @Test
    public void 異常系_execute_絞り込み項目が設定されていて絞り込み項目IDが設定されていない場合() {
      itemSearch.setSite(Site.DMM);
      itemSearch.setArticle(Article.ACTRESS);
      assertThatThrownBy(() -> itemSearch.execute())
          .isInstanceOf(DmmIllegalParameterException.class)
          .hasMessage(MessageResolver.getMessage(Message.M0006));
    }

    @Test
    public void 異常系_execute_絞り込み項目IDが設定されていてが絞り込み項目設定されていない場合() {
      itemSearch.setSite(Site.DMM);
      itemSearch.setArticleId("1");
      assertThatThrownBy(() -> itemSearch.execute())
          .isInstanceOf(DmmIllegalParameterException.class)
          .hasMessage(MessageResolver.getMessage(Message.M0006));
    }

    @Test
    public void 異常系_リクエストが不正な場合() throws Exception {
      itemSearch.setSite(Site.DMM);
      Field field = ItemSearch.class.getDeclaredField("hits");
      field.setAccessible(true);
      field.set(itemSearch, 0);
      ItemSearchResult result = itemSearch.execute();
      assertThat(result.getResult().getStatus()).isEqualTo(400);
      assertThat(result.getResult().getMessage()).isEqualTo("BAD REQUEST");
    }

  }

  public ItemSearchResult execute() {
    ItemSearchResult itemSearchResult = itemSearch.execute();
    assertThat(itemSearchResult.getResult().getResultCount()).isNotEqualTo(0);
    return itemSearchResult;
  }

}

package com.sdk.java.dmm.api.series;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.sdk.java.dmm.api.floor.FloorSearch;
import com.sdk.java.dmm.api.floor.dto.FloorSearchResult;
import com.sdk.java.dmm.api.series.dto.SeriesSearchResult;
import com.sdk.java.dmm.enums.Message;
import com.sdk.java.dmm.exception.DmmIllegalArgumentException;
import com.sdk.java.dmm.exception.DmmIllegalParameterException;
import com.sdk.java.dmm.utils.JsonUtil;
import com.sdk.java.dmm.utils.MessageResolver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class SeriesSearchTest {

  private final SeriesSearch seriesSearch = new SeriesSearch();

  @AfterEach
  public void tearDown() {
    seriesSearch.clear();
  }

  @Nested
  public class 正常系_execute {

    @BeforeEach
    public void setUp() {
      seriesSearch.setFloorId("25");
    }

    @Test
    public void 正常系_シリーズ検索API実行_フロアID() {
      FloorSearch floorSearch = new FloorSearch();
      FloorSearchResult floorSearchResult = floorSearch.execute();
      floorSearchResult.getResult().getSite().forEach(site -> site.getService()
          .forEach(service -> service.getFloor().forEach(floor -> {
            seriesSearch.setFloorId(floor.getId());
            SeriesSearchResult seriesSearchResult = seriesSearch.execute();
            assertThat(seriesSearchResult.getResult().getFloorId()).isEqualTo(floor.getId());
          })));
    }

    @Test
    public void 正常系_シリーズ検索API実行_シリーズの頭文字() {
      String cond = "あ";
      seriesSearch.setInitial(cond);
      SeriesSearchResult seriesSearchResult = execute();
      seriesSearchResult.getResult().getSeries()
          .forEach(genre -> assertThat(genre.getRuby().charAt(0)).isEqualTo(cond.charAt(0)));
    }

    @Test
    public void 正常系_シリーズ検索API実行_取得件数() {
      int cond = 500;
      seriesSearch.setHits(cond);
      SeriesSearchResult seriesSearchResult = execute();
      assertThat(seriesSearchResult.getResult().getResultCount()).isEqualTo(cond);
    }

    @Test
    public void 正常系_シリーズ検索API実行_検索開始位置() {
      long cond = 100;
      seriesSearch.setOffset(cond);
      SeriesSearchResult seriesSearchResult = execute();
      assertThat(seriesSearchResult.getResult().getFirstPosition()).isEqualTo(cond);
    }

    @Test
    public void 正常系_シリーズ検索API実行_すべての検索条件() {
      seriesSearch.setFloorId("25");
      seriesSearch.setInitial("あ");
      seriesSearch.setHits(500);
      seriesSearch.setOffset(10L);
      assertThat(execute())
          .isEqualTo(JsonUtil.read(seriesSearch.getJson(), SeriesSearchResult.class));
    }

  }

  @Test
  public void 正常系_getJson() {
    seriesSearch.setFloorId("25");
    SeriesSearchResult expected = execute();
    SeriesSearchResult actual = JsonUtil.read(seriesSearch.getJson(), SeriesSearchResult.class);
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void 正常系_clear() {
    seriesSearch.setFloorId("1");
    seriesSearch.setInitial("あ");
    seriesSearch.setHits(1);
    seriesSearch.setOffset(1L);
    seriesSearch.clear();
    assertThat(seriesSearch).isEqualTo(new SeriesSearch());
  }

  @Test
  public void 正常系_setterからMakerSearchが返却されていることを確認() {
    assertThat(seriesSearch.setFloorId("1")).isEqualTo(seriesSearch);
    assertThat(seriesSearch.setInitial("あ")).isEqualTo(seriesSearch);
    assertThat(seriesSearch.setHits(1)).isEqualTo(seriesSearch);
    assertThat(seriesSearch.setOffset(1L)).isEqualTo(seriesSearch);
  }

  @Test
  public void 正常系_setterの引数にNULLをセットした場合にエラーとならないこと() {
    assertThat(seriesSearch.setFloorId(null)).isEqualTo(seriesSearch);
    assertThat(seriesSearch.setInitial(null)).isEqualTo(seriesSearch);
    assertThat(seriesSearch.setHits(null)).isEqualTo(seriesSearch);
    assertThat(seriesSearch.setOffset(null)).isEqualTo(seriesSearch);
    assertThat(seriesSearch).isEqualTo(new SeriesSearch());
  }

  @Nested
  public class 異常系 {

    @Test
    public void 異常系_setInitial_フォーマット不正() {
      String argument = "test";
      assertThatThrownBy(() -> seriesSearch.setInitial(argument))
          .isInstanceOf(DmmIllegalArgumentException.class)
          .hasMessage(MessageResolver.getMessage(Message.M0001, "initial", argument));
    }

    @Test
    public void 異常系_execute_フロアIDが設定されていない場合() {
      assertThatThrownBy(() -> seriesSearch.execute())
          .isInstanceOf(DmmIllegalParameterException.class)
          .hasMessage(MessageResolver.getMessage(Message.M0007));
    }

    @Test
    public void 異常系_setHits_0の場合() {
      assertThatThrownBy(() -> seriesSearch.setHits(0))
          .isInstanceOf(DmmIllegalArgumentException.class)
          .hasMessage(MessageResolver.getMessage(Message.M0008, "hits"));
    }

    @Test
    public void 異常系_setOffset_0の場合() {
      assertThatThrownBy(() -> seriesSearch.setOffset(0L))
          .isInstanceOf(DmmIllegalArgumentException.class)
          .hasMessage(MessageResolver.getMessage(Message.M0008, "offset"));
    }

  }

  public SeriesSearchResult execute() {
    SeriesSearchResult seriesSearchResult = seriesSearch.execute();
    assertThat(seriesSearchResult.getResult().getResultCount()).isNotEqualTo(0);
    return seriesSearchResult;
  }

}

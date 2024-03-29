package com.sdk.java.dmm.api.genre;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.sdk.java.dmm.api.ApiTestBase;
import com.sdk.java.dmm.api.floor.FloorSearch;
import com.sdk.java.dmm.api.floor.dto.FloorSearchResult;
import com.sdk.java.dmm.api.genre.dto.GenreSearchResult;
import com.sdk.java.dmm.enums.Message;
import com.sdk.java.dmm.exception.DmmIllegalArgumentException;
import com.sdk.java.dmm.exception.DmmIllegalParameterException;
import com.sdk.java.dmm.utils.JsonUtil;
import com.sdk.java.dmm.utils.MessageResolver;
import java.lang.reflect.Field;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class GenreSearchTest extends ApiTestBase {

  private final GenreSearch genreSearch = create(GenreSearch.class);

  @AfterEach
  public void tearDown() {
    genreSearch.clear();
  }

  @Nested
  public class 正常系_execute {

    @BeforeEach
    public void setUp() {
      genreSearch.setFloorId("19");
    }

    @Test
    public void 正常系_ジャンル検索API実行_フロアID() {
      FloorSearch floorSearch = create(FloorSearch.class);
      FloorSearchResult floorSearchResult = floorSearch.execute();
      floorSearchResult.getResult().getSite().forEach(site -> site.getService()
          .forEach(service -> service.getFloor().forEach(floor -> {
            genreSearch.setFloorId(floor.getId());
            GenreSearchResult genreSearchResult = genreSearch.execute();
            assertThat(genreSearchResult.getResult().getFloorId()).isEqualTo(floor.getId());
          })));
    }

    @Test
    public void 正常系_ジャンル検索API実行_ジャンルの頭文字() {
      String cond = "あ";
      genreSearch.setInitial(cond);
      GenreSearchResult genreSearchResult = execute();
      genreSearchResult.getResult().getGenre()
          .forEach(genre -> assertThat(genre.getRuby().charAt(0)).isEqualTo(cond.charAt(0)));
    }

    @Test
    public void 正常系_ジャンル検索API実行_取得件数() {
      int cond = 500;
      genreSearch.setHits(cond);
      GenreSearchResult genreSearchResult = execute();
      assertThat(genreSearchResult.getResult().getResultCount()).isEqualTo(cond);
    }

    @Test
    public void 正常系_ジャンル検索API実行_検索開始位置() {
      long cond = 100;
      genreSearch.setOffset(cond);
      GenreSearchResult genreSearchResult = execute();
      assertThat(genreSearchResult.getResult().getFirstPosition()).isEqualTo(cond);
    }

    @Test
    public void 正常系_ジャンル検索API実行_すべての検索条件() {
      genreSearch.setFloorId("19");
      genreSearch.setInitial("あ");
      genreSearch.setHits(500);
      genreSearch.setOffset(10L);
      assertThat(execute())
          .isEqualTo(JsonUtil.read(genreSearch.getJson(), GenreSearchResult.class));
    }

  }

  @Test
  public void 正常系_getJson() {
    genreSearch.setFloorId("19");
    GenreSearchResult expected = execute();
    GenreSearchResult actual = JsonUtil.read(genreSearch.getJson(), GenreSearchResult.class);
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void 正常系_clear() {
    genreSearch.setFloorId("1");
    genreSearch.setInitial("あ");
    genreSearch.setHits(1);
    genreSearch.setOffset(1L);
    genreSearch.clear();
    assertThat(genreSearch).isEqualTo(create(GenreSearch.class));
  }

  @Test
  public void 正常系_setterからGenreSearchが返却されていることを確認() {
    assertThat(genreSearch.setFloorId("1")).isEqualTo(genreSearch);
    assertThat(genreSearch.setInitial("あ")).isEqualTo(genreSearch);
    assertThat(genreSearch.setHits(1)).isEqualTo(genreSearch);
    assertThat(genreSearch.setOffset(1L)).isEqualTo(genreSearch);
  }

  @Test
  public void 正常系_setterの引数にNULLをセットした場合にエラーとならないこと() {
    assertThat(genreSearch.setFloorId(null)).isEqualTo(genreSearch);
    assertThat(genreSearch.setInitial(null)).isEqualTo(genreSearch);
    assertThat(genreSearch.setHits(null)).isEqualTo(genreSearch);
    assertThat(genreSearch.setOffset(null)).isEqualTo(genreSearch);
    assertThat(genreSearch).isEqualTo(create(GenreSearch.class));
  }

  public GenreSearchResult execute() {
    GenreSearchResult genreSearchResult = genreSearch.execute();
    assertThat(genreSearchResult.getResult().getResultCount()).isNotEqualTo(0);
    return genreSearchResult;
  }

  @Nested
  public class 異常系 {

    @Test
    public void 異常系_setInitial_フォーマット不正() {
      String argument = "test";
      assertThatThrownBy(() -> genreSearch.setInitial(argument))
          .isInstanceOf(DmmIllegalArgumentException.class)
          .hasMessage(MessageResolver.getMessage(Message.M0001, "initial", argument));
    }

    @Test
    public void 異常系_execute_フロアIDが設定されていない場合() {
      assertThatThrownBy(() -> genreSearch.execute())
          .isInstanceOf(DmmIllegalParameterException.class)
          .hasMessage(MessageResolver.getMessage(Message.M0007));
    }

    @Test
    public void 異常系_setHits_0の場合() {
      assertThatThrownBy(() -> genreSearch.setHits(0))
          .isInstanceOf(DmmIllegalArgumentException.class)
          .hasMessage(MessageResolver.getMessage(Message.M0008, "hits"));
    }

    @Test
    public void 異常系_setOffset_0の場合() {
      assertThatThrownBy(() -> genreSearch.setOffset(0L))
          .isInstanceOf(DmmIllegalArgumentException.class)
          .hasMessage(MessageResolver.getMessage(Message.M0008, "offset"));
    }

    @Test
    public void 異常系_リクエストが不正な場合() throws Exception {
      genreSearch.setFloorId("19");
      Field field = GenreSearch.class.getDeclaredField("hits");
      field.setAccessible(true);
      field.set(genreSearch, 0);
      GenreSearchResult result = genreSearch.execute();
      assertThat(result.getResult().getStatus()).isEqualTo(400);
      assertThat(result.getResult().getMessage()).isEqualTo("BAD REQUEST");
    }

  }

}

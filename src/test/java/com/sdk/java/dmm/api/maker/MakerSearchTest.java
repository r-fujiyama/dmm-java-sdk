package com.sdk.java.dmm.api.maker;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.sdk.java.dmm.api.ApiTestBase;
import com.sdk.java.dmm.api.floor.FloorSearch;
import com.sdk.java.dmm.api.floor.dto.FloorSearchResult;
import com.sdk.java.dmm.api.maker.dto.MakerSearchResult;
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

public class MakerSearchTest extends ApiTestBase {

  private final MakerSearch makerSearch = create(MakerSearch.class);

  @AfterEach
  public void tearDown() {
    makerSearch.clear();
  }

  @Nested
  public class 正常系_execute {

    @BeforeEach
    public void setUp() {
      makerSearch.setFloorId("25");
    }

    @Test
    public void 正常系_メーカー検索API実行_フロアID() {
      FloorSearch floorSearch = create(FloorSearch.class);
      FloorSearchResult floorSearchResult = floorSearch.execute();
      floorSearchResult.getResult().getSite().forEach(site -> site.getService()
          .forEach(service -> service.getFloor().forEach(floor -> {
            makerSearch.setFloorId(floor.getId());
            MakerSearchResult makerSearchResult = makerSearch.execute();
            assertThat(makerSearchResult.getResult().getFloorId()).isEqualTo(floor.getId());
          })));
    }

    @Test
    public void 正常系_メーカー検索API実行_メーカーの頭文字() {
      String cond = "あ";
      makerSearch.setInitial(cond);
      MakerSearchResult makerSearchResult = execute();
      makerSearchResult.getResult().getMaker()
          .forEach(genre -> assertThat(genre.getRuby().charAt(0)).isEqualTo(cond.charAt(0)));
    }

    @Test
    public void 正常系_メーカー検索API実行_取得件数() {
      int cond = 500;
      makerSearch.setHits(cond);
      MakerSearchResult makerSearchResult = execute();
      assertThat(makerSearchResult.getResult().getResultCount()).isEqualTo(cond);
    }

    @Test
    public void 正常系_メーカー検索API実行_検索開始位置() {
      long cond = 100;
      makerSearch.setOffset(cond);
      MakerSearchResult makerSearchResult = execute();
      assertThat(makerSearchResult.getResult().getFirstPosition()).isEqualTo(cond);
    }

    @Test
    public void 正常系_メーカー検索API実行_すべての検索条件() {
      makerSearch.setFloorId("25");
      makerSearch.setInitial("あ");
      makerSearch.setHits(500);
      makerSearch.setOffset(10L);
      assertThat(execute())
          .isEqualTo(JsonUtil.read(makerSearch.getJson(), MakerSearchResult.class));
    }

  }

  @Test
  public void 正常系_getJson() {
    makerSearch.setFloorId("25");
    MakerSearchResult expected = execute();
    MakerSearchResult actual = JsonUtil.read(makerSearch.getJson(), MakerSearchResult.class);
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void 正常系_clear() {
    makerSearch.setFloorId("1");
    makerSearch.setInitial("あ");
    makerSearch.setHits(1);
    makerSearch.setOffset(1L);
    makerSearch.clear();
    assertThat(makerSearch).isEqualTo(create(MakerSearch.class));
  }

  @Test
  public void 正常系_setterからMakerSearchが返却されていることを確認() {
    assertThat(makerSearch.setFloorId("1")).isEqualTo(makerSearch);
    assertThat(makerSearch.setInitial("あ")).isEqualTo(makerSearch);
    assertThat(makerSearch.setHits(1)).isEqualTo(makerSearch);
    assertThat(makerSearch.setOffset(1L)).isEqualTo(makerSearch);
  }

  @Test
  public void 正常系_setterの引数にNULLをセットした場合にエラーとならないこと() {
    assertThat(makerSearch.setFloorId(null)).isEqualTo(makerSearch);
    assertThat(makerSearch.setInitial(null)).isEqualTo(makerSearch);
    assertThat(makerSearch.setHits(null)).isEqualTo(makerSearch);
    assertThat(makerSearch.setOffset(null)).isEqualTo(makerSearch);
    assertThat(makerSearch).isEqualTo(create(MakerSearch.class));
  }

  @Nested
  public class 異常系 {

    @Test
    public void 異常系_setInitial_フォーマット不正() {
      String argument = "test";
      assertThatThrownBy(() -> makerSearch.setInitial(argument))
          .isInstanceOf(DmmIllegalArgumentException.class)
          .hasMessage(MessageResolver.getMessage(Message.M0001, "initial", argument));
    }

    @Test
    public void 異常系_execute_フロアIDが設定されていない場合() {
      assertThatThrownBy(() -> makerSearch.execute())
          .isInstanceOf(DmmIllegalParameterException.class)
          .hasMessage(MessageResolver.getMessage(Message.M0007));
    }

    @Test
    public void 異常系_setHits_0の場合() {
      assertThatThrownBy(() -> makerSearch.setHits(0))
          .isInstanceOf(DmmIllegalArgumentException.class)
          .hasMessage(MessageResolver.getMessage(Message.M0008, "hits"));
    }

    @Test
    public void 異常系_setOffset_0の場合() {
      assertThatThrownBy(() -> makerSearch.setOffset(0L))
          .isInstanceOf(DmmIllegalArgumentException.class)
          .hasMessage(MessageResolver.getMessage(Message.M0008, "offset"));
    }

    @Test
    public void 異常系_リクエストが不正な場合() throws Exception {
      makerSearch.setFloorId("25");
      Field field = MakerSearch.class.getDeclaredField("hits");
      field.setAccessible(true);
      field.set(makerSearch, 0);
      MakerSearchResult result = makerSearch.execute();
      assertThat(result.getResult().getStatus()).isEqualTo(400);
      assertThat(result.getResult().getMessage()).isEqualTo("BAD REQUEST");
    }

  }

  public MakerSearchResult execute() {
    MakerSearchResult makerSearchResult = makerSearch.execute();
    assertThat(makerSearchResult.getResult().getResultCount()).isNotEqualTo(0);
    return makerSearchResult;
  }

}

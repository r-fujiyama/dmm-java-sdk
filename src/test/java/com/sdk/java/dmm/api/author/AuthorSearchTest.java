package com.sdk.java.dmm.api.author;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.sdk.java.dmm.api.author.dto.AuthorSearchResult;
import com.sdk.java.dmm.api.floor.FloorSearch;
import com.sdk.java.dmm.api.floor.dto.FloorSearchResult;
import com.sdk.java.dmm.enums.Message;
import com.sdk.java.dmm.exception.DmmIllegalArgumentException;
import com.sdk.java.dmm.exception.DmmIllegalParameterException;
import com.sdk.java.dmm.utils.JsonUtil;
import com.sdk.java.dmm.utils.MessageResolver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class AuthorSearchTest {

  private final AuthorSearch authorSearch = new AuthorSearch();

  @AfterEach
  public void tearDown() {
    authorSearch.clear();
  }

  @Nested
  public class 正常系_execute {

    @BeforeEach
    public void setUp() {
      authorSearch.setFloorId("25");
    }

    @Test
    public void 正常系_作者検索API実行_フロアID() {
      FloorSearch floorSearch = new FloorSearch();
      FloorSearchResult floorSearchResult = floorSearch.execute();
      floorSearchResult.getResult().getSite().forEach(site -> site.getService()
          .forEach(service -> service.getFloor().forEach(floor -> {
            authorSearch.setFloorId(floor.getId());
            AuthorSearchResult authorSearchResult = authorSearch.execute();
            assertThat(authorSearchResult.getResult().getFloorId()).isEqualTo(floor.getId());
          })));
    }

    @Test
    public void 正常系_作者検索API実行_作者の頭文字() {
      String cond = "あ";
      authorSearch.setInitial(cond);
      AuthorSearchResult authorSearchResult = execute();
      authorSearchResult.getResult().getAuthor()
          .forEach(genre -> assertThat(genre.getRuby().charAt(0)).isEqualTo(cond.charAt(0)));
    }

    @Test
    public void 正常系_作者検索API実行_取得件数() {
      int cond = 500;
      authorSearch.setHits(cond);
      AuthorSearchResult authorSearchResult = execute();
      assertThat(authorSearchResult.getResult().getResultCount()).isEqualTo(cond);
    }

    @Test
    public void 正常系_作者検索API実行_検索開始位置() {
      long cond = 100;
      authorSearch.setOffset(cond);
      AuthorSearchResult authorSearchResult = execute();
      assertThat(authorSearchResult.getResult().getFirstPosition()).isEqualTo(cond);
    }

    @Test
    public void 正常系_作者検索API実行_すべての検索条件() {
      authorSearch.setFloorId("25");
      authorSearch.setInitial("あ");
      authorSearch.setHits(500);
      authorSearch.setOffset(10);
      assertThat(execute())
          .isEqualTo(JsonUtil.read(authorSearch.getJson(), AuthorSearchResult.class));
    }

  }

  @Test
  public void 正常系_getJson() {
    authorSearch.setFloorId("25");
    AuthorSearchResult expected = execute();
    AuthorSearchResult actual = JsonUtil.read(authorSearch.getJson(), AuthorSearchResult.class);
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void 正常系_clear() {
    authorSearch.setFloorId("1");
    authorSearch.setInitial("あ");
    authorSearch.setHits(1);
    authorSearch.setOffset(1L);
    authorSearch.clear();
    assertThat(authorSearch).isEqualTo(new AuthorSearch());
  }

  @Test
  public void 正常系_setterからMakerSearchが返却されていることを確認() {
    assertThat(authorSearch.setFloorId("1")).isEqualTo(authorSearch);
    assertThat(authorSearch.setInitial("あ")).isEqualTo(authorSearch);
    assertThat(authorSearch.setHits(1)).isEqualTo(authorSearch);
    assertThat(authorSearch.setOffset(1)).isEqualTo(authorSearch);
  }

  @Nested
  public class 異常系 {

    @Test
    public void 異常系_setInitial_フォーマット不正() {
      String argument = "test";
      assertThatThrownBy(() -> authorSearch.setInitial(argument))
          .isInstanceOf(DmmIllegalArgumentException.class)
          .hasMessage(MessageResolver.getMessage(Message.M0001, "initial", argument));
    }

    @Test
    public void 異常系_execute_フロアIDが設定されていない場合() {
      assertThatThrownBy(() -> authorSearch.execute())
          .isInstanceOf(DmmIllegalParameterException.class)
          .hasMessage(MessageResolver.getMessage(Message.M0007));
    }

    @Test
    public void 異常系_setHits_0の場合() {
      assertThatThrownBy(() -> authorSearch.setHits(0))
          .isInstanceOf(DmmIllegalArgumentException.class)
          .hasMessage(MessageResolver.getMessage(Message.M0008, "hits"));
    }

    @Test
    public void 異常系_setOffset_0の場合() {
      assertThatThrownBy(() -> authorSearch.setOffset(0))
          .isInstanceOf(DmmIllegalArgumentException.class)
          .hasMessage(MessageResolver.getMessage(Message.M0008, "offset"));
    }

  }

  public AuthorSearchResult execute() {
    AuthorSearchResult authorSearchResult = authorSearch.execute();
    assertThat(authorSearchResult.getResult().getResultCount()).isNotEqualTo(0);
    return authorSearchResult;
  }

}

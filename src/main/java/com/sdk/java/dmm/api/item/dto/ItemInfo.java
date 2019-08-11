package com.sdk.java.dmm.api.item.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Collections;
import java.util.List;
import lombok.Value;

/**
 * 商品詳細
 */
@Value
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "genre",
    "genre_category",
    "series",
    "maker",
    "actor",
    "actress",
    "director",
    "author",
    "label",
    "manufacture",
    "artist",
    "type",
    "color",
    "size"
})
public class ItemInfo {

  /** ジャンル */
  @JsonProperty("genre")
  private List<Genre> genre = Collections.emptyList();
  /** ジャンルカテゴリー */
  @JsonProperty("genre_category")
  private List<GenreCategory> genreCategory = Collections.emptyList();
  /** シリーズ */
  @JsonProperty("series")
  private List<Series> series = Collections.emptyList();
  /** メーカー */
  @JsonProperty("maker")
  private List<Maker> maker = Collections.emptyList();
  /** 出演者（一般作品のみ） */
  @JsonProperty("actor")
  private List<Actor> actor = Collections.emptyList();
  /** 女優（アダルト作品のみ） */
  @JsonProperty("actress")
  private List<Actress> actress = Collections.emptyList();
  /** 監督 */
  @JsonProperty("director")
  private List<Director> director = Collections.emptyList();
  /** 作家、原作者、著者 */
  @JsonProperty("author")
  private List<Author> author = Collections.emptyList();
  /** レーベル */
  @JsonProperty("label")
  private List<Label> label = Collections.emptyList();
  /** 出版社、制作会社 */
  @JsonProperty("manufacture")
  private List<Manufacture> manufacture = Collections.emptyList();
  /** アーティスト */
  @JsonProperty("artist")
  private List<Artist> artist = Collections.emptyList();
  /** タイプ */
  @JsonProperty("type")
  private List<Type> type = Collections.emptyList();
  /** カラー */
  @JsonProperty("color")
  private List<Color> color = Collections.emptyList();
  /** サイズ */
  @JsonProperty("size")
  private List<Size> size = Collections.emptyList();

}

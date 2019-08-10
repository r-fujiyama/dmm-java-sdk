package com.sdk.java.dmm.api.item.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;
import lombok.Value;

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

  @JsonProperty("genre")
  private List<Genre> genre = null;
  @JsonProperty("genre_category")
  private List<GenreCategory> genreCategory = null;
  @JsonProperty("series")
  private List<Series> series = null;
  @JsonProperty("maker")
  private List<Maker> maker = null;
  @JsonProperty("actor")
  private List<Actor> actor = null;
  @JsonProperty("actress")
  private List<Actress> actress = null;
  @JsonProperty("director")
  private List<Director> director = null;
  @JsonProperty("author")
  private List<Author> author = null;
  @JsonProperty("label")
  private List<Label> label = null;
  @JsonProperty("manufacture")
  private List<Manufacture> manufacture = null;
  @JsonProperty("artist")
  private List<Artist> artist = null;
  @JsonProperty("type")
  private List<Type> type = null;
  @JsonProperty("color")
  private List<Color> color = null;
  @JsonProperty("size")
  private List<Size> size = null;

}

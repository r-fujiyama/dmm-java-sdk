package com.sdk.java.dmm.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * フロアID指定時に使用する列挙型
 */
@AllArgsConstructor
@Getter
public enum Floor implements CodeEnum<String> {

  /** DMM AKB48グループ AKB48 */
  DMM_LOD_AKB48("1", "DMM,AKB48グループ,AKB48"),
  /** DMM AKB48グループ SKE48 */
  DMM_LOD_SKE48("2", "DMM,AKB48グループ,SKE48"),
  /** DMM AKB48グループ NMB48 */
  DMM_LOD_NMB48("3", "DMM,AKB48グループ,NMB48"),
  /** DMM AKB48グループ HKT48 */
  DMM_LOD_HKT48("4", "DMM,AKB48グループ,HKT48"),
  /** DMM AKB48グループ NGT48 */
  DMM_LOD_NGT48("5", "DMM,AKB48グループ,NGT48"),
  /** DMM AKB48グループ REVIVAL!! ON DEMAND */
  DMM_LOD_ROD("6", "DMM,AKB48グループ,REVIVAL!! ON DEMAND"),
  /** DMM 動画 一般動画 */
  DMM_DIGITAL_VIDEOMARKET("90", "DMM,動画,一般動画"),
  /** DMM 動画 アイドル */
  DMM_DIGITAL_IDOL("9", "DMM,動画,アイドル"),
  /** DMM 動画 舞台 */
  DMM_DIGITAL_CINEMA("10", "DMM,動画,舞台"),
  /** DMM 動画 VR */
  DMM_DIGITAL_VIDEO("12", "DMM,動画,VR"),
  /** DMM 月額動画 見放題ch ライト */
  DMM_MONTHLY_PRIME("88", "DMM,月額動画,見放題ch ライト"),
  /** DMM 月額動画 アイドルチャンネル */
  DMM_MONTHLY_IDOL("15", "DMM,月額動画,アイドルチャンネル"),
  /** DMM 電子書籍 コミック */
  DMM_EBOOK_COMIC("19", "DMM,電子書籍,コミック"),
  /** DMM 電子書籍 写真集 */
  DMM_EBOOK_PHOTO("20", "DMM,電子書籍,写真集"),
  /** DMM 電子書籍 文芸・ラノベ */
  DMM_EBOOK_NOVEL("21", "DMM,電子書籍,文芸・ラノベ"),
  /** DMM 電子書籍 ビジネス・実用 */
  DMM_EBOOK_OTHERBOOKS("22", "DMM,電子書籍,ビジネス・実用"),
  /** DMM PCゲーム/ソフトウェア PCゲーム */
  DMM_PCSOFT_DIGITAL_PCGAME("23", "DMM,PCゲーム/ソフトウェア,PCゲーム"),
  /** DMM PCゲーム/ソフトウェア ソフトウェア */
  DMM_PCSOFT_DIGITAL_PCSOFT("24", "DMM,PCゲーム/ソフトウェア,ソフトウェア"),
  /** DMM 通販 DVD・Blu-ray */
  DMM_MONO_DVD("25", "DMM,通販,DVD・Blu-ray"),
  /** DMM 通販 CD */
  DMM_MONO_CD("26", "DMM,通販,CD"),
  /** DMM 通販 本・コミック */
  DMM_MONO_BOOK("27", "DMM,通販,本・コミック"),
  /** DMM 通販 ホビー */
  DMM_MONO_HOBBY("29", "DMM,通販,ホビー"),
  /** DMM DVD/CDレンタル 月額DVDレンタル */
  DMM_RENTAL_RENTAL_DVD("33", "DMM,DVD/CDレンタル,月額DVDレンタル"),
  /** DMM DVD/CDレンタル 月額CDレンタル */
  DMM_RENTAL_RENTAL_CD("34", "DMM,DVD/CDレンタル,月額CDレンタル"),
  /** DMM DVD/CDレンタル 単品DVDレンタル */
  DMM_RENTAL_PPR_DVD("35", "DMM,DVD/CDレンタル,単品DVDレンタル"),
  /** DMM DVD/CDレンタル 単品CDレンタル */
  DMM_RENTAL_PPR_CD("36", "DMM,DVD/CDレンタル,単品CDレンタル"),
  /** DMM DVD/CDレンタル コミック */
  DMM_RENTAL_RENTAL_COMIC("39", "DMM,DVD/CDレンタル,コミック"),
  /** DMM いろいろレンタル レディースファッションレンタル */
  DMM_NANDEMO_FASHION_LADIES("40", "DMM,いろいろレンタル,レディースファッションレンタル"),
  /** DMM いろいろレンタル メンズファッションレンタル */
  DMM_NANDEMO_FASHION_MENS("41", "DMM,いろいろレンタル,メンズファッションレンタル"),
  /** DMM いろいろレンタル いろいろ */
  DMM_NANDEMO_RENTAL_IROIRO("42", "DMM,いろいろレンタル,いろいろ"),
  /** FANZA 動画 ビデオ */
  FANZA_DIGITAL_VIDEOA("43", "FANZA,動画,ビデオ"),
  /** FANZA 動画 素人 */
  FANZA_DIGITAL_VIDEOC("44", "FANZA,動画,素人"),
  /** FANZA 動画 成人映画 */
  FANZA_DIGITAL_NIKKATSU("45", "FANZA,動画,成人映画"),
  /** FANZA 動画 アニメ動画 */
  FANZA_DIGITAL_ANIME("46", "FANZA,動画,アニメ動画"),
  /** FANZA 月額動画 プレイガール ch. */
  FANZA_MONTHLY_PLAYGIRL("47", "FANZA,月額動画,プレイガール ch."),
  /** FANZA 月額動画 AVステーション */
  FANZA_MONTHLY_AVSTATION("48", "FANZA,月額動画,AVステーション"),
  /** FANZA 月額動画 ドリームチャンネル */
  FANZA_MONTHLY_DREAM("49", "FANZA,月額動画,ドリームチャンネル"),
  /** FANZA 月額動画 エスワン ナンバーワンスタイル ch */
  FANZA_MONTHLY_S1("50", "FANZA,月額動画,エスワン ナンバーワンスタイル ch"),
  /** FANZA 月額動画 MOODYZチャンネル */
  FANZA_MONTHLY_MOODYZ("51", "FANZA,月額動画,MOODYZチャンネル"),
  /** FANZA 月額動画 ソフト・オン・デマンド ch */
  FANZA_MONTHLY_SOD("52", "FANZA,月額動画,ソフト・オン・デマンド ch"),
  /** FANZA 月額動画 プレステージ ch */
  FANZA_MONTHLY_PRESTIGE("53", "FANZA,月額動画,プレステージ ch"),
  /** FANZA 月額動画 KMP チャンネル */
  FANZA_MONTHLY_KMP("54", "FANZA,月額動画,KMP チャンネル"),
  /** FANZA 月額動画 桃太郎BB */
  FANZA_MONTHLY_MOMOTAROUBB("55", "FANZA,月額動画,桃太郎BB"),
  /** FANZA 月額動画 アリスJAPAN ch */
  FANZA_MONTHLY_ALICE("56", "FANZA,月額動画,アリスJAPAN ch"),
  /** FANZA 月額動画 熟女チャンネル */
  FANZA_MONTHLY_JUKUJO("60", "FANZA,月額動画,熟女チャンネル"),
  /** FANZA 月額動画 マニア ch */
  FANZA_MONTHLY_MANIA("61", "FANZA,月額動画,マニア ch"),
  /** FANZA 月額動画 パラダイステレビ ch */
  FANZA_MONTHLY_PARADISETV("62", "FANZA,月額動画,パラダイステレビ ch"),
  /** FANZA 月額動画 素人ガールズコレクション */
  FANZA_MONTHLY_SHIROUTO("63", "FANZA,月額動画,素人ガールズコレクション"),
  /** FANZA 月額動画 ピンク映画 ch */
  FANZA_MONTHLY_NIKKATSU("64", "FANZA,月額動画,ピンク映画 ch"),
  /** FANZA 月額動画 アダルトアニメチャンネル */
  FANZA_MONTHLY_ANIMECH("65", "FANZA,月額動画,アダルトアニメチャンネル"),
  /** FANZA 月額動画 妄想族ch */
  FANZA_MONTHLY_MOUSOUZOKU("66", "FANZA,月額動画,妄想族ch"),
  /** FANZA 月額動画 見放題ch ライト */
  FANZA_MONTHLY_PRIME("67", "FANZA,月額動画,見放題ch ライト"),
  /** FANZA 月額動画 見放題ch プレミアム */
  FANZA_MONTHLY_PREMIUM("68", "FANZA,月額動画,見放題ch プレミアム"),
  /** FANZA 月額動画 HHHch */
  FANZA_MONTHLY_HHH("87", "FANZA,月額動画,HHHch"),
  /** FANZA 月額動画 VRch */
  FANZA_MONTHLY_VR("91", "FANZA,月額動画,VRch"),
  /** FANZA 10円動画 ビデオ */
  FANZA_PPM_VIDEO("69", "FANZA,10円動画,ビデオ"),
  /** FANZA 10円動画 素人 */
  FANZA_PPM_VIDEOC("70", "FANZA,10円動画,素人"),
  /** FANZA DVDレンタル 月額レンタル */
  FANZA_RENTAL_RENTAL_DVD("71", "FANZA,DVDレンタル,月額レンタル"),
  /** FANZA DVDレンタル 単品レンタル */
  FANZA_RENTAL_PPR_DVD("72", "FANZA,DVDレンタル,単品レンタル"),
  /** FANZA 通販 DVD */
  FANZA_MONO_DVD("74", "FANZA,通販,DVD"),
  /** FANZA 通販 大人のおもちゃ */
  FANZA_MONO_GOODS("75", "FANZA,通販,大人のおもちゃ"),
  /** FANZA 通販 アニメ */
  FANZA_MONO_ANIME("76", "FANZA,通販,アニメ"),
  /** FANZA 通販 PCゲーム */
  FANZA_MONO_PCGAME("77", "FANZA,通販,PCゲーム"),
  /** FANZA 通販 ブック */
  FANZA_MONO_BOOK("78", "FANZA,通販,ブック"),
  /** FANZA 通販 同人 */
  FANZA_MONO_DOUJIN("79", "FANZA,通販,同人"),
  /** FANZA アダルトPCゲーム アダルトPCゲーム */
  FANZA_PCGAME_DIGITAL_PCGAME("80", "FANZA,アダルトPCゲーム,アダルトPCゲーム"),
  /** FANZA アダルトPCゲーム 音楽 */
  FANZA_PCGAME_PCGAME_MUSIC("89", "FANZA,アダルトPCゲーム,音楽"),
  /** FANZA 同人 同人 */
  FANZA_DOUJIN_DIGITAL_DOUJIN("81", "FANZA,同人,同人"),
  /** FANZA 電子書籍 コミック */
  FANZA_EBOOK_COMIC("82", "FANZA,電子書籍,コミック"),
  /** FANZA 電子書籍 美少女ノベル・官能小説 */
  FANZA_EBOOK_NOVEL("83", "FANZA,電子書籍,美少女ノベル・官能小説"),
  /** FANZA 電子書籍 アダルト写真集・雑誌 */
  FANZA_EBOOK_PHOTO("84", "FANZA,電子書籍,アダルト写真集・雑誌");

  /** 値 */
  private String value;
  /** ラベル */
  private String label;

  /**
   * 指定された値を持つ列挙型を返却します。
   *
   * @param value 列挙型の値
   * @return 指定された値を持つ列挙型
   */
  @JsonCreator
  public static Floor of(String value) {
    return CodeEnum.of(Floor.class, value);
  }

}

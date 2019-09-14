 ## 説明
[DMM Web サービス](https://affiliate.dmm.com/api/)にて提供されているAPIを実行するためのライブラリです。  
[サンプルプロジェクト](https://github.com/r-fujiyama/dmm-java-sdk-sample)を用意しています。  
[DMM APIご利用申請](https://affiliate.dmm.com/api/)が済みの方は、[サンプルプロジェクト](https://github.com/r-fujiyama/dmm-java-sdk-sample)をクローンしてください。  
速やかにライブラリを体験していただくことができます。

## 使用方法
以下の内容を`build.gradle`に追記することで使用可能になります。
```gradle
repositories {
  maven {
    url 'https://r-fujiyama.github.io/maven-repository'
  }
}

dependencies {
  implementation group: 'com.sdk.java.dmm', name: 'dmm-java-sdk', version: '1.0.0'
}
```
 
 ## ドキュメント
 [Javadoc](https://r-fujiyama.github.io/dmm-java-sdk/)を用意していますので、是非ご参考ください。

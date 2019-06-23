# DMM JAVA SDK の使用方法
## 1.dmm.propertiesの設定
1. [DMM公式サイト](https://affiliate.dmm.com/api/)でwebサービス利用登録を行う。
1. 発行される「**API ID**」「**アフェリエイトID**」を下記のように設定する。
    - dmm.properties
      - API_ID=発行されたAPI ID
      - AFFILIATE_ID=発行されたアフェリエイトID  
 
 ## 2.jarの生成
 1. Windowsであれば「**gradlew.bat**」Linuxであれば「**gradlew**」を実行し、gradle実行環境を作成する。
 1. プロジェクトのカレントディレクトリで`./gradlew build`コマンドを実行する。
 1. `build\libs`配下に「**jar**」が生成されます。
 1. 「**jar**」を依存関係に追加しご使用ください。
 
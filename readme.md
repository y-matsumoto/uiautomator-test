# utility

## 詳細

uiautomatorのutility
サンプルコードとしてtest/test.javaで実装

テストコード詳細（仮アプリがあるとしてテスト実装）
-------
1. 指定のパッケージ名のアプリが起動するまで待ち起動後にキャプチャ
2. 表示されるダイアログのＯＫボタンをクリック
3. 次に表示されるActivityのキャプチャ
4. バックボタンでActivityを閉じる

### ※テストコード実施までの準備
AppConst.javaのTARGET_PKGに対象のアプリのパッケージ名をいれること

## ビルド
プロジェクト直下でコマンドを実行する

    $ ant build
ビルドしてUiautomator.jarがbinに作成される

## jarファイルをエミュレータまたは実機に設置
data/local/tmp直下にuiautomatorを設置する

## 実行
エミュレータまたは実機を起動し接続した状態でコマンドを実行する

    $ adb shell Uiautomator runtest Uiautomator.jar -c test.test

これでエミュレータまたは実機上で指定のアプリを起動すると続きはテストコードで自動に実施される

## キャプチャデータ
キャプチャされたデータはAppConst.javaで指定した場所に保存される

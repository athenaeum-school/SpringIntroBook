SpringIntroBook
===============

LibraryApplication起動方法
------
* SpringIntroBook/Ch4/SpringBoot/LibraryApplicationをダウンロード
* アプリケーションを起動

#### 【STSの場合】

```sts
<Run> ⇒ <Run As> ⇒ <Spring Boot App>
```

#### 【gradleの場合】

```gradle
% gradle bootRun
```

#### 【javaコマンドの場合】
```java
% java -jar build/libs/LibraryApplication-0.0.1-SNAPSHOT.jar
```

* SpringIntroBook/Ch5/LibraryApplicationをダウンロード
* index.htmlをブラウザで開く

amqpApplication起動方法
------
* SpringIntroBook/Ch5/amqpをダウンロード
* mongoDBを起動

```mongoDb
% mongod
```

* サーバーを起動(別のコマンドプロンプト）

```node
% node server.js
```

* サーバーにアクセス

[http://localhost:9100](http://localhost:9100)

lombok導入手順
------
* [http://projectlombok.org/](http://projectlombok.org/)のサイトよりLombok.jarをダウンロード
* lombok.jarをダブルクリックし、インストーラを起動
* 現在使用しているEclipseを選択して、「Install / Update」ボタンをクリック

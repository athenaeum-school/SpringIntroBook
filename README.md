SpringIntroBook
===============

Springで作るEnterprise RESTアプリケーション
------
* 出版ステータス：入稿済み

#### 目次
本書の目的	5
はじめに	5
開発環境	8
Spring Tools Suite (STS)	8
Enterprise Javaの紹介	9
Layersパターン	12
J2EEデザインパターン	13
サンプルアプリケーション	13
DomainとRepository	14
Domainとは	14
Domainの実装	15
Domain Modelの設計	18
テーブル間の関係の設計	19
JPA (Java Persistence API)の活用	20
Hibernateの活用	25
SessionFactory実装の手順	25
Hibernate実装の抽象化	28
Spring Data JPA	31
サービスレイヤーと機能設計	33
サービスレイヤーとデザインパターン	33
サービスオブジェクトの実装	33
Data Transfer Objectパターン	36
監査機能	37
メソッドレベル・アクセスコントロール	39
REST	42
Lombok導入手順	42
CORSフィルターの追加	42
RESTの実装手順	44
Hateoasの実装手順	58
プレゼンテーション	59
サンプルアプリケーション（図書館サービス）の要件	59
Node.js導入手順	59
Bower の設定	60
Backbone.jsを活用したWebフォーム	60
ユーザーインターフェース	61
Backboneモデル	64
Backbone View	66
Backboneルーター	71
EIPとRabbitMQの組み込み	74
Enterprise Integration Patterns	74
RabbitMQ導入手順	74
Brokerアーキテクチャーパターン	76
Service Activator パターン	77
Spring Integrationsの実装	78
Node.jsの実装	80
MultithreadとThread Safety	87
Thread Safetyとは	87
Scope	87
Entity Bean	89
DAOとTransaction	89
Gradleプロジェクト作成手順	91

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

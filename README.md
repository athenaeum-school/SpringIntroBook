SpringIntroBook
===============

LibraryApplication起動方法
------
1. SpringIntroBook/Ch4/SpringBoot/LibraryApplicationをダウンロード
2. アプリケーションを起動

####【STSの場合】

```sts
<Run> ⇒ <Run As> ⇒ <Spring Boot App>
```

#### 【gradleの場合】

```gradle
% gradle bootRun
```

####【javaコマンドの場合】
```java
% java -jar build/libs/LibraryApplication-0.0.1-SNAPSHOT.jar
```

3. SpringIntroBook/Ch5/LibraryApplicationをダウンロード
4. index.htmlをブラウザで開く

amqpApplication起動方法
------
1. SpringIntroBook/Ch5/amqpをダウンロード
2. mongoDBを起動
```mongoDb
% mongod
```
3. サーバーを起動(別のコマンドプロンプト）
```node
% node server.js
```
4. サーバーにアクセス
```server
% http://localhost:9100/
```

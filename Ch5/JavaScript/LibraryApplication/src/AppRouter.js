var AppRouter = Backbone.Router.extend({

  routes : {
    //全件表示ボタンをクリック
    '': 'render',
    //検索ボタンをクリック
    'search/:name': 'searchBook',
    //ページ番号をクリック
    'search/:name/page/:number': 'pagination'
  },

  initialize : function() {
    App.pageable = new Pageable();
    App.appView = new App.BookListView();
  },

  render : function() {
    //全件表示ボタンをクリックしたらページ番号を0・検索文字列は空文字にセット
    App.pageable.set({
      search: '',
      page: 0
    }, {
      silent: true
    });
    //ブック検索の入力値を消去
    $('#title').val('');
    //検索結果を消去
    $('#resultSearch span').text('');
    //全件取得
    App.pageable.fetch();
  },

  searchBook : function(name) {
    //検索結果に検索文字列を描画
    $('#resultSearch span').text(name);
    App.pageable.set({
      search: name,
      page: 0
    }, {
      silent: true
    });
    //検索情報を取得
    App.pageable.fetch();
  },

  pagination : function(name, number) {
    //ページ番号を文字列から数値に変換
    var a = Number(number - 1);
    if (name === 'All') {
      name = '';
    }
    //検索結果に検索文字列を描画
    $('#resultSearch span').text(name);
    App.pageable.set({
      search: name,
      page: a
    }, {
      silent: true
    });
    //ページを変更して情報を取得
    App.pageable.fetch();
  }
});

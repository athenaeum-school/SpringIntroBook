var App = {};

App.BookListView = Backbone.View.extend({

  el : '#bookApp',

  events : {
    //ページ番号をクリック
    'click #pagination': 'pagination',
    //検索ボタンをクリック
    'click #search': 'searchBook',
    //全件表示ボタンをクリック
    'click #allBook': 'allBook'
  },

  initialize : function() {
    console.log('initialize');
    this.$title = this.$('#title');
    //モデルがfetchするのを監視して再描画をする。
    this.listenTo(App.pageable, 'change', this.render);

  },

  render : function() {
    console.log('changeイベント');
    $('#bookList tbody tr').remove();
    //Bookクラスの情報を取得
    this.bookCollection = App.pageable.get('content');
    this.bookCollection.each(function(item) {
      return this.renderBook(item);
    }, this);
    //ページを描画
    this.footerRender();
    return this;
  },

  renderBook : function(item) {
    item.set({
      //数値を３桁区切りに変換
      price: item.get('price').toLocaleString()
    });
    var bookView = new BookView({
      model: item
    });
    //ブックのタイトル・価格を描画
    $('#bookList tbody').append((bookView.render().$el).children());
    //Authorクラスの情報を取得
    this.author = item.get('authors');
    if (this.author.length === 2) {
      this.author.each(function(item2) {
        var authorView = new AuthorView({
          model: item2
        });
        //著者名を描画
        $('tbody').append(authorView.render().el);
      });
      //著者名が１人の場合は空TDタグを描画
    } else {
      authorView = new AuthorView({
        model: this.author.at(0)
      });
      $('tbody').append(authorView.render().el).append('<td></td>');
    }
    //ブック情報と著者名情報をtrタグでラップ
    $(' tbody > td').wrapAll('<tr></tr>');
  },

  pagination : function(e) {
    console.log('ページネーション');
    e.preventDefault();
    //クリックされたページ番号を取得
    this.page = $(e.target).text();
    //検索文字をpageableModelから取得
    var name = App.pageable.get('search');
    if (name === '') {
      name = 'All';
    }
    //検索文字とページ番号を入力してURLを変更
    Backbone.history.navigate('search/' + name + '/page/' + this.page, {
      trigger: true
    });
  },

  searchBook : function(e) {
    console.log('サーチイベント');
    e.preventDefault();
    //ブック検索から検索文字列を取得してURLを変更
    Backbone.history.navigate('search/' + this.$title.val(), {
      trigger: true
    });
  },

  allBook : function(e) {
    console.log('allbook');
    e.preventDefault();
    //URLを変更
    Backbone.history.navigate('', {
      trigger: true
    });
  },

  footerRender : function() {
    console.log('フッター');
    //ページ番後を全て削除
    $('#pagination li').remove();
    //トータルページ数を取得
    this.totalPages = App.pageable.get('totalPages');
    if (this.totalPages !== 0) {
      for (var i = 1; i < this.totalPages + 1;i++){
        //ページ番号を描画
        $('#pagination').append("<li><a href='#'>" + i + "</a></li>");
      }
    }
    var page = App.pageable.get('page');
    //クリックされたページ番号をactiveにする
    $("#pagination li:eq(" + page + ")").addClass('active');
  }
});

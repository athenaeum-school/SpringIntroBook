var Pageable = Backbone.RelationalModel.extend({

urlRoot : function() {
    //ページサイズとページ番号と検索文字列を入力して情報を取得
    var page, search;
    page = this.get('page');
    search = this.get('search');
    return "http://localhost:8080/as/books?size=3&page=" +
    page + "&search=" + search;
  },

  defaults : function() {
    return {
      page: 0,
      search: ''
    };
  },

  relations : [
    {
      type: Backbone.HasMany,
      key: 'content',
      relatedModel: 'Book',
      collectionType: 'BookCollection',
    }
  ]

});

var Book = Backbone.RelationalModel.extend({

  idAttribute : 'bookId',

  relations : [
    {
      type: Backbone.HasMany,
      key: 'authors',
      relatedModel: 'Author',
      collectionType: 'AuthorCollection',
    }
  ]

});

var Author = Backbone.RelationalModel.extend({

  idAttribute : 'authorId'

});


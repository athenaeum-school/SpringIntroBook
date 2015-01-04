var App,
  __hasProp = {}.hasOwnProperty,
  __extends = function(child, parent) { for (var key in parent) { if (__hasProp.call(parent, key)) child[key] = parent[key]; } function ctor() { this.constructor = child; } ctor.prototype = parent.prototype; child.prototype = new ctor(); child.__super__ = parent.prototype; return child; };

App = {};

App.BookListView = (function(_super) {
  __extends(BookListView, _super);

  function BookListView() {
    return BookListView.__super__.constructor.apply(this, arguments);
  }

  BookListView.prototype.el = '#bookApp';

  BookListView.prototype.events = {
    'click #pagination': 'pagination',
    'click #search': 'searchBook',
    'click #allBook': 'allBook'
  };

  BookListView.prototype.initialize = function() {
    console.log('initialize');
    this.$title = this.$('#title');

    /*App.pageable.fetch() */
    return this.listenTo(App.pageable, 'change', this.render);

    /*@listenTo App.pageable, 'change', @footerRender */
  };

  BookListView.prototype.render = function() {
    console.log('changeイベント');
    $('#bookList tbody tr').remove();
    this.Bookcollection = App.pageable.get('content');
    this.Bookcollection.each(function(item) {
      return this.renderBook(item);
    }, this);
    this.footerRender();
    return this;
  };

  BookListView.prototype.renderBook = function(item) {
    var authorView, bookView;
    item.set({
      price: item.get('price').toLocaleString()
    });
    bookView = new BookView({
      model: item
    });
    $('#bookList tbody').append((bookView.render().$el).children());
    this.author = item.get('authors');
    if (this.author.length === 2) {
      this.author.each(function(item2) {
        var authorView;
        authorView = new AuthorView({
          model: item2
        });
        return $('tbody').append(authorView.render().el);
      });
    } else {
      authorView = new AuthorView({
        model: this.author.at(0)
      });
      $('tbody').append(authorView.render().el).append('<td></td>');
    }
    return $(' tbody > td').wrapAll('<tr></tr>');
  };

  BookListView.prototype.pagination = function(e) {
    var name;
    console.log('ページネーション');
    e.preventDefault();
    this.page = $(e.target).text();
    name = App.pageable.get('search');
    if (name === '') {
      name = 'All';
    }
    return Backbone.history.navigate('search/' + name + '/page/' + this.page, {
      trigger: true
    });
  };

  BookListView.prototype.searchBook = function(e) {
    console.log('サーチイベント');
    e.preventDefault();
    return Backbone.history.navigate('search/' + this.$title.val(), {
      trigger: true
    });
  };

  BookListView.prototype.allBook = function(e) {
    console.log('allbook');
    e.preventDefault();
    return Backbone.history.navigate('', {
      trigger: true
    });
  };

  BookListView.prototype.footerRender = function() {
    var i, page, _i, _ref;
    console.log('フッター');
    $('#pagination li').remove();
    this.totalPages = App.pageable.get('totalPages');
    if (this.totalPages !== 0) {
      for (i = _i = 1, _ref = this.totalPages; 1 <= _ref ? _i <= _ref : _i >= _ref; i = 1 <= _ref ? ++_i : --_i) {
        $('#pagination').append("<li><a href='#'>" + i + "</a></li>");
      }
    }
    page = App.pageable.get('page');
    return $("#pagination li:eq(" + page + ")").addClass('active');
  };

  return BookListView;

})(Backbone.View);

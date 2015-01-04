var Author, Book, Pageable,
  __hasProp = {}.hasOwnProperty,
  __extends = function(child, parent) { for (var key in parent) { if (__hasProp.call(parent, key)) child[key] = parent[key]; } function ctor() { this.constructor = child; } ctor.prototype = parent.prototype; child.prototype = new ctor(); child.__super__ = parent.prototype; return child; };

Pageable = (function(_super) {
  __extends(Pageable, _super);

  function Pageable() {
    return Pageable.__super__.constructor.apply(this, arguments);
  }

  Pageable.prototype.urlRoot = function() {
    var page, search;
    page = this.get('page');
    search = this.get('search');
    return "http://localhost:8080/as/books?size=3&page=" + page + "&search=" + search;
  };

  Pageable.prototype.defaults = function() {
    return {
      page: 0,
      search: ''
    };
  };

  Pageable.prototype.relations = [
    {
      type: Backbone.HasMany,
      key: 'content',
      relatedModel: 'Book',
      collectionType: 'BookCollection',
      includeInJSON: Backbone.Model.prototype.bookId
    }
  ];

  return Pageable;

})(Backbone.RelationalModel);

Pageable.setup();

Book = (function(_super) {
  __extends(Book, _super);

  function Book() {
    return Book.__super__.constructor.apply(this, arguments);
  }

  Book.prototype.idAttribute = 'bookId';

  Book.prototype.relations = [
    {
      type: Backbone.HasMany,
      key: 'authors',
      relatedModel: 'Author',
      collectionType: 'AuthorCollection',
      includeInJSON: Backbone.Model.prototype.authorId
    }
  ];

  return Book;

})(Backbone.RelationalModel);

Book.setup();

Author = (function(_super) {
  __extends(Author, _super);

  function Author() {
    return Author.__super__.constructor.apply(this, arguments);
  }

  Author.prototype.idAttribute = 'authorId';

  return Author;

})(Backbone.RelationalModel);

Author.setup();

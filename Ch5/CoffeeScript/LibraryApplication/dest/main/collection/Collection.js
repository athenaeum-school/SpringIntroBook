var AuthorCollection, BookCollection,
  __hasProp = {}.hasOwnProperty,
  __extends = function(child, parent) { for (var key in parent) { if (__hasProp.call(parent, key)) child[key] = parent[key]; } function ctor() { this.constructor = child; } ctor.prototype = parent.prototype; child.prototype = new ctor(); child.__super__ = parent.prototype; return child; };

BookCollection = (function(_super) {
  __extends(BookCollection, _super);

  function BookCollection() {
    return BookCollection.__super__.constructor.apply(this, arguments);
  }

  BookCollection.prototype.model = Book;

  return BookCollection;

})(Backbone.Collection);

AuthorCollection = (function(_super) {
  __extends(AuthorCollection, _super);

  function AuthorCollection() {
    return AuthorCollection.__super__.constructor.apply(this, arguments);
  }

  AuthorCollection.prototype.model = Author;

  return AuthorCollection;

})(Backbone.Collection);

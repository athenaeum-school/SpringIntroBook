var BlogCollection,
  __hasProp = {}.hasOwnProperty,
  __extends = function(child, parent) { for (var key in parent) { if (__hasProp.call(parent, key)) child[key] = parent[key]; } function ctor() { this.constructor = child; } ctor.prototype = parent.prototype; child.prototype = new ctor(); child.__super__ = parent.prototype; return child; };

BlogCollection = (function(_super) {
  __extends(BlogCollection, _super);

  function BlogCollection() {
    return BlogCollection.__super__.constructor.apply(this, arguments);
  }

  BlogCollection.prototype.model = Blog;

  BlogCollection.prototype.url = 'http://localhost:9100/api/blogs';

  return BlogCollection;

})(Backbone.Collection);

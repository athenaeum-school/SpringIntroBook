var Blog,
  __hasProp = {}.hasOwnProperty,
  __extends = function(child, parent) { for (var key in parent) { if (__hasProp.call(parent, key)) child[key] = parent[key]; } function ctor() { this.constructor = child; } ctor.prototype = parent.prototype; child.prototype = new ctor(); child.__super__ = parent.prototype; return child; };

Blog = (function(_super) {
  __extends(Blog, _super);

  function Blog() {
    return Blog.__super__.constructor.apply(this, arguments);
  }

  Blog.prototype.idAttribute = '_id';

  Blog.prototype.defaults = {
    title: '',
    message: 'なし'
  };

  return Blog;

})(Backbone.Model);

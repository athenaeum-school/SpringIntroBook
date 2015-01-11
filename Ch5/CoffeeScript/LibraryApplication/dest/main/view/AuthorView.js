var AuthorView,
  __hasProp = {}.hasOwnProperty,
  __extends = function(child, parent) { for (var key in parent) { if (__hasProp.call(parent, key)) child[key] = parent[key]; } function ctor() { this.constructor = child; } ctor.prototype = parent.prototype; child.prototype = new ctor(); child.__super__ = parent.prototype; return child; };

AuthorView = (function(_super) {
  __extends(AuthorView, _super);

  function AuthorView() {
    return AuthorView.__super__.constructor.apply(this, arguments);
  }

  AuthorView.prototype.tagName = 'td';

  AuthorView.prototype.template = _.template($('#authortemplate').html());

  AuthorView.prototype.render = function() {
    this.$el.html(this.template(this.model.toJSON()));
    return this;
  };

  return AuthorView;

})(Backbone.View);

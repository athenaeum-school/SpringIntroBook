var BookView,
  __hasProp = {}.hasOwnProperty,
  __extends = function(child, parent) { for (var key in parent) { if (__hasProp.call(parent, key)) child[key] = parent[key]; } function ctor() { this.constructor = child; } ctor.prototype = parent.prototype; child.prototype = new ctor(); child.__super__ = parent.prototype; return child; };

BookView = (function(_super) {
  __extends(BookView, _super);

  function BookView() {
    return BookView.__super__.constructor.apply(this, arguments);
  }

  BookView.prototype.template = _.template($('#booktemplate').html());

  BookView.prototype.render = function() {
    this.$el.html(this.template(this.model.toJSON()));
    return this;
  };

  return BookView;

})(Backbone.View);

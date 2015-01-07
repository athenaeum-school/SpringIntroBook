var BlogView,
  __hasProp = {}.hasOwnProperty,
  __extends = function(child, parent) { for (var key in parent) { if (__hasProp.call(parent, key)) child[key] = parent[key]; } function ctor() { this.constructor = child; } ctor.prototype = parent.prototype; child.prototype = new ctor(); child.__super__ = parent.prototype; return child; };

BlogView = (function(_super) {
  __extends(BlogView, _super);

  function BlogView() {
    return BlogView.__super__.constructor.apply(this, arguments);
  }

  BlogView.prototype.tagName = 'div';

  BlogView.prototype.className = 'blogContainer';

  BlogView.prototype.template = _.template($('#blogtemplate').html());

  BlogView.prototype.events = {
    'click .delete': 'deleteBlog',
    'dblclick .view': 'edit',
    'click .editbutton': 'edit',
    'click [name="save"]': 'saveBlog',
    'click [name="cancel"]': 'close'
  };

  BlogView.prototype.initialize = function() {
    this.listenTo(this.model, 'destroy', this.remove);
    return this.listenTo(this.model, 'change', this.render);
  };

  BlogView.prototype.render = function() {
    this.$el.html(this.template(this.model.toJSON()));
    this.$title = this.$('[name="title"]');
    this.$message = this.$('[name="message"]');
    return this;
  };

  BlogView.prototype.deleteBlog = function(e) {
    e.preventDefault();
    return this.model.destroy();
  };

  BlogView.prototype.edit = function() {
    this.$el.addClass('editing');
    return this.$title.focus();
  };

  BlogView.prototype.saveBlog = function(e) {
    e.preventDefault();
    this.model.save({
      title: this.$title.val(),
      message: this.$message.val()
    });
    return this.close();
  };

  BlogView.prototype.close = function() {
    return this.$el.removeClass('editing');
  };

  return BlogView;

})(Backbone.View);

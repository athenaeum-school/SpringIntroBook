var AuthorView = Backbone.View.extend({

  tagName : 'td',

  template : _.template($('#authortemplate').html()),

  render : function() {
    this.$el.html(this.template(this.model.toJSON()));
    return this;
  }

});

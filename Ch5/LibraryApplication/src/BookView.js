var BookView = Backbone.View.extend({

  template : _.template($('#booktemplate').html()),

  render : function() {
    this.$el.html(this.template(this.model.toJSON()));
    return this;
  }

});

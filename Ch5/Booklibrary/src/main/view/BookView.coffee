class BookView extends Backbone.View
	
	template: _.template($('#booktemplate').html())

	render: ->
		@$el.html @template @model.toJSON()
		@


class AuthorView extends Backbone.View
	tagName: 'td'
	template: _.template($('#authortemplate').html())

	render: ->
		@$el.html @template @model.toJSON()
		@

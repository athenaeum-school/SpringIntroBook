App = {}

class App.BookListView extends Backbone.View
	el: '#bookApp'

	events:
		'click #pagination':'pagination'
		'click #search': 'searchBook'
		'click #allBook': 'allBook'

	initialize: ->
		console.log 'initialize'
		@$title = @$ '#title'
		
		@listenTo App.pageable, 'change', @render

	render: ->
		console.log 'changeイベント'
		$('#bookList tbody tr').remove()
		@Bookcollection = App.pageable.get 'content'
		@Bookcollection.each (item) ->
			@renderBook item
		,@
		@footerRender()
		@

	renderBook: (item) ->
		item.set
			price: item.get('price').toLocaleString()
		bookView = new BookView
			model: item
		$('#bookList tbody').append((bookView.render().$el).children())
		@author = item.get 'authors'
		if @author.length is 2
			@author.each (item2) ->
				authorView = new AuthorView
					model: item2
				$('tbody').append authorView.render().el
		else 
			authorView = new AuthorView
				model:@author.at 0
			$('tbody').append(authorView.render().el).append '<td></td>'
		$(' tbody > td').wrapAll('<tr></tr>')

	pagination: (e) ->
		console.log 'ページネーション'
		e.preventDefault()
		@page = $(e.target).text() 
		name = App.pageable.get 'search'
		if name is ''
			name = 'All'
		Backbone.history.navigate 'search/' + name + '/page/' + @page
		,trigger: true

	searchBook: (e) ->
		console.log 'サーチイベント'
		e.preventDefault()
		Backbone.history.navigate 'search/' + @$title.val()
		,trigger: true

	allBook: (e) ->
		console.log 'allbook'
		e.preventDefault()
		Backbone.history.navigate ''
		,trigger: true

	footerRender: ->
		console.log 'フッター'
		$('#pagination li').remove()
		@totalPages = App.pageable.get 'totalPages'
		if @totalPages isnt 0
			for i in [1..@totalPages]
				$('#pagination').append "<li><a href='#'>#{i}</a></li>"
		page = App.pageable.get('page')
		$("#pagination li:eq(#{page})").addClass 'active'




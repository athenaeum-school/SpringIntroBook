class AppRouter extends Backbone.Router
	routes:
		'': 'render'
		'search/:name': 'searchBook'
		'search/:name/page/:number': 'pagination'

	initialize: ->
		App.pageable = new Pageable()
		App.appView = new App.BookListView()

	render: ->
		App.pageable.set
			search: '',page: 0
		,silent: true
		$('#title').val ''
		$('#resultSearch span').text ''
		App.pageable.fetch()

	searchBook: (name) ->
		$('#resultSearch span').text name
		App.pageable.set
			search: name,page: 0
		,silent:true
		App.pageable.fetch()

	pagination: (name,number) ->
		
		a = Number number - 1
		if name is 'All'
			name = ''
		$('#pagination .active').removeClass 'active'
		$("#pagination li:eq(#{a})").addClass 'active'
		$('#resultSearch span').text name
		App.pageable.set 
			search: name
			page: a
		,silent: true
		App.pageable.fetch()
				



class Pageable extends Backbone.RelationalModel
	urlRoot: () ->
		page = @get 'page'
		search = @get 'search'
		"http://localhost:8080/as/books?size=3&page=#{page}&search=#{search}"
		
	defaults: ->
		page: 0
		search: ''

	relations: [
		type: Backbone.HasMany
		key: 'content'
		relatedModel: 'Book'
		collectionType: 'BookCollection'
		includeInJSON: Backbone.Model.prototype.bookId
	]
	
Pageable.setup()

class Book extends Backbone.RelationalModel
	idAttribute: 'bookId'
	relations: [
		type: Backbone.HasMany
		key: 'authors'
		relatedModel: 'Author'
		collectionType: 'AuthorCollection'
		includeInJSON: Backbone.Model.prototype.authorId
	]


Book.setup()

class Author extends Backbone.RelationalModel
	idAttribute: 'authorId'
Author.setup()
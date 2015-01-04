var AppRouter,
  __hasProp = {}.hasOwnProperty,
  __extends = function(child, parent) { for (var key in parent) { if (__hasProp.call(parent, key)) child[key] = parent[key]; } function ctor() { this.constructor = child; } ctor.prototype = parent.prototype; child.prototype = new ctor(); child.__super__ = parent.prototype; return child; };

AppRouter = (function(_super) {
  __extends(AppRouter, _super);

  function AppRouter() {
    return AppRouter.__super__.constructor.apply(this, arguments);
  }

  AppRouter.prototype.routes = {
    '': 'render',
    'search/:name': 'searchBook',
    'search/:name/page/:number': 'pagination'
  };

  AppRouter.prototype.initialize = function() {
    App.pageable = new Pageable();
    return App.appView = new App.BookListView();
  };

  AppRouter.prototype.render = function() {
    App.pageable.set({
      search: '',
      page: 0
    }, {
      silent: true
    });
    $('#title').val('');
    $('#resultSearch span').text('');
    return App.pageable.fetch();
  };

  AppRouter.prototype.searchBook = function(name) {
    $('#resultSearch span').text(name);
    App.pageable.set({
      search: name,
      page: 0
    }, {
      silent: true
    });
    return App.pageable.fetch();
  };

  AppRouter.prototype.pagination = function(name, number) {
    var a;
    a = Number(number - 1);
    if (name === 'All') {
      name = '';
    }
    $('#pagination .active').removeClass('active');
    $("#pagination li:eq(" + a + ")").addClass('active');
    $('#resultSearch span').text(name);
    App.pageable.set({
      search: name,
      page: a
    }, {
      silent: true
    });
    return App.pageable.fetch();
  };

  return AppRouter;

})(Backbone.Router);

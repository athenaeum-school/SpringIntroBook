var Blog, BlogModel, allowCrossDomain, amqp, app, application_root, express, mongoose, path, port, when1;

application_root = __dirname;

express = require('express');

path = require('path');

mongoose = require('mongoose');

app = express();

amqp = require('amqplib');

when1 = require('when');

allowCrossDomain = function(req, res, next) {
  res.header('Access-Control-Allow-Origin', '*');
  res.header('Access-Control-Allow-Methods', 'GET,PUT,POST,DELETE');
  res.header('Access-Control-Allow-Headers', 'Content-Type, Authorization');
  if ('OPTIONS' === req.method) {
    return res.send(200);
  } else {
    return next();
  }
};

app.use(allowCrossDomain);

app.configure(function() {
  app.use(express.bodyParser());
  app.use(express.methodOverride());
  app.use(app.router);
  app.use(express["static"](path.join(application_root, '/')));
  return app.use(express.errorHandler({
    dumpException: true,
    showStack: true
  }));
});

mongoose.connect('mongodb://localhost/VeggieMarket_blog');

Blog = new mongoose.Schema({
  title: String,
  message: String
});

BlogModel = mongoose.model('blog', Blog);

app.get('/api/blogs', function(request, response) {
  return BlogModel.find(function(err, blogs) {
    if (!err) {
      return response.send(blogs);
    } else {
      return console.log(err);
    }
  });
});

app.get('/api/blogs/:id', function(request, response) {
  return BlogModel.findById(request.params.id, function(err, blog) {
    if (!err) {
      return response.send(blog);
    } else {
      return console.log(err);
    }
  });
});

app.post('/api/blogs', function(request, response) {
  var blog;
  blog = new BlogModel({
    title: request.body.title,
    message: request.body.message
  });
  amqp.connect('amqp://localhost').then(function(conn) {
    return when1(conn.createChannel().then(function(ch) {
      var msg, ok, q;
      q = 'blog';
      msg = JSON.stringify(blog);
      ok = ch.assertQueue(q, {
        durable: false
      });
      return ok.then(function(_qok) {
        ch.sendToQueue(q, new Buffer(msg));
        console.log(" [x] Sent '%s'", msg);
        return ch.close();
      });
    })).ensure(function() {
      return conn.close();
    });
  }).then(null, console.warn);
  blog.save(function(err) {
    if (!err) {
      return console.log('追加されました。');
    } else {
      return console.log(err);
    }
  });
  return response.send(blog);
});

app.put('/api/blogs/:id', function(request, response) {
  console.log('更新します。: ' + request.body.title);
  return BlogModel.findById(request.params.id, function(err, blog) {
    blog.title = request.body.title;
    blog.message = request.body.message;
    return blog.save(function(err) {
      if (!err) {
        console.log('更新されました。');
      } else {
        console.log(err);
      }
      return response.send(blog);
    });
  });
});

app["delete"]('/api/blogs/:id', function(request, response) {
  console.log("削除するブログのID: " + request.params.id);
  return BlogModel.findById(request.params.id, function(err, blog) {
    return blog.remove(function(err) {
      if (!err) {
        return console.log('ブログが削除されました。');
      } else {
        return console.log(err);
      }
    });
  });
});

port = 9100;

app.listen(port, function() {
  return console.log("Expressサーバーがポート" + port + "で起動しました。モード:" + app.settings.env);
});

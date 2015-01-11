module.exports = (grunt) ->
	grunt.initConfig
		clean:
			deleteDir:
				src: 'dest/'
		watch:
			options:
				livereload: true
			html:
				tasks: ''
				files: 'dest/**/*.html'
			coffee:
				tasks: 'coffee'
				files: [
					'src/**/*.coffee'
					'server.coffee'
				]
			jade:
				tasks: 'jade'
				files: 'src/**/*.jade'
			sass:
				tasks: 'compass'
				files: 'src/**/*.sass'
			css:
				tasks: ''
				files: 'dest/css/*.css'
			js:
				tasks: ''
				files: 'dest/**/*.js'
			copy:
				tasks: 'copy'
				files: 'src/**/*.png'

		copy:
			files:
				expand: true
				cwd: 'src'
				src: '**/*.png'
				dest: 'dest/'

		connect:
			server:
				options:
					port: 9000

		coffee:
			compile:
				options:
					bare: true
				files:[
					expand: true
					cwd: 'src/'
					src: '**/*.coffee'
					dest:'dest/'
					ext: '.js'
				]
			server:
				options:
					bare: true
				files:[
					expand: true
					cwd: ''
					src: 'server.coffee'
					dest:''
					ext: '.js'
					]	
		jade:
			options:
				pretty: true
			source:
				expand: true
				cwd: 'src/'
				src:[
					'main/**/*.jade'
					'test/**/*.jade'
					'!**/_*.jade'
				]
				dest: 'dest/'
				ext: '.html'

		compass:
			dist:
				options:
					config: 'config.rb'
					force: true

	grunt.loadNpmTasks 'grunt-contrib-coffee'
	grunt.loadNpmTasks 'grunt-contrib-watch'
	grunt.loadNpmTasks 'grunt-contrib-connect'
	grunt.loadNpmTasks 'grunt-contrib-jade'	
	grunt.loadNpmTasks 'grunt-contrib-compass'
	grunt.loadNpmTasks 'grunt-contrib-clean'
	grunt.loadNpmTasks 'grunt-contrib-copy'
	grunt.registerTask 'default', ['connect','watch']
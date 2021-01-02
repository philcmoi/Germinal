var http = require('http');
var crypto = require('crypto'); 

httpServer = http.createServer(function(req, res){
	console.log('Un utilisateur a affiche la page');
});

httpServer.listen(1337);

var io = require('socket.io').listen(httpServer);
var users = {};
var messages = [];
var history = 2;

io.sockets.on('connection', function(socket){

	var me = false;
	console.log('Nouveau utilisateur');

	for(var k in users){
		socket.emit('newusr', users[k]);
	}
	for(var k in messages){
		socket.emit('newmsg', messages[k]);
	}

	/**
	* On a reçu un message
	**/
	socket.on('newmsg', function(message){
		// Si le message est vide on ne fait rien
		if(message == ''){
			return false;
		}
		message.user = me;
		date = new Date();
		message.h = date.getHours();
		message.m = date.getMinutes();
		messages.push(message);
		if(messages.length > history){
			messages.shift();
		}
		io.sockets.emit('newmsg', message);
	});

	/**
	* Je me connecte
	**/
	socket.on('login', function(user){
		me = user;
		me.id = crypto.createHash('md5').update(user.mail)
		me.avatar = 'https://gravatar.com/avatar/' + crypto.createHash('md5').update(user.mail).digest('hex') + '?s=50'
		me.mail = null; 		// On ne renvoit pas l'email publiquement
		socket.emit('logged');
		users[me.id] = me;
		io.sockets.emit('newusr', me);
	});

	/**
	* Je quitte le tchat
	**/
	socket.on('disconnect', function(){
		if(!me){
			return false;
		}
		delete users[me.id];
		io.sockets.emit('disusr', me);
	})

});

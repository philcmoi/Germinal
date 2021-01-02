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
	
	

	/**
	* Je me connecte
	**/
	
	
		users[me.id]== crypto.createHash('md5').update(user.mail);;
	

	/**
	* Je quitte le tchat
	**/
	

});

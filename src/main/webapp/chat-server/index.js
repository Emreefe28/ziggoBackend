let express = require('express')
let app = express();

let http = require('http');
let server = http.Server(app);

let socketIO = require('socket.io');
let io = socketIO(server);

const port = process.env.PORT || 3000;
var employees = [];

io.on('connection', (socket) => {
    console.log('user connected');


    socket.on('new-message', (message) => {
        io.sockets.in(message.room).emit('new-message', message);
        console.log(message.room)
    });

    socket.on('create', function (room) {
        socket.join(room);
        console.log(`user created  room ` + room);
    });

    socket.on('join', function (room) {
        socket.join(room);
        console.log(io.sockets.clients().toString() + ` joined room ` + room);
    });

});

server.listen(port, () => {
    console.log(`started on port: ${port}`);
});

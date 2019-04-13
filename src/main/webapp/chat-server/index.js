let express = require('express');
let app = express();

let http = require('http');
let server = http.Server(app);

let socketIO = require('socket.io');
let io = socketIO(server);

const port = 3000;
var employees = [];
var orderIndex = 0;

io.on('connection', (socket) => {
    console.log('user connected');

    socket.on('login', (user) => {
        console.log('User logged in');
        user.socketId = socket.id;
        if (employees.length === 0) {
            employees.push(user);
        } else {
            let match = false;
            for (let i = 0; i < employees.length; i++) {
                console.log('EMPLOYEE: ' + employees[i].username);
                if (user.username === employees[i].username) {
                    match = true;
                }
            }
            if (!match) {
                employees.push(user);
            }
        }
        console.log('Employee size: ' + employees.length);
    });

    socket.on('logout', (user) => {
        console.log('User logged out');
        let match = false;
        let index;
        for (let i = 0; i < employees.length; i++) {
            if (user.username === employees[i].username) {
                match = true;
                index = i;
            }
        }
        if (match) {
            console.log('removing ' + index)
            employees.splice(index, 1);
        }
        console.log('Employee size: ' + employees.length);
    });

    socket.on('chat-request', (token) => {
        token.socketId = socket.id;
        if (employees.length === 0) {
            io.sockets.to(socket.id).emit('chat-request-re', false);
            console.log('no employees online');
        } else {
            let room = token.username + employees[orderIndex].username;
            console.log(token.username + " AND " + employees[orderIndex].username + " ARE CHATTING");
            socket.join(room);
            io.sockets.to(token.socketId).emit('chatroom', room);

            io.sockets.to(employees[orderIndex].socketId).emit('chatroom', room);
        }
    });

    socket.on('new-message', (message) => {
        io.sockets.in(message.room).emit('new-message', message);
        console.log(message.room)
    });


    socket.on('join', function (room) {
        socket.join(room);
        console.log(socket.id + ` joined room ` + room);
    });

});

server.listen(port, () => {
    console.log(`started on port: ${port}`);
});

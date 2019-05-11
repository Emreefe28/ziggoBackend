let express = require('express');
let app = express();

let http = require('http');
let server = http.Server(app);

let socketIO = require('socket.io');
let io = socketIO(server);

const port = 3000;
var employees = [];
var next = 0;

io.on('connection', (socket) => {
    console.log('user connected');


    socket.on('who-is-on', () => {
        console.log('checking employees....');
        console.log(employees.length + " EMPLOYEES ONLINE");
        io.sockets.to(socket.id).emit('who-is-on', employees.length);
    });

    socket.on('check-in', (employee) => {
        employee.socketId = socket.id;
        console.log('checking in...' + employee);
        employees.push(employee);
    });

    socket.on('new-message', (message) => {
        io.in(message.room).emit('new-message', message);
    });

    socket.on('check-out', () => {
        for (var i = 0; i < employees.length; ++i) {
            var e = employees[i];
            console.log(employees[i].employee + ' checked out');
            if (e.socketId === socket.id) {
                employees.splice(i, 1);
            }
        }
    });

    socket.on('request-re', (token) => {
        console.log("request from " + token.client + "has been accepted by " + token.employee);
        socket.join(token.chat.id);
        socket.to(token.chat.id).emit('request-re', token);
    });

    socket.on('match', (token) => {
        console.log('MATCHING...');
        let employee = employees[next];
        console.log('matched with ' + employees[next].employee.name);
        token.employee = employee.employee;
        socket.join(token.chat.id);
        if (next >= employees.length - 1) {
            next = 0;
        } else {
            next++;
        }
        io.sockets.to(employee.socketId).emit('chat-request', token);

    });

    socket.on('disconnect', function () {
        for (var i = 0; i < employees.length; ++i) {
            var e = employees[i];
            console.log(employees[i].employee + ' terminated the connection');
            if (e.socketId === socket.id) {
                employees.splice(i, 1);
            }
        }
    });
});

server.listen(port, () => {
    console.log(`started on port: ${port}`);
});

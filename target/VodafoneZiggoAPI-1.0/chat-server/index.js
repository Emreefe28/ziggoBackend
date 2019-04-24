let express = require('express');
let app = express();

let http = require('http');
let server = http.Server(app);

let socketIO = require('socket.io');
let io = socketIO(server);

const port = 3000;
var employees = [];

io.on('connection', (socket) => {
    console.log('user connected');


    socket.on('who-is-on', () => {
        console.log('checking employees....');
        console.log(employees.length + " EMPLOYEES ONLINE");
        io.sockets.to(socket.id).emit('whos-online', employees.length);
    });

    socket.on('check-in', (employee) => {
        employee.socketId = socket.id;
        console.log('checking in...' + employee);
        employees.push(employee);
    });

    socket.on('join', function (room) {
        socket.join(room);
        console.log(socket.id + ` joined room ` + room);
    });

    socket.on('disconnect', function () {
        for( var i = 0; i < employees.length; ++i ){
            var e = employees[i];
            if(e.socketId === socket.id){
                employees.splice(i,1);
            }
        }
    });
});

server.listen(port, () => {
    console.log(`started on port: ${port}`);
});

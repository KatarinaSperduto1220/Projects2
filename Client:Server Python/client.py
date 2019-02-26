import socket

s = socket.socket()
host = socket.gethostname()
port = 12345
s.connect((host,port))
s.send(str.encode("Hello"))

with open('received_file', 'wb') as f:
    print ('file opened')
    while True:
        print('receiving data...')
        data = s.recv(1024)
        print('data=%s', (data.decode()))
        if not data:
            break

        f.write(data)
f.close()
print('Successfully received file')
# print (s.recv(1024))
s.close()

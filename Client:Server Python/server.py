import socket

s = socket.socket()
host = socket.gethostname()
port = 12345
s.bind((host,port))
s.listen(5)

while True:
    conn,addr = s.accept()
    print("got connection from", addr)
    data = conn.recv(1024)
    print('Server received', repr(data))

    filename = 'TestFile.txt'
    l = filename.encode()
    f =open(filename, 'r')
    l = f.read(1024)
    l = str.encode(l)

    while(l):
        conn.send(l)
        print('Sent', repr(l))
        l=f.read(1024)
    f.close()

    print('Done Sending')
    conn.send(str.encode('thank you for connecting'))
    conn.close()

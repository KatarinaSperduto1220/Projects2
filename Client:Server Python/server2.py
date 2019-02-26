import socket

s = socket.socket()
host = socket.gethostname()
port = 12345
s.bind((host,port))
s.listen(5)

while True:
    conn,addr = s.accept()
    print("got connection from", addr)
    data = conn.recv(16)
    print('Server received', repr(data))

    name = data[0:8]
    print(name + str.encode(" received"))
    print(data)
    size = data[8]
    print(size, "bytes in file")

    filehandle = open(name, 'wb')
    filehandle.write(data[9:9 + int(size)-1])
    print("  ")
    print("written to file")


    conn.close()

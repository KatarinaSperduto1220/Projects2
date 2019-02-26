import socket

s = socket.socket()
host = socket.gethostname()
port = 12345
s.connect((host,port))
# s.send(str.encode("Hello"))

name = "Test.txt"
size = 4
data = "test"

buf = name +str(size) + data
s.send(str.encode(buf))

print('Successfully transmitted file')
# print (s.recv(1024))
s.close()

#-----------------------------------------------------------------------
# File    : makefile    (directory: acopt)
# Contents: build ant colony optimization demonstration program
# Author  : Christian Borgelt
# History : 2005.11.18 file created
#           2013.11.04 tar archive added as distribution package
#-----------------------------------------------------------------------
SHELL=/bin/bash

all:        acopt

#-----------------------------------------------------------------------
# Pointgon Viewer
#-----------------------------------------------------------------------
acopt:      *.java ../util/Scanner.java
	cd ..; javac -Xlint acopt/ACODemo.java

#-----------------------------------------------------------------------
# Distribution Packages
#-----------------------------------------------------------------------
dist:
	$(MAKE) clean jdoc src jdclean

src:
	cd ..; \
        zip -rq acopt.zip \
            acopt/*.java util/Scanner.java \
            acopt/makefile acopt/run* acopt/runjar*; \
        tar cfz acopt.tar.gz \
            acopt/*.java util/Scanner.java \
            acopt/makefile acopt/run* acopt/runjar*

jar:    acopt
	cd ..; \
	echo "Main-Class: acopt.ACODemo" > manifest; \
	jar cfm acopt.jar manifest \
                acopt/*.class util/Scanner.class; \
	rm -f manifest

#-----------------------------------------------------------------------
# Documentation
#-----------------------------------------------------------------------
jdoc:
	cd doc/java; rm -rf *; \
	javadoc -quiet -classpath ../../.. acopt

#-----------------------------------------------------------------------
# Installation
#-----------------------------------------------------------------------
install:    jar
	cd ..; mv acopt.jar $(HOME)/bin

#-----------------------------------------------------------------------
# Clean up
#-----------------------------------------------------------------------
clean:
	rm -f *.class ../util/*.class

jdclean:
	rm -rf doc/java/*

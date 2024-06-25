.PHONY: all build run
all: build run

OUTPUT = ./build
SRC = ./model/*.java
SRC += ./view/*.java
SRC += ./controller/*.java

build:
	javac -d $(OUTPUT) CalcMain.java $(SRC)

run: build
	java -cp $(OUTPUT) CalcMain 


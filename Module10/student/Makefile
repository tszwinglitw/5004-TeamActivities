.PHONY: all build run
all: build run

OUTPUT = ./build
SRC = ./model/*.java
SRC += ./view/*.java
SRC += ./controller/*.java

build:
	javac -d $(OUTPUT) $(SRC) CalculatorApp.java Settings.java
	cp ./view/config.xml $(OUTPUT)/student/view/config.xml

run: build
	java -cp ./build/ student.CalculatorApp
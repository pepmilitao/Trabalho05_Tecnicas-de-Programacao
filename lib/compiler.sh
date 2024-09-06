#!/bin/bash

javac -d ../bin/ -cp ../src ../src/tools/abstracts/Strategy.java
javac -d ../bin/ -cp ../src ../src/tools/concretes/*
javac -d ../bin/ -cp ../src ../src/tools/context/Context.java
javac -d ../bin/ -cp ../src ../src/app/Main.java
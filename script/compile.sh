#!/bin/sh

## clean previous output
rm -rf out/*

## compile all java files to classes (TODO configure classpath)pi.jar:lib/jar2.jar  $(find ./src/main -name "*.java")

classpath=$(find ./lib -name "*.jar" | paste -sd ":")


javac -cp $classpath -d out/classes $(find ./src/main -name "*.java")

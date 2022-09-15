#!/bin/sh

./script/compile.sh
./script/configure.sh

mkdir -p out/war/WEB-INF
cp -R out/classes out/war/WEB-INF
cp -R src/main/webapp/* out/war/
jar -cvf out/war/helloworld.war  -C  out/war/ .

./script/deploy.sh
./script/start.sh

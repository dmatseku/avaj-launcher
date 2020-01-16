#!bin/sh
find . -name "*.java" > run
javac -sourcepath @run
java avaj_launcher/Main $@

# avaj-launcher #

42 School project.

This is an aircraft simulation program. All information is in the file "avaj-launcher.en.pdf".
The goal of this project is to learn how to use the uml-diagrams.

![visual image](https://github.com/dmatseku/avaj-launcher/blob/master/avaj_uml.jpg)

## Execution ##

Execute the following commands:

    find . -name "*.java" > run
    javac -sourcepath @run
    java avaj_launcher/Main <filename for program>

## Problems ##

If you have problems compiling, then duplicate the first line in the generated "run" file and retry the second command above.

## Input file ##

### Rules ###

the input file looks like this:

    number_of_steps
    TYPE NAME LONGITUDE LATITUDE HEIGHT
    ...
    
### Example ###

    25
    Baloon B1 2 3 20
    Baloon B2 1 8 66
    JetPlane J1 23 44 32
    Helicopter H1 654 33 20
    Helicopter H2 22 33 44
    Helicopter H3 98 68 99
    Baloon B3 102 22 34
    JetPlane J2 11 99 768
    Helicopter H4 223 23 54

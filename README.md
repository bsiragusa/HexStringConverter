#####################################
#                                   #
#           HexConverter            #
#                                   #
#####################################

## FUNCTIONS ##
This program is very simple, insert into the "input field" a string, or an hexadecimal string, then click the "convert" button. 
If the input value is a simple string it converts it into a hexadecimal string.
If the input value is a hexadecimal string it converts it into a simple string.

## BUILD JAR ##
This project is built with java 11 and the swing dependency compatible with it, and the dependencies are managed with maven
command build --> mvn clean package

## BUILD .EXE ##
If you want to obtain an .exe file you can use "launch4j" software (https://launch4j.informer.com/).
The configuration "launch4j-hexConverter.xml" is located into this "resources" directory.
Just remember to change the value of "<outfile>", "<jar>" and "<icon>" tags in order to build correctly the exe. 

## RUN LOCAL ##
Just execute the main of the HexConverter.java class
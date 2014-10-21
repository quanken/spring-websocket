spring-websocket
================

This is a gradle example project for spring 4 websocket

## Dependencies

In order to build and run this project, you should have :

* Java JDK 1.7
* Gradle 2.0+
* Tomcat 7.0.57
* Browser that support web socket (Firefox / Chrome)
* Eclipse / IntelliJ IDEA (Optional)

## Frameworks

This sample project used frameworks below :

* spring framework 4 with mvc, websocket modules
* SockJS
* stomp.js

## Compile And Run

* exec `gradle build` to get war achieve 
* deploy it to your tomcat server
* configure context "/" to map this project docBase
* open browser and type `http://ip:port/`  to visit project ( visit http://localhost:8080 by default )
* just type username and login to chatroom
* repeat last two step above in another browser with another username
* enjoy the simplest chatroom

This is an a spring boot microservice to give solutions to the problems in ProjectEuler.
Make sure activeMQ is installed, the default port to listen to is 61616 and 8161 for the console.
./activemq start in the active mq directory to start it as a daemon process

Useful links
https://projecteuler.net/
http://localhost:8161/admin/queues.jsp   //activeMQ console - login is admin/admin
http://localhost:8080/swagger-ui.html#/  //Swagger console
http://localhost:8080/actuator/health    //Health endpoint

I am working on getting Docker-compose up and running
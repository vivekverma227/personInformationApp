# EMBLAssignment
Is a End-to-End Implementation of Person Information.
This Application is based on Spring Boot and Restful Webservice as BackEnd and AngularJs, Html CSS, and Bootstrap as Front End.
Application having below Restful API:
1. http://localhost:8080/EmblAssignment_Vivek/api/personInfo/   GET Request                                ( List of All Person)

2. http://localhost:8080/EmblAssignment_Vivek/api/personInfo/   POST Request with request paraam     ( To save new Person)

3. http://localhost:8080/EmblAssignment_Vivek/api/personInfo/2  GET Request with id path parameter   (  To get Person info by passing ID)

4. http://localhost:8080/EmblAssignment_Vivek/api/personInfo/2  PUT Requst with Requst parameter     (  To update Person information)

5. http://localhost:8080/EmblAssignment_Vivek/api/personInfo/4  DELETE Request with id as parameter ( To delete person with matching ID.)

# Curl Command to execute and Test implemented API:
1. curl -X GET "http://localhost:8080/EmblAssignment_Vivek/api/personInfo/" -H "accept: */*"

2. curl -X POST "http://localhost:8080/EmblAssignment_Vivek/api/personInfo/" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"age\": 0, \"favourite_colour\": \"string\", \"first_name\": \"string\", \"hobbies\": [ \"string\" ], \"id\": 0, \"last_name\": \"string\"}"

3. curl -X GET "http://localhost:8080/EmblAssignment_Vivek/api/personInfo/2" -H "accept: */*"

4. curl -X PUT "http://localhost:8080/EmblAssignment_Vivek/api/personInfo/2" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"age\": 0, \"favourite_colour\": \"string\", \"first_name\": \"string\", \"hobbies\": [ \"string\" ], \"id\": 0, \"last_name\": \"string\"}"
5. curl -X DELETE "http://localhost:8080/EmblAssignment_Vivek/api/personInfo/4" -H "accept: */*"


Application Screenshots is attached with the Codebase # Person Information APP Screenshot.docx

Please download the project and import into any of the IDE (Eclipse or Intellij), Run the main Class.
Once the Tomcat is up, Please hit Below URL to see the Front end.

http://localhost:8080/EmblAssignment_Vivek/#/

to see the API details Please hit below URL:

http://localhost:8080/EmblAssignment_Vivek/swagger-ui.html#/




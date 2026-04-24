overview:This project is a rest API built using JAX RS and running on Tomcat. It manages rooms and sensors. The API allows creating retrieving, deleting and filtering data. Data is stored using HashMap and ArrayList instead of a database.

how to run
1: open project in netbeans
2: clean and build project
3: run project using tomcat as the server
4: server will start on the url i pasted below

url to open
http://localhost:8080/coursework_clientServerArc/api/v1

endpoints

get all rooms
GET /rooms

create room
POST /rooms

get room by id
GET /rooms/{id}

delete room
DELETE /rooms/{id}

get all sensors
GET /sensors

create sensor
POST /sensors

filter sensors by type
GET /sensors?type=CO2

curl commands

get all rooms
curl 1:  GET http://localhost:8080/coursework_clientServerArc/api/v1/rooms

create room
curl 2: POST http://localhost:8080/coursework_clientServerArc/api/v1/rooms 
payload 

get room by id
curl 3: GET http://localhost:8080/coursework_clientServerArc/api/v1/rooms/1

create sensor
curl 4: POST http://localhost:8080/coursework_clientServerArc/api/v1/sensors 
payload

filter sensors
curl 5: GET "http://localhost:8080/coursework_clientServerArc/api/v1/sensors?type=H

questions

part 1

jax rs resource lifecycle  
A new object is created for each request. this means data shouldnt be stored in the resource class. Instead shared data is stored in hashmap or list.

hypermedia  
It helps users understand what endpoints exist without reading documents basically just making the api easier to use.

part 2

ids vs full objects  
Returning only ids uses less data but client need to do more calls. Returning full objects uses more bandwidth but is easier for client.

delete idempotent  
Yes it is idempotent if you delete the same room again it will return not found.

part 3

wrong content type  
If the user sends wrong type like text or xml the request will fail because jax rs cannot convert it to object.

query param vs path  
Query params are better for filtering because they do not have to be used and they are flexible.

part 5

why not 404 for sensor room error  
422 or 400 is better because the request might be valid but the data inside is wrong.

security risk of stack trace  
Stack traces expose internal class names and structure which could mean that attackers can use this to find weaknesses.

why use filters  
Filters apply to all requests so code is cleaner. There is no need to repeat logging in every method.

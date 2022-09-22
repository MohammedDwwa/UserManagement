# UserManagement

by default the application will run on port 8080

Hitting the endpoint via below URI
http://localhost:8080/v1/user-management/users/add-user

to access the embded H2 database you can hit the below url:
http://localhost:8080/h2-console/
Driver Class: org.h2.Driver
JDBC URL:jdbc:h2:mem:testdb
User Name:sa
Password:

for test the saveUser end point you can try the below sample request:

{
    "name": "sssss Dwwa",
    "password": "Dwwa"
}

expected output:

{
    "id": 1,
    "name": "sssss Dwwa",
    "hashedPassword": "c7bcbab6d661dbcedf3a44eaa91effa988c4645ad7394d9d02fa7450de306caf"
}

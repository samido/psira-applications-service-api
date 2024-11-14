# psira-applications-service-api

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8813/q/dev/>.

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/psira-applications-service-api-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.

## Related Guides

- JDBC Driver - MySQL ([guide](https://quarkus.io/guides/datasource)): Connect to the MySQL database via JDBC
- Hibernate ORM ([guide](https://quarkus.io/guides/hibernate-orm)): Define your persistent model with Hibernate ORM and Jakarta Persistence
- RESTEasy Classic ([guide](https://quarkus.io/guides/resteasy)): REST endpoint framework implementing Jakarta REST and more
- SmallRye JWT ([guide](https://quarkus.io/guides/security-jwt)): Secure your applications with JSON Web Token

## Provided Code

### Hibernate ORM

Create your first JPA entity

[Related guide section...](https://quarkus.io/guides/hibernate-orm)



### RESTEasy JAX-RS

Easily start your RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)

# Testing User APIs

### 1. Get All Users
   URL: GET http://localhost:8813/api/users  
   
Sample Response:

```shell script
[
    {
        "userId": 1,
        "username": "johndoe",
        "password": "password123",
        "name": "John",
        "surname": "Doe",
        "idNumber": "1234567890",
        "addresses": [
            {
                "streetName": "Main St",
                "streetNumber": "123",
                "town": "Springfield",
                "city": "Metropolis",
                "postalCode": "12345"
            }
        ],
        "contactInfo": [
            {
                "email": "john.doe@example.com",
                "cellphone": "123-456-7890",
                "fax": "123-456-7891",
                "workPhone": "123-456-7892"
            }
        ]
    }
]
```

### 2. Get User by ID
   URL: GET http://localhost:8813/api/users/{id}  
   
Sample Response:
```shell script
{
    "userId": 1,
    "username": "johndoe",
    "password": "password123",
    "name": "John",
    "surname": "Doe",
    "idNumber": "1234567890",
    "addresses": [
        {
            "streetName": "Main St",
            "streetNumber": "123",
            "town": "Springfield",
            "city": "Metropolis",
            "postalCode": "12345"
        }
    ],
    "contactInfo": [
        {
            "email": "john.doe@example.com",
            "cellphone": "123-456-7890",
            "fax": "123-456-7891",
            "workPhone": "123-456-7892"
        }
    ]
}
```
### 3. Create User
   URL: POST http://localhost:8813/api/users  
   
Sample Request Body:
```shell script
{
    "username": "johndoe",
    "password": "password123",
    "name": "John",
    "surname": "Doe",
    "idNumber": "1234567890",
    "address": [
        {
            "streetName": "Main St",
            "streetNumber": "123",
            "town": "Springfield",
            "city": "Metropolis",
            "postalCode": "12345"
        }
    ],
    "contactInfo": [
        {
            "email": "john.doe@example.com",
            "cellphone": "123-456-7890",
            "fax": "123-456-7891",
            "workPhone": "123-456-7892"
        }
    ]
}
```
### 4. Update User
   URL: PUT http://localhost:8813/api/users/{id}  
   
Sample Request Body:
```shell script
{
    "username": "johndoe",
    "password": "newpassword123",
    "name": "John",
    "surname": "Doe",
    "idNumber": "1234567890",
    "address": [
        {
            "streetName": "Main St",
            "streetNumber": "123",
            "town": "Springfield",
            "city": "Metropolis",
            "postalCode": "12345"
        }
    ],
    "contactInfo": [
        {
            "email": "john.doe@example.com",
            "cellphone": "123-456-7890",
            "fax": "123-456-7891",
            "workPhone": "123-456-7892"
        }
    ]
}
```
### 5. Delete User
   URL: DELETE http://localhost:8813/api/users/{id} 
   
Sample Response:
```shell script
{
    "message": "User deleted successfully"
}
```

# Testing Applications APIs
  ###  1. List All Applications
        URL: GET http://localhost:8813/api/applications
        Example Response:
```shell script
[
    {
        "id": 1,
        "postId": 101,
        "user": {
            "id": 1,
            "username": "johndoe",
            "name": "John",
            "surname": "Doe",
            "idNumber": "1234567890",
            "address": [
                {
                    "streetName": "Main St",
                    "streetNumber": "123",
                    "town": "Springfield",
                    "city": "Metropolis",
                    "postalCode": "12345"
                }
            ],
            "contactInfo": [
                {
                    "email": "john.doe@example.com",
                    "cellphone": "123-456-7890",
                    "fax": "123-456-7891",
                    "workPhone": "123-456-7892"
                }
            ]
        },
        "qualification": "Bachelor's Degree",
        "driversLicense": "B",
        "currentPosition": "Software Engineer",
        "currentCompany": "Tech Corp",
        "yearsInPosition": 3,
        "currentSalary": 60000,
        "totalExperience": 5,
        "cvFile": "path/to/cv.pdf"
    }
]
```
  ###  2. Get Application by ID
        URL: GET http://localhost:8813/api/applications/{id}
        Example Response:
```shell script
{
    "id": 1,
    "postId": 101,
    "user": {
        "id": 1,
        "username": "johndoe",
        "name": "John",
        "surname": "Doe",
        "idNumber": "1234567890",
        "address": [
            {
                "streetName": "Main St",
                "streetNumber": "123",
                "town": "Springfield",
                "city": "Metropolis",
                "postalCode": "12345"
            }
        ],
        "contactInfo": [
            {
                "email": "john.doe@example.com",
                "cellphone": "123-456-7890",
                "fax": "123-456-7891",
                "workPhone": "123-456-7892"
            }
        ]
    },
    "qualification": "Bachelor's Degree",
    "driversLicense": "B",
    "currentPosition": "Software Engineer",
    "currentCompany": "Tech Corp",
    "yearsInPosition": 3,
    "currentSalary": 60000,
    "totalExperience": 5,
    "cvFile": "path/to/cv.pdf"
}
```
  ###  3. Create Application
        URL: POST http://localhost:8813/api/applications
        Example Request:
```shell script
{
    "postId": 101,
    "userId": 1,
    "qualification": "Bachelor's Degree",
    "driversLicense": "B",
    "currentPosition": "Software Engineer",
    "currentCompany": "Tech Corp",
    "yearsInPosition": 3,
    "currentSalary": 60000,
    "totalExperience": 5,
    "cvFile": "path/to/cv.pdf"
}
```
Response:
```shell script
{
    "id": 1,
    "postId": 101,
    "user": {
        "id": 1,
        "username": "johndoe",
        "name": "John",
        "surname": "Doe",
        "idNumber": "1234567890",
        "address": [
            {
                "streetName": "Main St",
                "streetNumber": "123",
                "town": "Springfield",
                "city": "Metropolis",
                "postalCode": "12345"
            }
        ],
        "contactInfo": [
            {
                "email": "john.doe@example.com",
                "cellphone": "123-456-7890",
                "fax": "123-456-7891",
                "workPhone": "123-456-7892"
            }
        ]
    },
    "qualification": "Bachelor's Degree",
    "driversLicense": "B",
    "currentPosition": "Software Engineer",
    "currentCompany": "Tech Corp",
    "yearsInPosition": 3,
    "currentSalary": 60000,
    "totalExperience": 5,
    "cvFile": "path/to/cv.pdf"
}
```
  ###  4. Update Application
        URL: PUT http://localhost:8813/api/applications/{id}
        Example Request:
```shell script
{
    "postId": 101,
    "userId": 1,
    "qualification": "Bachelor's Degree",
    "driversLicense": "B",
    "currentPosition": "Software Engineer",
    "currentCompany": "Tech Corp",
    "yearsInPosition": 3,
    "currentSalary": 60000,
    "totalExperience": 5,
    "cvFile": "path/to/cv.pdf"
}
```
Response:
```shell script
{
    "id": 1,
    "postId": 101,
    "user": {
        "id": 1,
        "username": "johndoe",
        "name": "John",
        "surname": "Doe",
        "idNumber": "1234567890",
        "address": [
            {
                "streetName": "Main St",
                "streetNumber": "123",
                "town": "Springfield",
                "city": "Metropolis",
                "postalCode": "12345"
            }
        ],
        "contactInfo": [
            {
                "email": "john.doe@example.com",
                "cellphone": "123-456-7890",
                "fax": "123-456-7891",
                "workPhone": "123-456-7892"
            }
        ]
    },
    "qualification": "Master's Degree",
    "driversLicense": "B",
    "currentPosition": "Senior Software Engineer",
    "currentCompany": "Tech Corp",
    "yearsInPosition": 5,
    "currentSalary": 80000,
    "totalExperience": 7,
    "cvFile": "path/to/updated_cv.pdf"
}
                
```       
         
  ###  5. Delete Application
        URL: DELETE http://localhost:8813/api/applications/{id}
        Example Request:
```shell script
{
    "message": "Application deleted successfully"
}
```
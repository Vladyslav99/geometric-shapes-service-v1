# Geometrical shapes REST API service V1

-----

This service provides REST API for calculating perimeter and area of geometrical shapes.
Supported shapes and formulas for perimeter and area:

### Square
- $P = 4 * side$
- $S = side * side$

### Rectangle
- $P = 2 * sideA + 2 * sideB$
- $S = sideA * sideB$

### Triangle
- $P = sideA + sideB + sideC$
- $p = (sideA + sideB + sideC) / 2$  
- $S = \sqrt{p * (p - sideA) * (p - sideB) * (p - sideC)}$

### Circle
- $P = 2 * PI * radius$
- $S = (PI * radius) ^ 2$

-----

## Run the app
To run the application maven 3.x version and Java 8 installed are required.

Execute:
    
    mvn clean install
    mvn spring-boot:run

After startup the application is available under:

`http://localhost:8080/geometric-shapes-service-v1/api/v1`

-----

# REST API

The REST API for the service is described below.

## Calculate perimeter and area for geometric shape

Supported `shapeType` - `SQUARE`, `TRIANGLE`, `RECTANGLE`, `CIRCLE`

### Request for SQUARE

`POST http://localhost:8080/geometric-shapes-service-v1/api/v1/shapes`


#### Body
```
{
    "shapeType": "SQUARE",
    "side": 2.5
}
```

### Response
```
Status: 200 OK

{
    "perimeter": 10.0,
    "area": 6.25
}
```

### Request for RECTANGLE

`POST http://localhost:8080/geometric-shapes-service-v1/api/v1/shapes`


#### Body
```
{
    "shapeType": "RECTANGLE",
    "sideA": 2.5,
    "sideB": 3.6
}
```

### Response
```
Status: 200 OK

{
    "perimeter": 12.2,
    "area": 9.0
}
```

### Request for TRIANGLE

`POST http://localhost:8080/geometric-shapes-service-v1/api/v1/shapes`


#### Body
```
{
    "shapeType": "TRIANGLE",
    "sideA": 2.5,
    "sideB": 3.6,
    "sideC": 4.6
}
```

### Response
```
Status: 200 OK

{
    "perimeter": 10.7,
    "area": 4.473515815329145
}
```

### Request for CIRCLE

`POST http://localhost:8080/geometric-shapes-service-v1/api/v1/shapes`


#### Body
```
{
    "shapeType": "CIRCLE",
    "radius": 4.1
}
```

### Response
```
Status: 200 OK

{
    "perimeter": 25.7610597594363,
    "area": 165.90804998231206
}
```

### Request with invalid payload

`POST http://localhost:8080/geometric-shapes-service-v1/api/v1/shapes`


#### Body
```
{
    "shapeType": "RECTANGLE",
    "sideA": -45,
    "sideB": 0
}
```

### Response
```
Status: 400 Bad Request

{
    "message": "Validation failed",
    "errors": {
        "sideB": "must be not empty and greater than 0",
        "sideA": "must be not empty and greater than 0"
    }
}
```
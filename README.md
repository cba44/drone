# Drones README

## How To Build

- Checkout the repository.
- If maven is installed in the computer run
    **mvn clean package**
- If maven is not available use maven wrappers **mvnw** instead of **mvn**.

---
## How To Run

- Run the included docker compose file using **docker compose up -d**
- Now, the drone application is running on port **7575**

---
## Base URL
- If running on localhost, base url is **localhost:7575/api/v1**
- If running on remote server, base url is **http://[ip-address or domain-name]:7575/api/v1**

---
## Requests for API

### Registering a drone
- URL :- **[base-url]/drones**
- Request Type :- **POST**
- Sample Request
```
{
    "serial": "serial5",
    "model": "Cruiserweight",
    "weightLimit": 300.0,
    "batteryCapacity": 45,
    "state": "IDLE"
}
```

### Loading a drone with medication items
- URL :- **[base-url]/drones/medications**
- Request Type :- **POST**
- Sample Request
```
{
    "serial": "serial1",
    "medications": [
        {
            "name": "medicine9-_",
            "weight": 100.0,
            "code": "CODEA_",
            "image": "url1"
        },
        {
            "name": "medicine",
            "weight": 50.0,
            "code": "CODEB-",
            "image": "url2"
        }
    ]
}
```
### Checking loaded medication items for a given drone
- URL :- **[base-url]/drones/medications/[serial]**
- Request Type :- **GET**
- Replace **serial** with drone serial

### Checking available drones for loading
- URL :- **[base-url]/drones/available**
- Request Type :- **GET**

### Check drone battery level for a given drone
- URL :- **[base-url]/drones/battery/[serial]**
- Request Type :- **GET**
- Replace **serial** with drone serial
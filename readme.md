# Online Hotel Booking System

It's a online hotel booking system backend application having multiple REST API endpoints through which the user can book hotels via online.

| **API**                                         | **Description**                    | **Operation ID**        |
| :---------------------------------------------- | :--------------------------------- | :---------------------- |
| /api/hotel/property                             | Get all hotels                     | getAllHotels            |
| /api/hotel/property                             | Add a new hotel                    | addNewHotel             |
| /api/hotel/property/room                        | Get all rooms                      | getAllRooms             |
| api/hotel/property/room                         | Add a new room                     | addNewRoom              |
| /api/hotel/property/{name}                      | Get a hotel by name                | getHotel                |
| /api/hotel/property/room/{hotelName}/{roomType} | Get the number of rooms in a hotel | getNumberOfroomsInHotel |

| **Response** | **Description** | **Schema**                                       |
| :----------- | :-------------- | :----------------------------------------------- |
| 200          | OK              | Array of HotelInfoResponse |
| 201          | Created         | String                                           |
| 200          | OK              | Array of RoomResponse           |
| 200          | OK              | HotelInfoResponse      |
| 200          | OK              | Integer                                |

| **Parameters**      | **In** | **Type** | **Required** |
| :------------------ | :----- | :------- | :----------- |
| hotelName, roomType | query  | String   | true         |
| hotelName, roomType | path   | String   | true         |
| name                | path   | String   | true         |

### Schemas

| **Schema**         | **Type** | **Properties**                 |
| :----------------- | :------- | :----------------------------- |
| #HotelInfoResponse | object   | uuid (String, UUID)            |
|                    |          | name (String)                  |
|                    |          | address (String)               |
| RoomRequest        | object   | hotelName (String)             |
|                    |          | numOfBeds (Integer, int32)     |
|                    |          | roomType (String)              |
|                    |          | numberOfRooms (Integer, int32) |
| RoomResponse       | object   | hotelUUID (String, UUID)       |
|                    |          | roomId (String, UUID)          |
|                    |          | bedcount (Integer, int32)      |
|                    |          | roomType (String)              |
|                    |          | roomStatus (Integer, int32)    |

## Installation

Clone the git repository and install Java17 or higher
and use swagger UI for the documentation of APIs.

```bash
  cd OnlinehotelbookingSystem
  mvn clean verify
```

## Screenshots

![App Screenshot](https://github.com/Maruf-Hasan1789/Online-Hotel-Booking-System/blob/master/Screenshot%20-hotel.png)
![App Screenshot](https://github.com/Maruf-Hasan1789/Online-Hotel-Booking-System/blob/master/Screenshot%20-reservation.png)
![App Screenshot](https://github.com/Maruf-Hasan1789/Online-Hotel-Booking-System/blob/master/Screenshot%20guest.png)
![App Screenshot](https://github.com/Maruf-Hasan1789/Online-Hotel-Booking-System/blob/master/Screenshot%20discovery-server.png)

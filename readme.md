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
| 200          | OK              | array of [HotelInfoResponse](#hotelinforesponse) |
|              |                 | string                                           |
| 201          | Created         | string                                           |
| 200          | OK              | array of [RoomResponse](#roomresponse)           |
| 200          | OK              | [HotelInfoResponse](#hotelinforesponse)          |
| 200          | OK              | integer (int32)                                  |

| **Parameters**      | **In** | **Type** | **Required** |
| :------------------ | :----- | :------- | :----------- |
| hotelName, roomType | query  | string   | true         |
| hotelName, roomType | path   | string   | true         |
| name                | path   | string   | true         |

### Schemas

| **Schema**        | **Type** | **Properties**                 |
| :---------------- | :------- | :----------------------------- |
| HotelInfoResponse | object   | uuid (string, uuid)            |
|                   |          | name (string)                  |
|                   |          | address (string)               |
| RoomRequest       | object   | hotelName (string)             |
|                   |          | numOfBeds (integer, int32)     |
|                   |          | roomType (string)              |
|                   |          | numberOfRooms (integer, int32) |
| RoomResponse      | object   | hotelUUID (string, uuid)       |
|                   |          | roomId (string, uuid)          |
|                   |          | bedcount (integer, int32)      |
|                   |          | roomType (string)              |
|                   |          | roomStatus (integer, int32)    |

## Installation

Clone the git repository and install Java17 or higher

```bash
  cd OnlinehotelbookingSystem
  mvn clean verify
```

## Screenshots

![App Screenshot](https://via.placeholder.com/468x300?text=App+Screenshot+Here)

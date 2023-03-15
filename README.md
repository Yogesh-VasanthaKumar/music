# Music Streaming Service API


Music Streaming Service API using java Spring boot
## Framework

 - Java Spring Boot 
 - JPA
 - MySQL
 - Hibernate
 - lombok


## API Reference

### Songs
#### Get all Songs

```http
  GET /music/song/get/{userId}
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
|  `Id`   | `Int` |  userId|

#### Add Songs

```http
  POST /music/song/add/{userId}
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
|  `Id`   | `Int` |  userId|

  ##### Sample JSON
{
  "id": 0,
  "songName": "string",
  "artistName": "string"
}

#### Update Songs

```http
  PUT /music/song/update/{userId}
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
|  `Id`   | `Int` |  userId|

  ##### Sample JSON
{
  "id": 0,
  "songName": "string",
  "artistName": "string"
}

#### Delete Songs
```http
  DELETE /music/song/delete/{userid}/{songid}
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
|  `Id`   | `Int` |  userId|
| `SongId` | `Int` | Song to delete|


### Playllist

#### Get Playlist By User

```http
  GET /music/playlist/get/{userId}
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
|  `Id`   | `Int` |  userId|

#### Create Playlist

```http
  POST /music/playlist/get/{userId}
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
|  `Id`   | `Int` |  userId|

  ##### Sample JSON
{
  "id": 0,
  "name": "string",
  "songList": [
    {
      "id": 0,
      "songName": "string",
      "artistName": "string"
    }
  ],
  "user": {
    "id": 0,
    "name": "string",
    "username": "string",
    "password": "string",
    "admin": true
  }
}

#### Add Songs to Playlist

```http
  PUT /music/playlist/update/{userId}/{songId}/{playlistid}
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
|  `Id`   | `Int` |  userId|
| `songId| `Int` | songId |
| `Playlist ID| `Int `| playlist ID|


#### Delete Songs from playlist
```http
  Delete /music/playlist/delete/{userid}/{songid}/{playlistid}
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
|  `Id`   | `Int` |  userId|
| `songId| `Int` | songId |
| `Playlist ID| `Int `| playlist ID|


### User

#### Get all Users

```http
  GET /music/User/get
```
#### Add Users
```http
  POST /music/User/add
```


##### Sample JSON

{
  "id": 0,
  "name": "string",
  "username": "string",
  "password": "Z#,ba7>}OIX_PK!z7*E",
  "admin": true
}

#### Delete Users

```http
  Delete /music/User/delete/{id}
```


| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
|  `Id`   | `Int` |  To Delete User|


## Authors

- [@Yogesh](https://github.com/Yogesh-VasanthaKumar/)



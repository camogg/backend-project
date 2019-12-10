
# Backend-project



## Indices

* [Courses](#courses)

  * [Get Courses](#1-get-courses)
  * [Get Specific Course](#2-get-specific-course)
  * [Get Specific Course Statistics](#3-get-specific-course-statistics)
  * [Post Course](#4-post-course)
  * [Update Course](#5-update-course)
  * [Delete Course](#6-delete-course)

* [Documentation](#documentation)

  * [Get Documentation](#1-get-documentation)

* [Enrollments](#enrollments)

  * [Get Enrollments](#1-get-enrollments)
  * [Get Specific Enrollment](#2-get-specific-enrollment)
  * [Get Enrollments by Student](#3-get-enrollments-by-student)
  * [Get Enrollments by Course](#4-get-enrollments-by-course)
  * [Post Enrollment](#5-post-enrollment)
  * [Update Enrollment](#6-update-enrollment)
  * [Delete Enrollment](#7-delete-enrollment)

* [Students](#students)

  * [Get Students](#1-get-students)
  * [Get Specific Student](#2-get-specific-student)
  * [Get Specific Student Statistics](#3-get-specific-student-statistics)
  * [Post Student](#4-post-student)
  * [Update Student](#5-update-student)
  * [Delete Student](#6-delete-student)

* [Teachers](#teachers)

  * [Get Teachers](#1-get-teachers)
  * [Get Specific Teacher](#2-get-specific-teacher)
  * [Post Teacher](#3-post-teacher)
  * [Update Teacher](#4-update-teacher)
  * [Delete Teacher](#5-delete-teacher)


--------


## Courses



### 1. Get Courses



***Endpoint:***

```bash
Method: GET
Type: 
URL: localhost:8080/courses
```



### 2. Get Specific Course



***Endpoint:***

```bash
Method: GET
Type: 
URL: localhost:8080/courses/0
```



### 3. Get Specific Course Statistics



***Endpoint:***

```bash
Method: GET
Type: 
URL: localhost:8080/courses/0
```



### 4. Post Course



***Endpoint:***

```bash
Method: POST
Type: FORMDATA
URL: localhost:8080/courses
```


***Headers:***

| Key | Value | Description |
| --- | ------|-------------|
| firstname | John |  |
| lastname | Doe |  |



***Body:***

| Key | Value | Description |
| --- | ------|-------------|
| name | New course |  |
| startTime | 11:00 |  |
| endTime | 12:00 |  |
| teacher | 0 |  |



### 5. Update Course



***Endpoint:***

```bash
Method: PUT
Type: RAW
URL: localhost:8080/courses/5
```


***Headers:***

| Key | Value | Description |
| --- | ------|-------------|
| Content-Type | application/json |  |



***Body:***

```js        
{
	"name": "Updated course",
	"startTime": "14:00",
	"endTime": "15:00",
	"teacher": {
        "id": 0,
        "firstname": "Juha",
        "lastname": "Hinkula"
    }
}
```



### 6. Delete Course



***Endpoint:***

```bash
Method: DELETE
Type: 
URL: localhost:8080/courses/5
```



## Documentation



### 1. Get Documentation



***Endpoint:***

```bash
Method: GET
Type: 
URL: 
```



## Enrollments



### 1. Get Enrollments



***Endpoint:***

```bash
Method: GET
Type: 
URL: localhost:8080/enrollments
```



### 2. Get Specific Enrollment



***Endpoint:***

```bash
Method: GET
Type: 
URL: localhost:8080/courses/0
```



### 3. Get Enrollments by Student



***Endpoint:***

```bash
Method: GET
Type: 
URL: 
```



### 4. Get Enrollments by Course



***Endpoint:***

```bash
Method: GET
Type: 
URL: 
```



### 5. Post Enrollment



***Endpoint:***

```bash
Method: POST
Type: FORMDATA
URL: localhost:8080/courses
```


***Headers:***

| Key | Value | Description |
| --- | ------|-------------|
| firstname | John |  |
| lastname | Doe |  |



***Body:***

| Key | Value | Description |
| --- | ------|-------------|
| name | New course |  |
| startTime | 11:00 |  |
| endTime | 12:00 |  |
| teacher | 0 |  |



### 6. Update Enrollment



***Endpoint:***

```bash
Method: PUT
Type: RAW
URL: localhost:8080/enrollments/5
```


***Headers:***

| Key | Value | Description |
| --- | ------|-------------|
| Content-Type | application/json |  |



***Body:***

```js        
{
	"name": "Updated course",
	"startTime": "14:00",
	"endTime": "15:00",
	"teacher": {
        "id": 0,
        "firstname": "Juha",
        "lastname": "Hinkula"
    }
}
```



### 7. Delete Enrollment



***Endpoint:***

```bash
Method: DELETE
Type: 
URL: localhost:8080/courses/5
```



## Students



### 1. Get Students



***Endpoint:***

```bash
Method: GET
Type: 
URL: localhost:8080/students
```



### 2. Get Specific Student



***Endpoint:***

```bash
Method: GET
Type: 
URL: localhost:8080/students/1
```



### 3. Get Specific Student Statistics



***Endpoint:***

```bash
Method: GET
Type: 
URL: localhost:8080/students/0/stats
```



### 4. Post Student



***Endpoint:***

```bash
Method: POST
Type: FORMDATA
URL: localhost:8080/students
```


***Headers:***

| Key | Value | Description |
| --- | ------|-------------|
| firstname | John |  |
| lastname | Doe |  |



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| firstname | John |  |
| lastname | Doe |  |



***Body:***

| Key | Value | Description |
| --- | ------|-------------|
| firstname | John |  |
| lastname | Doe |  |



### 5. Update Student



***Endpoint:***

```bash
Method: PUT
Type: RAW
URL: localhost:8080/students/3
```


***Headers:***

| Key | Value | Description |
| --- | ------|-------------|
| Content-Type | application/json |  |



***Body:***

```js        
{
	"firstname": "Jacky",
	"lastname": "Chan"
}
```



### 6. Delete Student



***Endpoint:***

```bash
Method: DELETE
Type: 
URL: localhost:8080/students/14
```



## Teachers



### 1. Get Teachers



***Endpoint:***

```bash
Method: GET
Type: 
URL: localhost:8080/teachers
```



### 2. Get Specific Teacher



***Endpoint:***

```bash
Method: GET
Type: 
URL: localhost:8080/teachers/0
```



### 3. Post Teacher



***Endpoint:***

```bash
Method: POST
Type: FORMDATA
URL: localhost:8080/teachers
```


***Headers:***

| Key | Value | Description |
| --- | ------|-------------|
| firstname | John |  |
| lastname | Doe |  |



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| firstname | John |  |
| lastname | Doe |  |



***Body:***

| Key | Value | Description |
| --- | ------|-------------|
| firstname | John |  |
| lastname | Doe |  |



### 4. Update Teacher



***Endpoint:***

```bash
Method: PUT
Type: RAW
URL: localhost:8080/teachers/3
```


***Headers:***

| Key | Value | Description |
| --- | ------|-------------|
| Content-Type | application/json |  |



***Body:***

```js        
{
	"firstname": "Jacky",
	"lastname": "Chan"
}
```



### 5. Delete Teacher



***Endpoint:***

```bash
Method: DELETE
Type: 
URL: localhost:8080/students/3
```



---
[Back to top](#backend-project)
> Made with &#9829; by [thedevsaddam](https://github.com/thedevsaddam) | Generated at: 2019-12-10 04:17:48 by [docgen](https://github.com/thedevsaddam/docgen)

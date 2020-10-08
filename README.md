# taskmanager-api

## These are some basic information for requesting this api.

### URL
https://whenes-taskmanager-api.herokuapp.com/api

### Methods
`GET`|`POST`|`PUT`|`DELETE`

### Valids resources
`/task`

## Sample call
This request: *GET https://whenes-taskmanager-api.herokuapp.com/api/task*

Results in this response:
`[
  {
    "id": 1,
    "title": "Task One",
    "description": "First generated task from the board.",
    "status": "TODO"
  },
  {
    "id": 3,
    "title": "Task two",
    "description": "second generated task from the board.",
    "status": "DONE"
  },
  {
    "id": 4,
    "title": "Task 4",
    "description": "Description task 4",
    "status": "DONE"
  }
]`

### This request: *POST https://whenes-taskmanager-api.herokuapp.com/api/task*
With this JSON body: 
`{
	"title": "Task testing title",
	"description": "Testing generated task from the board.",
	"status": "TODO"
}`

Results in this response:
`{
  "id": 3,
  "title": "Task One",
  "description": "third generated task from the board.",
  "status": "TODO"
}`

### This request: *PUT https://whenes-taskmanager-api.herokuapp.com/api/task*
With this JSON body: 
`{
  "id": 1,
  "title": "Task update datas",
  "description": "Testing update",
  "status": "DONE"
}`

Results in this response:
`{
  "id": 1,
  "title": "Task update datas",
  "description": "Testing update",
  "status": "DONE"
}`

### This request: *DELETE https://whenes-taskmanager-api.herokuapp.com/api/task/3*

Results in this response:
`Task successfully removed!`

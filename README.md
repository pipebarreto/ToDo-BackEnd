# ToDo-BackEnd Project including JWT

For Running the code, you can simply download the file and run it on Eclipse.

REST API

# POST /signup
For creating a user (Use email and password).

# POST /login
For login in the system. The system will return a JWT token which available for an hour. This JWT is required for making any request to server.
You can test it with "email":"diego@test.com" & "password":"diego".

# PUT /changePassword
Change the user's password by sending a String.

# GET /todos?status=[status]
Get a list based on the status of the item. This is a query param and and if its not present, the program will return all items.

# POST /todos
Create a new item.

# PUT /todos/:id
Update the todo Item. If the id is not found, the programm will return nothing. 

# DELETE todos/:id
Delete todo item.

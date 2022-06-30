# ToDo-BackEnd Project including JWT

For Running the code, you can simply download the file and run it on Eclipse.

REST API

# POST /signup
For creating a user (Use email and password). The data will be saved and the password will be encrypted.

# POST /login
For login in the system. The system will return a JWT token which available for an hour. This JWT is required for making any request to server.
You can test it with "email":"diego@test.com" & "password":"diego".

# GET /users
The program will return all users.

# PUT /changePassword
Change the user's password by sending a String.

# GET /todos?status=[status]
Get a list based on the status of the item (OnGoing, Completed, NotStarted). This is a query param and and if its not present, the program will return all items.

# GET /todos/id
Get the details of an specific item.

# POST /todos
Create a new item. The Owner of the item will be automatically assigned to the user who posted the item.

# PUT /todos/:id
Update a todo item. If id is not found, the programm will return nothing. 

# DELETE todos/:id
Delete todo item.


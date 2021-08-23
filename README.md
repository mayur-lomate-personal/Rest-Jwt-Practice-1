In this project, I have created a Rest Server, which uses JWT For Authorization, and the project contains two authorities, user and admin, User can access only user allowed access points and admin can access only admin allowed access points.
The Session is stateless and authorization is done using JWT. Currently admin and user is decided based on username.
The Rest endpoints are as follows :- 

GET /api/admin :- only admin can access
GET /api/user :- both user and admin can access
POST /api/register/user :- For registering a new user.
POST /api/jwt :- For getting jwt token


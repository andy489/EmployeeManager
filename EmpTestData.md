```json

// POST [Save Employee]
// http://localhost:8080/api/emp
// BODY
{
    "firstName": "Andrey",
    "lastName": "Stoev",
    "email": "stoev.andy@gmail.com",
    "phone": "+3590887123456",
    "hireDate": "2022-04-26T09:30:00.000000",
    "salary": 1234.0,
    "topSkill": "Combinatorics",
    
    "jobCode": "123ER", // internal code of job "GAME CONFIGURATOR" with id 8
    "orgCode": "XZBBZ"  // internal code of organization "Evolution" with id 3
}

// CAUSES STACKOVERFLOW EXCEPTION <- cannot fix
```
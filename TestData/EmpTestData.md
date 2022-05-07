```json
// GET [Get Employee Entity Template]
// http://localhost:8080/api/emp/template
// RESPONSE
{
    "id": 0,
    "firstName": "test-first-name",
    "lastName": "test-last-name",
    "email": "test-email",
    "phone": "test-phone",
    "hireDate": "2022-05-07T00:23:32.739759",
    "salary": 0.0,
    "topSkill": "test-top-skill",
    "timeCreated": "2022-05-07T00:23:32.73978",
    "job": {
        "id": 0,
        "name": "test-name",
        "description": "test-description",
        "minimalSalary": 0,
        "internalCode": "test-internal-code",
        "employees": [],
        "timeCreated": "2022-05-07T00:23:32.739794"
    },
    "org": {
        "id": 0,
        "name": "test-name",
        "website": "test-web-site",
        "internalCode": "test-internal-code",
        "employees": [],
        "timeCreated": "2022-05-07T00:23:32.739804"
    }
}

// POST [Save Employee]
// http://localhost:8080/api/emp
// BODY
{
    "firstName": "Andrey",
    "lastName": "Stoev",
    "email": "stoev.andy@gmail.com",
    "phone": "+3590887123456",
    "hireDate": "2022-04-26T09:30:00.000000",
    "salary": 5650.0,
    "topSkill": "Statistics",
    
    "jobCode": "GCNF",
    "orgCode": "E7O"
}
// RESPONSE
{
    "id": 1,
    "firstName": "Andrey",
    "lastName": "Stoev",
    "email": "stoev.andy@gmail.com",
    "phone": "+3590887123456",
    "hireDate": "2022-04-26T09:30:00",
    "salary": 5650.0,
    "topSkill": "Statistics",
    "jobDTO": {
        "name": "GAME CONFIGURATOR",
        "description": "Creat, design and configure games.",
        "minimalSalary": 3655,
        "internalCode": "GCNF"
    },
    "orgDTO": {
        "name": "Evolution",
        "website": "www.evolution.com",
        "internalCode": "E7O"
    }
}
```
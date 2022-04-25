```json
// GET [Get Organization Entity Template]
// http://localhost:8080/api/org/template
// RESPONSE
{
    "id": 0,
    "name": "test-name",
    "website": "test-web-site",
    "internalCode": "test-internal-code",
    "employees": [],
    "timeCreated": "2022-04-25T09:43:20.079584"
}

// POST [Save Single Organization]
// http://localhost:8080/api/org
// BODY
{
    "name": "Uber",
    "website": "www.uber.com",
    "internalCode": "TBN1E",
    "employees": []
}

// POST [Save Multiple Organizations]
// http://localhost:8080/api/org
// BODY
[
    {
        "name": "Dreamix",
        "website": "www.dreamix.eu",
        "internalCode": "UGHZQ",
        "employees": []
    },

    {
        "name": "Evolution",
        "website": "www.evolution.com",
        "internalCode": "XZBBZ",
        "employees": []
    },

    {
        "name": "IBM",
        "website": "www.ibm.com",
        "internalCode": "PYTTT",
        "employees": []
    },

    {
        "name": "Oracle",
        "website": "www.oracle.com",
        "internalCode": "2K33L",
        "employees": []
    },

    {
        "name": "VM Ware",
        "website": "www.vmware.com",
        "internalCode": "55THJ",
        "employees": []
    }
]

// GET [List All Organizations]
// http://localhost:8080/api/org
// RESPONSE
[
    {
        "name": "Uber",
        "website": "www.uber.com",
        "employees": [],
        "internalCode": "TBN1E"
    },
    {
        "name": "Dreamix",
        "website": "www.dreamix.eu",
        "employees": [],
        "internalCode": "UGHZQ"
    },
    {
        "name": "Evolution",
        "website": "www.evolution.com",
        "employees": [],
        "internalCode": "XZBBZ"
    },
    {
        "name": "IBM",
        "website": "www.ibm.com",
        "employees": [],
        "internalCode": "PYTTT"
    },
    {
        "name": "Oracle",
        "website": "www.oracle.com",
        "employees": [],
        "internalCode": "2K33L"
    },
    {
        "name": "VM Ware",
        "website": "www.vmware.com",
        "employees": [],
        "internalCode": "55THJ"
    }
]

// GET [Get Organization By Id]
// http://localhost:8080/api/org/id/2
// RESPONSE
{
    "name": "Dreamix",
    "website": "www.dreamix.eu",
    "employees": [],
    "internalCode": "UGHZQ",
    "id": 2
}

// GET [Get Organization By Internal Code]
// http://localhost:8080/api/org/code/XZBBZ
// RESPONSE
{
    "name": "Evolution",
    "website": "www.evolution.com",
    "employees": [],
    "internalCode": "XZBBZ"
}

// PATCH [Update Organization By Id Partially]
// http://localhost:8080/api/org/2
// BODY 
{
    "internalCode": "AB123",
}
// RESPONSE
{
    "name": "Dreamix",
    "website": "www.dreamix.eu",
    "employees": [],
    "internalCode": "AB123",
    "id": 2
}

// PUT [Update Organization]
// http://localhost:8080/api/org
// BODY
{
    "name": "Dreamix",
    "website": "www.dreamix.eu",
    "employees": [],
    "internalCode": "AB123",
    "id": 2
}

// DELETE [Delete Organization By Id]
// http://localhost:8080/api/org/10
// RESPONSE [404]
{
    "timestamp": "2022-04-25T06:53:13.423+00:00",
    "status": 404,
    "error": "Not Found",
    "path": "/api/org/10"
}
```
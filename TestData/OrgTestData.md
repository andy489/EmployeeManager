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
    "timeCreated": "2022-05-07T00:20:28.235701"
}

// POST [Save Single Organization]
// http://localhost:8080/api/org
// BODY
{
    "name": "Uber",
    "website": "www.uber.com",
    "internalCode": "UBE"
}

// POST [Save Multiple Organizations]
// http://localhost:8080/api/org
// BODY
[
    {
        "name": "Dreamix",
        "website": "www.dreamix.eu",
        "internalCode": "DRE"
    },

    {
        "name": "Evolution",
        "website": "www.evolution.com",
        "internalCode": "EVO"
    },

    {
        "name": "IBM",
        "website": "www.ibm.com",
        "internalCode": "IBM"
    },

    {
        "name": "Oracle",
        "website": "www.oracle.com",
        "internalCode": "ORA"
    },

    {
        "name": "VM Ware",
        "website": "www.vmware.com",
        "internalCode": "VMW"
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
        "internalCode": "UBE"
    },
    {
        "name": "Dreamix",
        "website": "www.dreamix.eu",
        "employees": [],
        "internalCode": "DRE"
    },
    {
        "name": "Evolution",
        "website": "www.evolution.com",
        "employees": [],
        "internalCode": "EVO"
    },
    {
        "name": "IBM",
        "website": "www.ibm.com",
        "employees": [],
        "internalCode": "IBM"
    },
    {
        "name": "Oracle",
        "website": "www.oracle.com",
        "employees": [],
        "internalCode": "ORA"
    },
    {
        "name": "VM Ware",
        "website": "www.vmware.com",
        "employees": [],
        "internalCode": "VMW"
    }
]

// GET [Get Organization By Id]
// http://localhost:8080/api/org/id/2
// RESPONSE
{
    "name": "Dreamix",
    "website": "www.dreamix.eu",
    "employees": [],
    "internalCode": "DRE",
    "id": 2
}

// GET [Get Organization By Internal Code]
// http://localhost:8080/api/org/code/DRE
// RESPONSE
{
    "name": "Dreamix",
    "website": "www.dreamix.eu",
    "employees": [],
    "internalCode": "DRE"
}

// PATCH [Update Organization By Id Partially]
// http://localhost:8080/api/org/3
// BODY 
{
    "internalCode": "E70",
}
// RESPONSE
{
    "name": "Evolution",
    "website": "www.evolution.com",
    "employees": [],
    "internalCode": "E7O",
    "id": 3
}

// DELETE [Delete Organization By Id]
// http://localhost:8080/api/org/6
~Organization "VM Ware" with id 6 was deleted successfully.
```
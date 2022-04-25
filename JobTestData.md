```json
// GET [Get Job Entity Template]
// http://localhost:8080/api/job/template
// RESPONSE
{
    "id": 0,
    "name": "test-name",
    "description": "test-description",
    "minimalSalary": 0,
    "internalCode": "test-internal-code",
    "employees": [],
    "timeCreated": "2022-04-24T23:57:29.838219"
}

// POST [Save Single Job]
// http://localhost:8080/api/job
// BODY
{
    "name": "TEST-IT ENGINEER",
    "description": "Test desctiprion. Test description. Test description.",
    "minimalSalary": 1000,
    "internalCode": "JXP1Y",
    "employees": []
}

// POST [Save Multiple Jobs]
// http://localhost:8080/api/jobs
// BODY
[
    {
        "name": "CYBER SECURITY ENGINEER",
        "description": "Planning, implementing, managing, monitoring, and upgrading security measures for the protection of the organization's data, systems, and networks; Troubleshooting security and network problems; etc.",
        "minimalSalary": 2200,
        "internalCode" : "P13UZ",
        "employees": []
    },

    {
        "name": "WEB DEVELOPER",
        "description": "Creating website layout/user interfaces by using standard HTML/CSS practices; Integrating data from various back-end services and databases; etc.",
        "minimalSalary": 2300,
        "internalCode" : "WE3IX",
        "employees": []
    },

    {
        "name": "DATA ENGINEER",
        "description": "Managing end-to-end data pipelines to source and transform data to the Data & Analytics Platform(s); Integrating new data sources (internal and external) by creating a full pipeline from ingestion to ETL process",
        "minimalSalary": 2900,
        "internalCode" : "A31KL",
        "employees": []
    },

    {
        "name": "PHP DEVELOPER",
        "description": "Writing clean, fast PHP to a high standard, in a timely and scalable way; Producing detailed specifications; etc.",
        "minimalSalary": 2700,
        "internalCode" : "7HJ21",
        "employees": []
    },

    {
        "name": "SENIOR RUBY DEVELOPER",
        "description": "Writing effective and scalable code in Ruby; Building back-end components for web applications; Testing applications for performance, responsiveness and security; etc.",
        "minimalSalary": 3450,
        "internalCode" : "CV4S5",
        "employees": []
    },

    {
        "name": "DEVOPS ENGINEER",
        "description": "Implementing integrations requested by customers; Deploying updates and fixes; Providing Level 2 technical support; etc.",
        "minimalSalary": 3900,
        "internalCode" : "LT6RX",
        "employees": []
    }
]

// GET [List All Jobs]
// http://localhost:8080/api/job
// RESPONSE

[
    {
        "name": "TEST-IT ENGINEER",
        "description": "Test desctiprion. Test description. Test description.",
        "minimalSalary": 1000,
        "employees": [],
        "internalCode": "JXP1Y"
    },
    {
        "name": "CYBER SECURITY ENGINEER",
        "description": "Planning, implementing, managing, monitoring, and upgrading security measures for the protection of the organization's data, systems, and networks; Troubleshooting security and network problems; etc.",
        "minimalSalary": 2200,
        "employees": [],
        "internalCode": "P13UZ"
    },
    {
        "name": "WEB DEVELOPER",
        "description": "Creating website layout/user interfaces by using standard HTML/CSS practices; Integrating data from various back-end services and databases; etc.",
        "minimalSalary": 2300,
        "employees": [],
        "internalCode": "WE3IX"
    },
    {
        "name": "DATA ENGINEER",
        "description": "Managing end-to-end data pipelines to source and transform data to the Data & Analytics Platform(s); Integrating new data sources (internal and external) by creating a full pipeline from ingestion to ETL process",
        "minimalSalary": 2900,
        "employees": [],
        "internalCode": "A31KL"
    },
    {
        "name": "PHP DEVELOPER",
        "description": "Writing clean, fast PHP to a high standard, in a timely and scalable way; Producing detailed specifications; etc.",
        "minimalSalary": 2700,
        "employees": [],
        "internalCode": "7HJ21"
    },
    {
        "name": "SENIOR RUBY DEVELOPER",
        "description": "Writing effective and scalable code in Ruby; Building back-end components for web applications; Testing applications for performance, responsiveness and security; etc.",
        "minimalSalary": 3450,
        "employees": [],
        "internalCode": "CV4S5"
    },
    {
        "name": "DEVOPS ENGINEER",
        "description": "Implementing integrations requested by customers; Deploying updates and fixes; Providing Level 2 technical support; etc.",
        "minimalSalary": 3900,
        "employees": [],
        "internalCode": "LT6RX"
    }
]

// GET [Get Job By Id]
// http://localhost:8080/api/job/7
// RESPONSE
{
    "name": "DEVOPS ENGINEER",
    "description": "Implementing integrations requested by customers; Deploying updates and fixes; Providing Level 2 technical support; etc.",
    "minimalSalary": 3900,
    "employees": [],
    "internalCode": "LT6RX",
    "id": 7
}

// GET [Get Job By Internal Code]
// http://localhost:8080/api/job/code/CV4S5
// RESPONSE
{
    "name": "SENIOR RUBY DEVELOPER",
    "description": "Writing effective and scalable code in Ruby; Building back-end components for web applications; Testing applications for performance, responsiveness and security; etc.",
    "minimalSalary": 3450,
    "employees": [],
    "internalCode": "CV4S5"
}

// GET [Get Job By Keyword(s)]
// http://localhost:8080/api/job/keywords?word=data,end
// http://localhost:8080/api/job/keywords?word=data&word=end
// Comment: Query parameters are optional, i.e. http://localhost:8080/api/job/keywords is equal to http://localhost:8080/api/job
// RESPONSE
[
    {
        "name": "WEB DEVELOPER",
        "description": "Creating website layout/user interfaces by using standard HTML/CSS practices; Integrating data from various back-end services and databases; etc.",
        "minimalSalary": 2300,
        "employees": [],
        "internalCode": "WE3IX"
    },
    {
        "name": "DATA ENGINEER",
        "description": "Managing end-to-end data pipelines to source and transform data to the Data & Analytics Platform(s); Integrating new data sources (internal and external) by creating a full pipeline from ingestion to ETL process",
        "minimalSalary": 2900,
        "employees": [],
        "internalCode": "A31KL"
    }
]

// GET [Get Average Minimal Salary for All Jobs]
// http://localhost:8080/api/job/a
// RESPONSE
2635.71

// GET [Get Job with Minimal Salary at Least X]
// http://localhost:8080/api/job/s/3000
// RESPONSE
[
    {
        "name": "SENIOR RUBY DEVELOPER",
        "description": "Writing effective and scalable code in Ruby; Building back-end components for web applications; Testing applications for performance, responsiveness and security; etc.",
        "minimalSalary": 3450,
        "employees": [],
        "internalCode": "CV4S5"
    },
    {
        "name": "DEVOPS ENGINEER",
        "description": "Implementing integrations requested by customers; Deploying updates and fixes; Providing Level 2 technical support; etc.",
        "minimalSalary": 3900,
        "employees": [],
        "internalCode": "LT6RX"
    }
]

// PATCH [Update Job By Id Partially]
// http://localhost:8080/api/job/7
// BODY
{
    "internalCode": "LT6RR"
}
// RESPONSE
{
    "name": "DEVOPS ENGINEER",
    "description": "Implementing integrations requested by customers; Deploying updates and fixes; Providing Level 2 technical support; etc.",
    "minimalSalary": 3900,
    "employees": [],
    "internalCode": "LT6RR",
    "id": 7
}

// DELETE [Delete Job By Id]
// http://localhost:8080/api/job/7
// RESPONSE
[200 OK] ~Job with id %d was deleted successfully.

// POST [Save Single Job]
// http://localhost:8080/api/job
// BODY
{
    "name": "GAME CONFIGURATOR",
    "description": "Creat, design and provide proofs for Game required Parameters",
    "minimalSalary": 987,
    "internalCode": "123ER",
    "employees": []
}
```
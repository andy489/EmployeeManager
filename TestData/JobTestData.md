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
    "timeCreated": "2022-05-07T00:15:26.85136"
}

// POST [Save Single Job]
// http://localhost:8080/api/job
// BODY
{
    "name": "GAME CONFIGURATOR",
    "description": "Creat, design and configure games.",
    "minimalSalary": 2222,
    "internalCode": "GCNF"
}

// POST [Save Multiple Jobs]
// http://localhost:8080/api/jobs
// BODY
[
    {
        "name": "CYBER SECURITY ENGINEER",
        "description": "Planning, implementing, managing, monitoring, and upgrading security measures for the protection of the organization's data, systems, and networks; Troubleshooting security and network problems; etc.",
        "minimalSalary": 4230,
        "internalCode" : "CSCENG"
    },

    {
        "name": "WEB DEVELOPER",
        "description": "Creating website layout/user interfaces by using standard HTML/CSS practices; Integrating data from various back-end services and databases; etc.",
        "minimalSalary": 2770,
        "internalCode" : "WBDVP"
    },

    {
        "name": "DATA ENGINEER",
        "description": "Managing end-to-end data pipelines to source and transform data to the Data & Analytics Platform(s); Integrating new data sources (internal and external) by creating a full pipeline from ingestion to ETL process",
        "minimalSalary": 3900,
        "internalCode" : "DTENG"
    },

    {
        "name": "PHP DEVELOPER",
        "description": "Writing clean, fast PHP to a high standard, in a timely and scalable way; Producing detailed specifications; etc.",
        "minimalSalary": 4700,
        "internalCode" : "PHPDVP"
    },

    {
        "name": "SENIOR RUBY DEVELOPER",
        "description": "Writing effective and scalable code in Ruby; Building back-end components for web applications; Testing applications for performance, responsiveness and security; etc.",
        "minimalSalary": 5450,
        "internalCode" : "SRDVP"

    },

    {
        "name": "DEVOPS ENGINEER",
        "description": "Implementing integrations requested by customers; Deploying updates and fixes; Providing Level 2 technical support; etc.",
        "minimalSalary": 5900,
        "internalCode" : "DVPSDVP"
    }
]

// GET [List All Jobs]
// http://localhost:8080/api/job
// RESPONSE
[
    {
        "name": "GAME CONFIGURATOR",
        "description": "Creat, design and configure games.",
        "minimalSalary": 2222,
        "employees": [],
        "internalCode": "GCNF"
    },
    {
        "name": "CYBER SECURITY ENGINEER",
        "description": "Planning, implementing, managing, monitoring, and upgrading security measures for the protection of the organization's data, systems, and networks; Troubleshooting security and network problems; etc.",
        "minimalSalary": 4230,
        "employees": [],
        "internalCode": "CSCENG"
    },
    {
        "name": "WEB DEVELOPER",
        "description": "Creating website layout/user interfaces by using standard HTML/CSS practices; Integrating data from various back-end services and databases; etc.",
        "minimalSalary": 2770,
        "employees": [],
        "internalCode": "WBDVP"
    },
    {
        "name": "DATA ENGINEER",
        "description": "Managing end-to-end data pipelines to source and transform data to the Data & Analytics Platform(s); Integrating new data sources (internal and external) by creating a full pipeline from ingestion to ETL process",
        "minimalSalary": 3900,
        "employees": [],
        "internalCode": "DTENG"
    },
    {
        "name": "PHP DEVELOPER",
        "description": "Writing clean, fast PHP to a high standard, in a timely and scalable way; Producing detailed specifications; etc.",
        "minimalSalary": 4700,
        "employees": [],
        "internalCode": "PHPDVP"
    },
    {
        "name": "SENIOR RUBY DEVELOPER",
        "description": "Writing effective and scalable code in Ruby; Building back-end components for web applications; Testing applications for performance, responsiveness and security; etc.",
        "minimalSalary": 5450,
        "employees": [],
        "internalCode": "SRDVP"
    },
    {
        "name": "DEVOPS ENGINEER",
        "description": "Implementing integrations requested by customers; Deploying updates and fixes; Providing Level 2 technical support; etc.",
        "minimalSalary": 5900,
        "employees": [],
        "internalCode": "DVPSDVP"
    }
]

// GET [Get Job By Id]
// http://localhost:8080/api/job/1
// RESPONSE
{
    "name": "GAME CONFIGURATOR",
    "description": "Creat, design and configure games.",
    "minimalSalary": 2222,
    "employees": [],
    "internalCode": "GCNF",
    "id": 1
}

// GET [Get Job By Internal Code]
// http://localhost:8080/api/job/code/SRDVP
// RESPONSE
{
    "name": "SENIOR RUBY DEVELOPER",
    "description": "Writing effective and scalable code in Ruby; Building back-end components for web applications; Testing applications for performance, responsiveness and security; etc.",
    "minimalSalary": 5450,
    "employees": [],
    "internalCode": "SRDVP"
}

// GET [Get Job By Keyword(s)]
// http://localhost:8080/api/job/keywords?words=data&end
// Comment: Query parameters are optional, i.e. http://localhost:8080/api/job/keywords is equivalent to http://localhost:8080/api/job
// RESPONSE
[
    {
        "name": "CYBER SECURITY ENGINEER",
        "description": "Planning, implementing, managing, monitoring, and upgrading security measures for the protection of the organization's data, systems, and networks; Troubleshooting security and network problems; etc.",
        "minimalSalary": 4230,
        "employees": [],
        "internalCode": "CSCENG"
    },
    {
        "name": "WEB DEVELOPER",
        "description": "Creating website layout/user interfaces by using standard HTML/CSS practices; Integrating data from various back-end services and databases; etc.",
        "minimalSalary": 2770,
        "employees": [],
        "internalCode": "WBDVP"
    },
    {
        "name": "DATA ENGINEER",
        "description": "Managing end-to-end data pipelines to source and transform data to the Data & Analytics Platform(s); Integrating new data sources (internal and external) by creating a full pipeline from ingestion to ETL process",
        "minimalSalary": 3900,
        "employees": [],
        "internalCode": "DTENG"
    }
]

// GET [Get Average Minimal Salary for All Jobs]
// http://localhost:8080/api/job/a
// RESPONSE
4167.43

// GET [Get Job with Minimal Salary at Least X]
// http://localhost:8080/api/job/s/500
// RESPONSE
[
    {
        "name": "SENIOR RUBY DEVELOPER",
        "description": "Writing effective and scalable code in Ruby; Building back-end components for web applications; Testing applications for performance, responsiveness and security; etc.",
        "minimalSalary": 5450,
        "employees": [],
        "internalCode": "SRDVP"
    },
    {
        "name": "DEVOPS ENGINEER",
        "description": "Implementing integrations requested by customers; Deploying updates and fixes; Providing Level 2 technical support; etc.",
        "minimalSalary": 5900,
        "employees": [],
        "internalCode": "DVPSDVP"
    }
]

// PATCH [Update Job By Id Partially]
// http://localhost:8080/api/job/1
// BODY
{
    "minimalSalary": 3655
}
// RESPONSE
{
    "name": "GAME CONFIGURATOR",
    "description": "Creat, design and configure games.",
    "minimalSalary": 3655,
    "employees": [],
    "internalCode": "GCNF",
    "id": 1
}

// DELETE [Delete Job By Id]
// http://localhost:8080/api/job/6
// RESPONSE
[200 OK] ~Job "SENIOR RUBY DEVELOPER" with id 6 was deleted successfully.
```
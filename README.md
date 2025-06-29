# CS320

How can I ensure that my code, program, or software is functional and secure?

To ensure that my code, program, or software is functional, I employ comprehensive unit testing, as demonstrated in this project with JUnit tests for each service (Contact, Task, Appointment). These tests cover all specified requirements, including edge cases and boundary conditions, which helps in verifying functionality. For security, I follow best practices like input validation to prevent injection attacks, use secure coding guidelines to avoid common vulnerabilities, and keep dependencies updated to mitigate known security issues. For example, in the 'Contact' class, I ensure that the phone number format is strictly validated to prevent malformed data entry, which could potentially be exploited.

How do I interpret user needs and incorporate them into a program?

Interpreting user needs involves active communication with stakeholders, often through requirement gathering sessions or user stories in agile methodologies. For this project, I translated the customer's requirements into specific class and service constraints. For instance, the need for a unique identifier for each object (contact, task, appointment) was directly incorporated into the design by making IDs immutable and unique. I also ensure that the constraints on fields like name lengths or date validations reflect practical user scenarios, preventing user errors and enhancing usability.

How do I approach designing software?

My approach to software design starts with understanding the problem domain thoroughly, which in this case involved the management of contacts, tasks, and appointments. I then apply object-oriented design principles, creating classes ('Contact', 'Task', 'Appointment') that encapsulate data and behavior. For services ('ContactService', 'TaskService', 'AppointmentService'), I design them to handle operations like add, update, and delete, using in-memory structures for simplicity. I focus on modularity, ensuring each component is loosely coupled yet cohesive, which facilitates testing and maintenance. Design patterns like the Singleton for service classes might be considered for managing global state if needed, though not implemented in this project due to its scope. I also prioritize simplicity and clarity, avoiding over-engineering while ensuring the design is extensible for future enhancements.

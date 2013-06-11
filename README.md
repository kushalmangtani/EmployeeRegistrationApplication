EmployeeRegisterBean:This project has an EmpRegBean( i.e a POJO class for the Employee Registration Form ) so that the entire Form can be passed as an Object.
Technologies:Java 1.6,JavaBean

EmployeeRegistrationService:This project has the business logic for Adding a new Employee,View Employee Details,Deleting an Employee and Searching for an Employee(Searching functionality is published as a Web Service)
Technologies:Java 1.6,EJB 3.1,Hibernate 4.0,MySQL 5,SOAP WebService

EmployeeRegisterWebModule:This web project has the source code required for EmployeeRegistration Web Application.
Technologies:Java EE,Spring MVC 3.0,JNDI

Modularizing the EmployeeRegisterBean,EmployeeRegistrationService and EmployeeRegisterWebModule into seperate projects  makes the maintainance of the application simpler.
In the future,If we want to change the implementation of either of the modules(EmployeeRegisterBean,EmployeeRegistrationService and EmployeeRegisterWebModule);we only have to update that module;the others remain unaffected.Thus,this modularization,SOA design will increase the lifecycle of the project

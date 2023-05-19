// class : capital case : 1st letter capital
// variables : camel case : 1st letter small
var i = 0;
var Employee = /** @class */ (function () {
    function Employee() {
        console.log("in def constructor");
        this.empId = 0;
        this.empName = "ADII";
        this.empSalary = 1000;
    }
    return Employee;
}()); // Employee body ended
var emp1;
emp1 = new Employee(); // def constructor
console.log(emp1.empId);
console.log(emp1.empName);
console.log(emp1.empSalary);
var emp2 = new Employee();

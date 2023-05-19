var Employee = /** @class */ (function () {
    /*     constructor(id:number,name:string,sal:number ){
           console.log("in p constructor");
           this.empId=id;
           this.empName=name;
           this.empSalary=sal;
       }  */
    //Multiple constructor implementations are not allowed.
    function Employee(id, name, salary) {
        if (id === void 0) { id = 0; }
        if (name === void 0) { name = "ADII"; }
        if (salary === void 0) { salary = 1000; }
        this.empId = id;
        this.empName = name;
        this.empSalary = salary;
    }
    return Employee;
}()); // Employee body ended
var emp1;
emp1 = new Employee(345, "Adii", 45000); // def constructor
console.log(emp1.empId);
console.log(emp1.empName);
console.log(emp1.empSalary);
var emp2 = new Employee(111, "Yashashree", 56000);
console.log(JSON.stringify(emp2));
var emp3 = new Employee(); // 0-conr
console.log(JSON.stringify(emp3));
var emp4 = new Employee(321, "Shraddha"); // p-conr
console.log(JSON.stringify(emp4));

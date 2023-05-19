// class : capital case : 1st letter capital
// variables : camel case : 1st letter small
let i=0;

class Employee {    
    empId:number; 
    empName:string;
    empSalary:number;

    constructor(){
        console.log("in def constructor");   
        this.empId=0; 
        this.empName="ADII";
        this.empSalary=1000;
    }
    //Multiple constructor implementations are not allowed.
}// Employee body ended

let emp1:Employee;
emp1=new Employee(); // def constructor
console.log(emp1.empId);
console.log(emp1.empName);
console.log(emp1.empSalary);

let emp2=new Employee();
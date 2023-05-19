let mobile:number;    // strongly typed
// :number : annotations

mobile=45566;
//mobile="hello"; // error
//mobile=false;   // error
console.log(mobile);


let companyName:any;
companyName="neo";
companyName=78999;
companyName=true;
console.log(companyName);



let age=56;
//age="hi";

let gender;
gender="female";
let l1=(<string>gender).length

let cname="Neo";
let l2=cname.length
import {Address} from './Employee';
export class Employee {
Name: string;
EmployeeId : Number;
Department : string;
Address : Address = new Address();

constructor() {
this.Name = "";
this.EmployeeId = 123;
this.Department = "";
}

}

export class Address{
Street: string;
State : string;
Pincode: Number;

constructor() {
this.Street = "";
this.State = "";
this.Pincode = 123;
}

}
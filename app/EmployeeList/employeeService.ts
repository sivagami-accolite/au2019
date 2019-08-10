import {Injectable} from '@angular/core';
import {Http, Response, Headers, RequestOptions, RequestMethod} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import {Employee, Address} from './Employee'
import 'rxjs/Rx'

@Injectable()
export class EmployeeService{
  //include appropriate API url
//public employeeListUrl = 'http://localhost:52467/Employee/EmployeeList';
public employeeListUrl = 'app/EmployeeList/Employee.json';
//public employeeDetailsUrl = 'http://localhost:52467/Employee/EmployeeDetails';
public employeeDetailsUrl = 'app/EmployeeList/address.json'
public employeeAddUrl = 'http://localhost:52467/Employee/EmployeeAdd'
constructor(public _http: Http){

}

getEmployees():Observable<Employee[]>{
return this._http.get(this.employeeListUrl)
.map((response:Response) => <Employee[]> response.json());
}

findAddressById(id):Observable<Address>{
//return this._http.get(this.employeeDetailsUrl + '/'+ id)
//.map((response:Response) => <Address> response.json());
return this._http.get(this.employeeDetailsUrl)
.map((response:Response) => <Address> response.json());

}

AddEmployee(employee){
	let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({
	 method: RequestMethod.Post,
	 headers: headers });
    let body = employee;
    return this._http.post(this.employeeAddUrl, body, headers).map((res: Response) => res.json());
}

DeleteEmployee(id){
 return this._http.delete('http://localhost:52467/Employee/Delete/' + id);
}

ShowEmployee(id):Observable<Employee>{
return this._http.get('http://localhost:52467/Employee/GetEmployee/'+ id)
.map((response:Response) => <Employee> response.json());
}

SaveEmployee(employee){
	let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({
	 method: RequestMethod.Post,
	 headers: headers });
    let body = employee;
    return this._http.post('http://localhost:52467/Employee/Edit', body, headers).map((res: Response) => res.json());
}

}
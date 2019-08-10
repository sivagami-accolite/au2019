import {Component} from 'angular2/core';
//import {UserDataService} from './service';

@Component({
    selector: 'contacts-list',
    template: `
<h3>Online Contacts</h3>
<h3>Contacts</h3>
<div>{{contactName}}</div>
`
})

export class ContactsList {
    contactName: string = 'Hi Welcome!!';
}
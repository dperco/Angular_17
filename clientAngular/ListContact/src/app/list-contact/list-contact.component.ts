import { Component, inject, OnInit } from '@angular/core';
import { ContactService } from '../contact.service';
import { DatePipe } from '@angular/common';
import { RouterModule } from '@angular/router';
import { Contact } from '../model/contact.interfece';

@Component({
  selector: 'app-list-contact',
  standalone: true,
  imports: [DatePipe,RouterModule],
  templateUrl: './list-contact.component.html',
  styleUrl: './list-contact.component.css'
})
export default class ListContactComponent  implements OnInit {

  private ContactService = inject(ContactService);

  contacts: Contact[] = [];

  ngOnInit() : void {
    this.loadAll();
  }

  loadAll() {
    this.ContactService.list()
    .subscribe((contacts) => {
      this.contacts = contacts;
    }
    );
  }

  deleteContact(contact: Contact) {
    this.ContactService.delete(contact.id)
    .subscribe(() => {
      this.loadAll();
    });
  }

}

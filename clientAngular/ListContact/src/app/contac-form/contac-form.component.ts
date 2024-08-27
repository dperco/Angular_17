import { Component, inject, OnInit } from '@angular/core';
import { ReactiveFormsModule,FormBuilder,Validators, FormGroup } from '@angular/forms'; // Import FormGroup from '@angular/forms'
import { RouterModule ,Router, ActivatedRoute} from '@angular/router';
import { ContactService } from '../contact.service';
import { Contact } from '../model/contact.interfece';

@Component({
  selector: 'app-contac-form',
  standalone: true,
  imports: [RouterModule,ReactiveFormsModule],
  templateUrl: './contac-form.component.html',
  styleUrl: './contac-form.component.css'
})
export default class ContacFormComponent implements OnInit {
  private fb = inject(FormBuilder);
  private router = inject(Router);
  private route= inject(ActivatedRoute)
  private contactService = inject(ContactService);

  contactForm ?: FormGroup; 
  contact?: Contact;

  ngOnInit(): void {
    const id= this.route.snapshot.paramMap.get('id');
    if (id){
      this.contactService.get(parseInt(id))
      .subscribe(contact => {
        this.contact = contact;
        this.contactForm = this.fb.group({
          name: [contact.name,[Validators.required]],
          lastname: [contact.lastname,[Validators.required]],
          phonenumber: [contact.phonenumber,[Validators.required]],
          email: [contact.email,[Validators.required,Validators.email]],
        });
      });
    }else{
      this.contactForm = this.fb.group({
        name: ['', [Validators.required]],
        lastname: ['', [Validators.required]],
        phonenumber: ['', [Validators.required]],
        email: ['', [Validators.required, Validators.email]],
      });
    }
      
  }

  
  save  () {
    if(this.contactForm!.invalid){
      return;
    }
      const contactform = this.contactForm!.value;
      if (this.contact){
        this.contactService.update(this.contact.id,contactform)
        .subscribe(() => {
          this.router.navigate(['/']);
        });}
       else{
            this.contactService.create(contactform)
            .subscribe(() => {
                 this.router.navigate(['/']);
           });
        }
    }
  }
  



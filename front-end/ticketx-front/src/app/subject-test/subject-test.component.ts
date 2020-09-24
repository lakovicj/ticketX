import { Component, OnInit } from '@angular/core';
import { Subject, from } from 'rxjs';

@Component({
  selector: 'app-subject-test',
  templateUrl: './subject-test.component.html',
  styleUrls: ['./subject-test.component.css']
})
export class SubjectTestComponent implements OnInit {

  subject: Subject<number> = new Subject<number>();

  constructor() { }

  ngOnInit() {
    this.subject.subscribe({
      next: (v) => console.log(`observerA: ${v}`)
    });
    this.subject.subscribe({
      next: (v) => console.log(`observerB: ${v}`)
    });
     
    const observable = from([1, 2, 3]);
     
    observable.subscribe(this.subject); // You can subscribe providing a Subject
  }

}

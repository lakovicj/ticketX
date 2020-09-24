import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';


@Component({
  selector: 'app-event',
  templateUrl: './event.component.html',
  styleUrls: ['./event.component.css']
})
export class EventComponent implements OnInit {

  @Input()
  eventName: string;

  @Output()
  eventClicked = new EventEmitter<Event>();

  events: Array<Object> = new Array<Object>();

  constructor() { 
    var event1 = {
      "name": "Prvi event"
    }

    var event2 = {
      "name": "Drugi event"
    }

    this.events.push(event1);
    this.events.push(event2);
  }

  ngOnInit() {
    console.log(this.eventName);

  }

  onClick(event: Event): void {
    this.eventClicked.emit(event);
    console.log("Evennt emitted: " + JSON.stringify(event));
  }

}

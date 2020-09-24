import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ticketx-front';
  name: string = "jole";
  event: string = "predstava iz parenta";

  public clickedEvent: Event;

  childEventClicked(event: Event) {
    this.clickedEvent = event;
  }

  public funkcija() {
    return "hello";
  }
}

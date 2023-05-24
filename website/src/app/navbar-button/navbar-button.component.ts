import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-navbar-button',
  templateUrl: './navbar-button.component.html',
  styleUrls: ['./navbar-button.component.css']
})
export class NavbarButtonComponent {
  @Input()
  href: any;
  @Input()
  text: any;
}

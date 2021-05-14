import { Component, OnInit } from '@angular/core';
import { AuthService } from './service/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'beequalite';

  constructor(
    public auth: AuthService) {

  }

  ngOnInit() {
    this.onReload()
  }

  onReload() {
    window.addEventListener('unload',  () => {
      localStorage.clear()
    })
    window.addEventListener('beforeunload',  () => {
      localStorage.clear()
    })
  }

}

import { AlertasService } from 'src/app/service/alertas.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  constructor(
    private router: Router,
    private alertas: AlertasService
  ) { }

  ngOnInit() {
  }

  sair() {
    this.router.navigate(['/login'])
    environment.foto = ''
    environment.id = 0
    environment.nome = ''
    environment.tipo = ''
    localStorage.removeItem('token')

    this.alertas.showAlertSuccess('Usuário deslogado com sucesso, volte sempre!')
  }

}

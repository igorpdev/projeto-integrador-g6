import { TemaComponent } from './tema/tema.component';
import {HttpClientModule} from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import { FooterComponent } from './footer/footer.component';
import { CadastroComponent } from './cadastro/cadastro.component';
import { SobreComponent } from './sobre/sobre.component';
import { LoginComponent } from './login/login.component';
import { InspireComponent } from './inspire/inspire.component';
import { HomeComponent } from './home/home.component';
import { TemaDeleteComponent } from './delete/tema-delete/tema-delete.component';
import { TemaEditComponent } from './edit/tema-edit/tema-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    FooterComponent,
    CadastroComponent,
    SobreComponent,
    LoginComponent,
    InspireComponent,
    HomeComponent,
    TemaComponent,
    TemaEditComponent,
    TemaDeleteComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

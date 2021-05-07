import { HomeComponent } from './home/home.component';
import { InspireComponent } from './inspire/inspire.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastroComponent } from './cadastro/cadastro.component';
import { LoginComponent } from './login/login.component';
import { SobreComponent } from './sobre/sobre.component';
import { TemaComponent } from './tema/tema.component';
import { TemaEditComponent } from './edit/tema-edit/tema-edit.component';
import { TemaDeleteComponent } from './delete/tema-delete/tema-delete.component';

const routes: Routes = [
  {path: '', redirectTo: 'login', pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {path: 'cadastro', component: CadastroComponent},
  {path: 'sobre', component: SobreComponent},
  {path: 'inspire-se', component: InspireComponent},
  {path: 'home', component: HomeComponent},
  {path: 'tema', component: TemaComponent},
  {path: 'tema-edit/:id', component: TemaEditComponent},
  {path: 'tema-delete/:id', component: TemaDeleteComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

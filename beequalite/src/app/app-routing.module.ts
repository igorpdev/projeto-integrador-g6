import { InspireComponent } from './inspire/inspire.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastroComponent } from './cadastro/cadastro.component';
import { LoginComponent } from './login/login.component';
import { SobreComponent } from './sobre/sobre.component';
import { TemaComponent } from './tema/tema.component';

const routes: Routes = [
  
  {path: '', component: CadastroComponent, pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {path: 'cadastro', component: CadastroComponent},
  {path: 'sobre', component: SobreComponent},
  {path: 'inspire-se', component: InspireComponent},
  {path: 'tema', component: TemaComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

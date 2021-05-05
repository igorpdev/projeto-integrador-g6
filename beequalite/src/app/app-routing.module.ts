import { InspireComponent } from './inspire/inspire.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastroComponent } from './cadastro/cadastro.component';
import { SobreComponent } from './sobre/sobre.component';

const routes: Routes = [
  {path: '', component: CadastroComponent, pathMatch: 'full'},
  {path: 'cadastro', component: CadastroComponent},
  {path: 'sobre', component: SobreComponent},
  {path: 'inspire-se', component: InspireComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

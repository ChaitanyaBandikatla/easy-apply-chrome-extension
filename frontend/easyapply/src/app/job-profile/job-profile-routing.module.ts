import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NewComponent } from './new/new.component';
import { EditComponent } from './edit/edit.component';

/* Routing paths of components in Job-Profile Module */

const routes: Routes = [
  { path: 'jobProfile/new', component: NewComponent },
  { path: 'jobProfile/:jobProfileId/edit', component: EditComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class JobProfileRoutingModule { }

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { JobProfileRoutingModule } from './job-profile-routing.module';
import { NewComponent } from './new/new.component';
import { EditComponent } from './edit/edit.component';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { MatSelectModule } from '@angular/material/select';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

/* Job Profiles of a user Module */

@NgModule({
  declarations: [NewComponent, EditComponent],
  imports: [
    CommonModule,
    JobProfileRoutingModule,
    MatButtonModule,
    MatCardModule,
    MatFormFieldModule,MatCardModule,
    MatFormFieldModule,
    MatIconModule,
    MatInputModule,
    MatSelectModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule
  ]
})
export class JobProfileModule { }

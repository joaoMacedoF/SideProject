import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ApiConfiguration } from 'projects/myproject/src/api/api-configuration';
import { environment } from 'projects/myproject/src/environments/environment';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListBooksComponent } from './list-books/list-books.component';

@NgModule({
  declarations: [AppComponent, ListBooksComponent],
  imports: [BrowserModule, AppRoutingModule, HttpClientModule],
  providers: [
    /* { provide: ApiConfiguration, useValue: { rootUrl: environment.api } }, */
    /* { provide: 'BASE_URL', useValue: 'http://127.0.0.1:8080/my-project-rest' }, */
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}

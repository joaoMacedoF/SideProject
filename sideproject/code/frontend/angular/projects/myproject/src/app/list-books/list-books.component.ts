import { Component, OnInit } from '@angular/core';
import { BookDto } from 'projects/myproject/src/api/models';
import { LibraryService } from 'projects/myproject/src/api/services';
import { map, Observable } from 'rxjs';

@Component({
  selector: 'app-list-books',
  templateUrl: './list-books.component.html',
  styleUrls: ['./list-books.component.scss'],
})
export class ListBooksComponent implements OnInit {
  books$!: Observable<BookDto[]>;

  constructor(private service: LibraryService) {}

  columns = ['id', 'name', 'bookAuthor'];

  ngOnInit(): void {
    this.books$ = this.service
      .getAllBooksInLibraryUsingGet()
      .pipe(map((response) => response.response));

    /* this.books$ = this.service.getAllBooksInLibraryUsingGet().pipe(
      map((response) => {
        console.log(response);
        return response.response;
      })
    ); */
    /*  this.books$ = this.service.getAllBooksInLibraryUsingGet().pipe(
      map((response: any) => {
        console.log(response);
        return response.response;
      })
    ); */
  }
}

/* tslint:disable */
/* eslint-disable */
import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse, HttpContext } from '@angular/common/http';
import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';
import { RequestBuilder } from '../request-builder';
import { Observable } from 'rxjs';
import { map, filter } from 'rxjs/operators';

import { ResponseDtoListBookDto } from '../models/response-dto-list-book-dto';


/**
 * Library Controller
 */
@Injectable({
  providedIn: 'root',
})
export class LibraryService extends BaseService {
  constructor(
    config: ApiConfiguration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * Path part for operation getAllBooksInLibraryUsingGet
   */
  static readonly GetAllBooksInLibraryUsingGetPath = '/library/books';

  /**
   * getAllBooksInLibrary.
   *
   *
   *
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getAllBooksInLibraryUsingGet()` instead.
   *
   * This method doesn't expect any request body.
   */
  getAllBooksInLibraryUsingGet$Response(params?: {
    context?: HttpContext
  }
): Observable<StrictHttpResponse<ResponseDtoListBookDto>> {

    const rb = new RequestBuilder(this.rootUrl, LibraryService.GetAllBooksInLibraryUsingGetPath, 'get');
    if (params) {
    }

    return this.http.request(rb.build({
      responseType: 'json',
      accept: 'application/json',
      context: params?.context
    })).pipe(
      filter((r: any) => r instanceof HttpResponse),
      map((r: HttpResponse<any>) => {
        return r as StrictHttpResponse<ResponseDtoListBookDto>;
      })
    );
  }

  /**
   * getAllBooksInLibrary.
   *
   *
   *
   * This method provides access to only to the response body.
   * To access the full response (for headers, for example), `getAllBooksInLibraryUsingGet$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getAllBooksInLibraryUsingGet(params?: {
    context?: HttpContext
  }
): Observable<ResponseDtoListBookDto> {

    return this.getAllBooksInLibraryUsingGet$Response(params).pipe(
      map((r: StrictHttpResponse<ResponseDtoListBookDto>) => r.body as ResponseDtoListBookDto)
    );
  }

}

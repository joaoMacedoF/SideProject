/* tslint:disable */
/* eslint-disable */
import { Injectable } from '@angular/core';

/**
 * Global configuration
 */
@Injectable({
  providedIn: 'root',
})
export class ApiConfiguration {
  rootUrl: string = 'http://localhost:8080/my-project-rest';
}

/**
 * Parameters for `.forRoot()`
 */
export interface ApiConfigurationParams {
  rootUrl?: string;
}

/* tslint:disable */
/* eslint-disable */
import { BookDto } from './book-dto';
import { ResponseDto } from './response-dto';
export type ResponseDtoListBookDto = ResponseDto & {
'response': Array<BookDto>;
};

import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Category } from 'src/app/models/category'

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  categoryUrl: string;

  constructor(private http: HttpClient) {
    this.categoryUrl = 'http://localhost:3000/category';
  }

  //get all categories
  getAll(): Observable<Category[]>{
    return this.http.get<Category[]>(this.categoryUrl);
  }

  //add category
  addCategory(c:Category): Observable<Category>{
    return this.http.post<Category>(this.categoryUrl,c);
  }

  //delete cate by id
  deleteById(id:number): Observable<Category>{
    return this.http.delete<Category>(`${this.categoryUrl}/${id}`);
  }
}

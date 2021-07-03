import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Oferta } from './oferta';
import { environment } from 'src/environments/environment';

@Injectable({providedIn: 'root'})
export class OfertaService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getOferta(): Observable<Oferta[]> {
    return this.http.get<Oferta[]>(`${this.apiServerUrl}/oferta/all`);
  }

  public addOferta(oferta: Oferta): Observable<Oferta> {
    return this.http.post<Oferta>(`${this.apiServerUrl}/oferta/add`, oferta);
  }

  public updateOferta(oferta: Oferta): Observable<Oferta> {
    return this.http.put<Oferta>(`${this.apiServerUrl}/oferta/update`, oferta);
  }

  public deleteOferta(ofertaId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/oferta/delete/${ofertaId}`);
  }
}

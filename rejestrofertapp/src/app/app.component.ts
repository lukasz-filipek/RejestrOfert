import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Oferta } from './oferta';
import { OfertaService } from './oferta.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
    public oferty: Oferta[];
    public editOferta: Oferta;
    public deleteOferta: Oferta;

    constructor(private ofertaService: OfertaService) { }

    ngOnInit() {
      this.getOferty();
    }

    public getOferty(): void {
      this.ofertaService.getOferta().subscribe(
        (response: Oferta[]) => {
          this.oferty = response;
          console.log(this.oferty);
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
        
      );
    }

    public onAddOferta(addForm: NgForm): void {
      document.getElementById('add-form');
    this.ofertaService.addOferta(addForm.value).subscribe(
      (response: Oferta) => {
        console.log(response);
        this.getOferty();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
    }

    public onUpdateOferta(oferta: Oferta): void {
      this.ofertaService.updateOferta(oferta).subscribe(
        (response: Oferta) => {
          console.log(response);
          this.getOferty();
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
      );
    }

    public onDeleteOferta(ofertaId: number): void {
      this.ofertaService.deleteOferta(ofertaId).subscribe(
        (response: void) => {
          console.log(response);
          this.getOferty();
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
      );
    }

    public searchOferty(key: string): void {
      console.log(key);
      const results: Oferta[] = [];
      for (const oferta of this.oferty) {
        if (oferta.nazwaKlienta.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || oferta.dataOtrzymaniazapytania.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || oferta.nazwaZespolu.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || oferta.waga.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || oferta.nrRysunku.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || oferta.okresRealizacji.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || oferta.minimalnaPartia.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || oferta.terminWyceny.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
          results.push(oferta);
        }
      }
      this.oferty = results;
      if (results.length === 0 || !key) {
        this.getOferty();
      }
    }

    public onOpenModal(oferta: Oferta, mode: string): void {

      const container = document.getElementById('main-container');
      const button = document.createElement('button');
      button.type = 'button';
      button.style.display = 'none';
      button.setAttribute('data-toggle', 'modal');
      if (mode === 'add') {
        button.setAttribute('data-target', '#addOfertaModal');
      }
      if (mode === 'edit') {
        this.editOferta = oferta;
        button.setAttribute('data-target', '#updateOfertaModal');
      }
      if (mode === 'delete') {
        this.deleteOferta = oferta;
        button.setAttribute('data-target', '#deleteOfertaModal');
      }


      container.appendChild(button);
      button.click();
    }
    
    
  

}

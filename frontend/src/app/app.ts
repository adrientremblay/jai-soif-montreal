import { Component, OnInit, signal, inject } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { MapComponent } from './map/map';
import {
    TranslateService,
    TranslatePipe,
    TranslateDirective
} from "@ngx-translate/core";
import 'zone.js';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, MapComponent, TranslatePipe, TranslateDirective],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('jaisoifmontreal');

  private translate = inject(TranslateService);

  constructor() {
      this.translate.addLangs(['en', 'fr']);
      this.translate.setFallbackLang('en');
      this.translate.use('en');
  }

  public selectLanguage(event: any) {
    this.translate.use(event.target.value);
  }
}

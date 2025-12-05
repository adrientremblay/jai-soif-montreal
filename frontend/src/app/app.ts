import { Component, OnInit, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Fountain } from './fountain';
import { FountainService } from './fountain.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App implements OnInit {
  protected readonly title = signal('frontend');

  public fountains: Fountain[] = [];

  constructor(private fountainService: FountainService){}

  ngOnInit(): void {
    this.getFountains();
  }

  public getFountains(): void {
    this.fountainService.getFountains().subscribe(
      (response: Fountain[]) => {
        this.fountains = response;
      },
      (error: HttpErrorResponse) => {
        console.error(error.message);
      }
    )
  }
}

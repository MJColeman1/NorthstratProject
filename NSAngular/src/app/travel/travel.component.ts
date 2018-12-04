import { Component, OnInit } from '@angular/core';
import { Travel } from '../models/travel';
import { Router } from '@angular/router';
import { TravelService } from '../travel.service';

@Component({
  selector: 'app-travel',
  templateUrl: './travel.component.html',
  styleUrls: ['./travel.component.css']
})
export class TravelComponent implements OnInit {

  travel: Travel = new Travel();

  travelReports = [];

  createTravelReport(travel) {
  return this.travelService.createTravel(travel).subscribe(
    data => {
      this.travel = data;
      this.router.navigateByUrl('user');
    },
    error => console.log(error + ' kaboom in create travel component'));
  }

  constructor(private router: Router, private travelService: TravelService) { }

  ngOnInit() {
  }

}

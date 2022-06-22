import { Component, OnInit } from '@angular/core';

import { SearchDataService } from 'src/app/services/search-data.service';

@Component({
  selector: 'app-data-search',
  templateUrl: './data-search.component.html',
  styleUrls: ['./data-search.component.css']
})
export class DataSearchComponent implements OnInit {

  selectedIndex: Number = 0;
  returnedItem: Number = -1;


  constructor( private searchDataService : SearchDataService) { }

  ngOnInit(): void {
  }

  search() {
    this.searchDataService
    .getItemByIndex(this.selectedIndex)
    .subscribe( (returnedItem) => (this.returnedItem = returnedItem));
  }

}

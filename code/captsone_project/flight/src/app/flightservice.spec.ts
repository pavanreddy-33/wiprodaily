import { TestBed } from '@angular/core/testing';

import { Flightservice } from './flightservice';

describe('Flightservice', () => {
  let service: Flightservice;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Flightservice);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

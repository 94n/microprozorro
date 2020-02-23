import { TestBed, inject } from '@angular/core/testing';

import { ClassifierService } from './service/classifier.service';

describe('ClassifierService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ClassifierService]
    });
  });

  it('should be created', inject([ClassifierService], (service: ClassifierService) => {
    expect(service).toBeTruthy();
  }));
});

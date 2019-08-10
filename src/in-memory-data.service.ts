import { InMemoryDbService } from 'angular-in-memory-web-api';

export class InMemoryDataService implements InMemoryDbService {
  createDb() {
    const heroes = [
      { id: 0, name: 'Aarthi' },
      { id: 1, name: 'Ajay' },
      { id: 2, name: 'Akshaya' },
      { id: 3, name: 'Soundarya' },
      { id: 4, name: 'Sahitya' },
      { id: 5, name: 'Dhoni' },
      { id: 6, name: 'Aishwaya' },
      { id: 7, name: 'Megna' },
      { id: 8, name: 'ravi' },
      { id: 9, name: 'Mega' },
      { id: 10, name: 'Tavish' }
    ];
    return { heroes };
  }
}

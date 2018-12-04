import { User } from './user';

export class Expense {

  constructor(protected id?: number, protected description?: string, protected attendees?: string, protected amount?: number,
    protected glAccount?: string, protected createdAt?: string, protected updatedAt?: string, protected status?: string,
    protected user?: User ) {
  }
}
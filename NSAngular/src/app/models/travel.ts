import { User } from './user';

export class Travel {

constructor(protected id?: number, protected projectChargeCode?: string, protected tripLocation?: string,
protected travelDates?: string, protected createdAt?: string, protected updatedAt?: string,
protected status?: string, protected totalCost?: number, protected user?: User, protected userComments?: string,
protected adminComments?: string) {}

}

import { Pipe, PipeTransform } from '@angular/core';
import { Expense } from './models/expense';

@Pipe({
  name: 'ReportStatus'
})
export class ReportStatusPipe implements PipeTransform {

  transform(reports, argument: string): any {
    const results = [];
    reports.forEach(function(expense) {
    if (expense.status === argument) {
      results.push(expense);
    }
    if (argument === 'Show All Reports') {
      results.push(expense);
    }
    });

    return results;
  }

}

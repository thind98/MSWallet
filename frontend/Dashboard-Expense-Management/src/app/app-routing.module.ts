import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { MapsComponent } from './pages/maps/maps.component';
import { NotificationsComponent } from './pages/notifications/notifications.component';
import { WalletComponent } from './pages/wallet/wallet.component';
import { WalletListComponent } from './pages/wallet/wallet-list/wallet-list.component';
import { WalletDetailsComponent } from './pages/wallet/wallet-details/wallet-details.component';
import { TransactionComponent } from './pages/transaction/transaction.component';
import { TransactionListComponent } from './pages/transaction/transaction-list/transaction-list.component';
import { ChartComponent } from './pages/chart/chart.component';

const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'maps', component: MapsComponent },
  { path: 'notifications', component: NotificationsComponent },
  {
    path: 'wallet', component: WalletComponent, children:
      [
        { path: '', component: WalletListComponent },
        { path: ':wallet_id', component: WalletDetailsComponent }
      ]
  },
  {
    path: 'transaction', component: TransactionComponent, children:
      [
        { path: ':wallet_id', component: TransactionListComponent }
      ]
  },
  { path: 'chart', component: ChartComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

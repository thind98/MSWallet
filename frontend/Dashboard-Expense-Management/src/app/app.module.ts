import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule, HTTP_INTERCEPTORS } from "@angular/common/http";
import { FormsModule } from "@angular/forms";
import { ReactiveFormsModule } from "@angular/forms";

import { CollapseModule } from 'ngx-bootstrap/collapse';
import { ToastrModule } from 'ngx-toastr';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { FooterComponent } from './components/footer/footer.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { MapsComponent } from './pages/maps/maps.component';
import { NotificationsComponent } from './pages/notifications/notifications.component';
import { MatDialogModule } from '@angular/material/dialog';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { WalletComponent } from './pages/wallet/wallet.component';
import { TransactionComponent } from './pages/transaction/transaction.component';
import { CategoryComponent } from './pages/category/category.component';
import { ChartComponent } from './pages/chart/chart.component';
import { WalletListComponent } from './pages/wallet/wallet-list/wallet-list.component';
import { WalletDetailsComponent } from './pages/wallet/wallet-details/wallet-details.component';
import { WalletAddComponent } from './pages/wallet/wallet-add/wallet-add.component';
import { WalletUpdateComponent } from './pages/wallet/wallet-update/wallet-update.component';
@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    SidebarComponent,
    FooterComponent,
    DashboardComponent,
    MapsComponent,
    NotificationsComponent,
    WalletComponent,
    TransactionComponent,
    CategoryComponent,
    ChartComponent,
    WalletListComponent,
    WalletDetailsComponent,
    WalletAddComponent,
    WalletUpdateComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CommonModule,
    BrowserAnimationsModule,
    CollapseModule.forRoot(),
    ToastrModule.forRoot(),
    HttpClientModule,FormsModule,ReactiveFormsModule,MatDialogModule,MatSnackBarModule
    ],
  providers: [],
  bootstrap: [AppComponent],
  entryComponents: 
  [
    WalletAddComponent,
    WalletUpdateComponent
  ]
})
export class AppModule { }

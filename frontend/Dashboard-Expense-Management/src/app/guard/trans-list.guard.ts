import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, CanActivate, Router } from '@angular/router';
import { WalletService } from 'src/app/services/wallet.service'

@Injectable({
  providedIn: 'root'
})
export class TransListGuard implements CanActivate {

  allowed: boolean;

  constructor(private service: WalletService,
    private router: Router
  ) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    this.service.findById(+route.paramMap.get('wallet_id')).subscribe(data => {
      if (data[0] != null) {
        this.allowed = true;
      } else {
        this.allowed = false;
      }
    })
    if (this.allowed) {
      return true;
    } else {
      this.router.navigate(['/notfound'])
      return false;
    }
  }
}

import { Component, OnInit } from '@angular/core';
import { TransService } from 'src/app/services/trans.service';
import { WalletService } from 'src/app/services/wallet.service';
import { UserWalletService } from 'src/app/services/user-wallet.service'
import { User_Wallet_display } from 'src/app/models/user_wallet_display';
import { Transaction_display } from 'src/app/models/transaction_display';
import { Chart } from 'chart.js';

@Component({
  selector: 'app-chart-filter',
  templateUrl: './chart-filter.component.html',
  styleUrls: ['./chart-filter.component.scss']
})
export class ChartFilterComponent implements OnInit {

  transTest: Transaction_display[];
  wallets: User_Wallet_display[];

  id: number;
  fromDate: string;
  fromInput: Date;
  toDate: string;
  toInput: Date;
  dateLabels = [];
  dateValues = [];

  chart_i: Chart;
  chart_e : Chart;
  chart_bar: Chart;

  constructor(
    public transService: TransService,
    public walletService: WalletService,
    public uwService: UserWalletService
  ) { }


  getWalletList() {
    this.uwService.findAll(+sessionStorage.getItem('id')).subscribe(data => {
      return this.wallets = data;
    })
  }

  getStatistic() {
    this.transService.getListByWalletId(this.id).subscribe(data => {
      console.log(data)
      return this.transTest = data;
    })
  }

  // testSpawnDate(){
  //   const a = new Date("2020-08-26")
  //   const b = new Date("2020-10-02")
  //   while(a<=b){
  //     console.log(a)
  //     a.setDate(a.getDate()+1)
  //   }
  // }

  async getChart() {
    this.dateValues.splice(0,this.dateValues.length)
    this.dateLabels.splice(0,this.dateLabels.length)
    if(this.chart_i) this.chart_i.destroy(); //tiêu hủy chart trước
    if(this.chart_e) this.chart_e.destroy();
    if (this.id == null) { //nếu không chọn ví => thông báo
      alert('Hãy chọn một ví để thống kê chi tiêu')
    } else { //nếu chọn
      console.log('id ví: ' + this.id)
      //lấy dự liệu các transactions từ service
      this.transTest = await this.transService.getListByWalletId(this.id).toPromise();
      this.fromInput = new Date(this.fromDate);
      this.toInput = new Date(this.toDate);
      if (this.fromInput > this.toInput) { //nếu nhập từ ngày > đến ngày => thông báo
        console.log('vkl')
        alert('stop this shit')
      } else { //nhạp đúng hoặc không nhập
        // lọc theo ngày
        if (this.fromDate == null && this.toDate != null) { //nếu không nhập từ ngày
          console.log('no from')
          this.transTest = this.transTest.filter(
            tran => new Date(tran.date) <= this.toInput
          )
        } else if (this.toDate == null && this.fromDate != null) { //nếu không nhập đến ngày
          console.log('no to')
          this.transTest = this.transTest.filter(
            tran => new Date(tran.date) >= this.fromInput
          )
        } else if (this.fromDate != null && this.toDate != null) { //nếu nhập cả 2
          console.log('have both')
          this.transTest = this.transTest.filter(
            tran => new Date(tran.date) >= this.fromInput && new Date(tran.date) <= this.toInput
          )
        }
        this.transTest.forEach(e => {
          console.log(new Date(e.date))
        })

        //BIỂU ĐỒ TRÒN
        //sau khi lọc ngày => lọc theo thu/chi
        const transClone = this.transTest;
        const transCloneB = this.transTest;

        let income = this.transTest.filter( //thu nhập
          tran => tran.trans_type == false
        )
        let expense = transClone.filter( //chi tiêu
          tran => tran.trans_type == true
        )

        const map_income = new Map();
        income.map((a, i) => {
          let value: number = 0;
          income.filter(a1 => a1.category_name === a.category_name).map(a2 => {
            value += a2.amount;
            map_income.set(a2.category_name, value);
          })
        })

        const map_expense = new Map();
        expense.map((a, i) => {
          let value: number = 0;
          expense.filter(a1 => a1.category_name === a.category_name).map(a2 => {
            value += a2.amount;
            map_expense.set(a2.category_name, value);
          })
        })

        let cate_i = Array.from(map_income.keys()) //lấy các danh mục có trong ví
        let amount_i = Array.from(map_income.values()) // lấy số tiền mỗi danh mục
        let cate_e = Array.from(map_expense.keys())
        let amount_e = Array.from(map_expense.values())

        // get data biểu đồ cột from here
        console.log(transCloneB)
        for(let i=0; i<transCloneB.length; i++){
          if(transCloneB[i].trans_type == true){
            transCloneB[i].amount = -transCloneB[i].amount;
          }
        }
        const map_bar = new Map();
        transCloneB.forEach(a => {
          console.log(new Date(a.date).toDateString())
        })
        transCloneB.map((a, i) => {
          let value: number = 0;
          transCloneB.filter(
            a1 => new Date(a1.date).toDateString() === new Date(a.date).toDateString())
            .map(a2 => {
            value += a2.amount;
            map_bar.set(new Date(a2.date).toLocaleDateString(), value/1000);
          })
        })
        console.log(map_bar)
        // tạo mảng gồm dãy các ngày từ fromDate đến toDate để làm label cho biểu đồ cột
        while(this.fromInput <= this.toInput){
          this.dateLabels.push(this.fromInput.toLocaleDateString())
          this.fromInput.setDate(this.fromInput.getDate()+1)
        }
        console.log(this.dateLabels)

        this.dateLabels.forEach(d => {
          if(map_bar.has(d)){
            let a = map_bar.get(d);
            this.dateValues.push(a)
          }else{
            this.dateValues.push(0)
          }
        })
        console.log(this.dateValues)

        //BIỂU ĐỒ THU 
        this.chart_i = new Chart('chart-income', {
          type: 'doughnut',
          data: {
            datasets: [{
              data: amount_i,
              backgroundColor:
                [
                  "#0099cc", "#00ffff", "#0000ff", "#cc00cc",
                  "#660066", "#800000", "#ff0000", "#ff6600",
                  "#ffcc00", "#99ff33", "#00ff00", "#006600"
                ],
            }],
            labels: cate_i
          },
          options: {
            legend: {
              position: 'bottom',
              display: false
            },
            cutoutPercentage: 50
          }
        });

        //BIỂU ĐỒ CHI 
        this.chart_e = new Chart('chart-expense', {
          type: 'doughnut',
          data: {
            datasets: [{
              data: amount_e,
              backgroundColor:
                [
                  "#0099cc", "#00ffff", "#0000ff", "#cc00cc",
                  "#660066", "#800000", "#ff0000", "#ff6600",
                  "#ffcc00", "#99ff33", "#00ff00", "#006600"
                ],
            }],
            labels: cate_e
          },
          options: {
            legend: {
              position: 'bottom',
              display: false
            },
            cutoutPercentage: 50
          }
        });

        //BIỂU ĐỒ CỘT
        this.chart_bar = new Chart('chart-bar', {
          type: 'bar',
          data: {
            labels: this.dateLabels,
            datasets: [{
              // label: 'Premium',
              data: this.dateValues,
              backgroundColor: '#5b6582',
              borderColor: '#5b6582',
              borderWidth: 2
            }]
          },
          options: {
            barValueSpacing: 1,
            scales: {
              yAxes: [{
                ticks: {
                  fontColor: 'rgba(0,0,0,.6)',
                  fontStyle: 'bold',
                  beginAtZero: true,
                  maxTicksLimit: 8,
                  padding: 5
                }
              }],
              xAxes: [{
                barPercentage: 0.9
              }]
            },
            responsive: true,
            legend: {
              position: 'bottom',
              display: false
            },
          }
        });
      }
    }
  }

  ngOnInit() {
    this.getWalletList();
    // this.testSpawnDate();
  }
}

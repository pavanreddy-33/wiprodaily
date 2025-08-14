class BankAccount {
  constructor(accountNumber, balance) {
    this.accountNumber = accountNumber;
    this.balance = balance;
  }

  
  deposit(amount) {
    if (amount > 0) {
      this.balance += amount;
      console.log(`Deposited ₹${amount}. New balance: ₹${this.balance}`);
    } else {
      console.log("Deposit amount must be positive.");
    }
  }


  withdraw(amount) {
    if (amount > this.balance) {
      console.log("Insufficient balance.");
    } else if (amount <= 0) {
      console.log("Withdrawal amount must be positive.");
    } else {
      this.balance -= amount;
      console.log(`Withdrew ₹${amount}. New balance: ₹${this.balance}`);
    }
  }
}


let account = new BankAccount("33333333", 1000);
account.deposit(2000);   
account.withdraw(3000);  
account.withdraw(5000);  
package org.atmsystem

/**
 * Scala Application: ATM system prototype
 *
 * Concepts: classes and objects,
 *           inheritance,
 *           method definition,
 *           method overriding,
 *           if-else,
 *           match-case,
 *           ListBuffer data structure
 *           File I/O
 *           Exception handling
 *           Collections
 *
 * Application structure:
 *
 *           ATMsystem (Driver entry point of the application)
 *           Account -> Parent class
 *           Bank    -> Subclass, inherits from Account
 *           CurrentAccount -> -> Subclass, inherits from Account
 *           SavingsAccount -> -> Subclass, inherits from Account
 *
 * @author    Mauro Travieso
 * @version   1.0
 *
 */
object ATMsystem {

  def main(args: Array[String]): Unit = {

    // Class instantiation
    val account = new Account()
    val savingsAccount = new SavingsAccount()
    val currentAccount = new CurrentAccount()
    val bank = new Bank()

    println("ATM System Options: " +
      "\nPress [1] for account details" +
      "\nPress [2] for Savings account" +
      "\nPress [3] for Current account" +
      "\nPress [4] for Open/Close account"
    )

    val choice = readInt()
    if (choice == 1) {
      account.details()
    }

    choice match {
      case 1 => {
        account.details()
      }
      case 2 => {
        println("Press [1] for checking account interest amount\n" +
          "Press [2] for account details")
        val choice1 = readInt()
        if (choice1 == 1) {
          savingsAccount.interest_amount()
        } else {
          savingsAccount.details()
        }
      }
      case 3 => {
        println("Press [1] to deposit\n" +
          "Press [2] to withdraw")
        val choice2 = readInt()
        if (choice2 == 1) {
          currentAccount.credit()
        }
        if (choice == 2) {
          currentAccount.debit()
        }
      }
      case 4 => {
        println("Press [1] to open an account\n" +
          "Press [2] to close an account")
        val choice3 = readInt()
        if (choice3 == 1) {
          bank.open_account()
        }
        if (choice == 2) {
          bank.close_account()
        }
      }
      case _ => println("Invalid selection")
    }
  }

}

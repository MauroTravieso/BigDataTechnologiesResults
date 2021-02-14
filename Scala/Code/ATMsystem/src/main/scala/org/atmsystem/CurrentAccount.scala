package org.atmsystem

class CurrentAccount extends Account {

  var overdraft_limit: Double = 2000

  override def debit(): Unit = {
    println("Enter the account number you want to withdraw from: ")
    val acc_num5 = readInt()
    val index5 = account_number.indexOf(acc_num5)

    println("Enter the amount you want to withdraw: ")
    var debit_amount = readDouble()

    if (current_balance(index5) - debit_amount > 0) {
      if  (current_balance(index5) - debit_amount < 2000) {
        println("Overdraft limit exceeded. Transaction declined!")
      } else {
        current_balance(index5) -= debit_amount
        println("Transaction successful" +
        "\nRemaining balance is: " + current_balance(index5))
      }
    }
  }

}

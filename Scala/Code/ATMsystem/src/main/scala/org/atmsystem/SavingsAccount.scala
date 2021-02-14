package org.atmsystem

class SavingsAccount extends Account {

  var interest: Double = 2

  // To calculate the interest amount
  def interest_amount(): Unit = {
    println("Please, enter the account number to calculate the interest: ")
    val acc_num3 = readInt()
    val index3 = account_number.indexOf(acc_num3)
    interest = (current_balance(index3) * 2) / 100
    println(s"The interest amount is: $interest")
  }

  // Show account details
  override def details(): Unit = {
    println("Please, enter the account number to see the details: ")

    val acc_num4 = readInt()
    val index4 = account_number.indexOf(acc_num4)

    println(s"Details of the account number: $acc_num4 are:" +
      "\nCustomer name: "   + name(index4) +
      "\nAccount number: "  + account_number(index4) +
      "\nPhone number:"     + phone_number(index4) +
      "\nAccount balance: " + current_balance(index4)
    )
  }
}

package org.atmsystem

import java.io.{BufferedWriter, File, FileNotFoundException, FileWriter, IOException}

import scala.io.Source

class Bank extends Account {

  // Open an account
  def open_account(): Unit = {

    // In memory
    //    var new_name = readLine("Enter the name: ")
//    name += new_name
//
//    println("Please, enter the opening balance: ")
//    var opening_balance = readDouble()
//    current_balance += opening_balance
//
//    val rnd = scala.util.Random
//    val start = 999
//    val end = 99999
//    account_number += rnd.nextInt((end-start)+1)

    // File management
    try {
      val currentfile = new File("src/main/resources/" + filename)
      val fw = new FileWriter(currentfile,true)
      val bw = new BufferedWriter(fw)
      //bw.write("\nRocky,50000,5555,5555555555")
      var new_name = readLine("Enter the name: ")
      println("Please, enter the opening balance: ")
      var opening_balance = readDouble()
      val rnd = scala.util.Random
      val start = 1000
      val end = 9999
      val account_nbr = rnd.nextInt((end-start)+1)
      println("Please, enter the telephone number: ")
      var phone = readLong()
      bw.write(s"\n${new_name},${opening_balance},${account_nbr},${phone}")
      bw.close()
    } catch {
      case e: FileNotFoundException => println("File does not exist!!!")
      case e: IOException => println("IOException thrown!")
    }

    println("Account added successfully!")
  }

  // Close an account
  def close_account(): Unit = {
    println("Enter the account number: ")
    val acc_num6 = readInt()
    val index6 = account_number.indexOf(acc_num6)

    name -= name(index6)
    current_balance -= current_balance(index6)
    account_number -= account_number(index6)





    print("org.atmsystem.Account removed successfully!")
  }

}

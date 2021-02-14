package org.atmsystem

import java.io.{FileNotFoundException, IOException}

import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import scala.io.Source
import scala.util.control.Breaks.{break, breakable}

class Account {

  // Using ListBuffer DS
  //  var name = new ListBuffer[String]()
  //  name += ("Olga", "Tita", "Mauro")
  //
  //  var current_balance = new ListBuffer[Double]()
  //  current_balance += (20000, 30000, 40000)
  //
  //  var account_number = new ListBuffer[Int]()
  //  account_number += (1111, 2222, 3333)
  //
  //  var phone_number = new ListBuffer[Long]()
  //  phone_number += (1111111111L, 2222222222L, 3333333333L)

  // Using CSV plain text file
  val filename = "data.txt"
  //val filename = "file_does_not_exist.txt" // to handle the exception
  val rows = ArrayBuffer[Array[String]]() // Using Array DS
  var name = new ListBuffer[String]()
  var current_balance = new ListBuffer[Double]()
  var account_number = new ListBuffer[Int]()
  var phone_number = new ListBuffer[Long]()

  val filesrc = Source.fromFile("src/main/resources/" + filename)

  try {
    //var count =0
    for (line <- filesrc.getLines) {
      // Print the whole record
      // println(line) // to test
      // println(count)
      //breakable {
//        if (count == 0) {
//          val header = line.take(1)
//          count += 1
//          println("---" + header)
//          //break
//        }
      //}
//      println(count)
//      if (count > 0) {
        // Print the fields of the record
//        println("***" + line)
        rows += line.split(",").map(_.trim)
        for (row <- rows) {
          // println(s"${row(0)}|${row(1)}|${row(2)}|${row(3)}") // to test
          name += (s"${row(0)}")
          current_balance += (s"${row(1)}").toDouble
          account_number += (s"${row(2)}").toInt
          phone_number += (s"${row(2)}").toLong
        }
//      }
    }
  } catch {
    case e: FileNotFoundException => println("File does not exist!!!")
    case e: IOException => println("IOException thrown!")
  }
  finally {
    //println("File closed")
    filesrc.close
  }

  // Customer details
  def details(): Unit = {
    println("Customer details:" +
      "\nName: "+ name +
      "\nCurrent balance: " + current_balance +
      "\nAccount number: " + account_number +
      "\nPhone number: " + phone_number
    )
  }

  // Account deposit
  def credit(): Unit = {
    println("Please, enter the account to deposit: ")
    val acc_num1 = readInt()
    val index1 = account_number.indexOf(acc_num1)

    println("Please, enter the amount to deposit: ")
    var credit_amount: Double = 0
    credit_amount = readDouble()

    current_balance(index1) += credit_amount
    println("Amount added successfully\n New balance is: " + current_balance(index1))
  }

  // Account withdraw
  def debit(): Unit ={
    println("Please, enter the account number to withdraw from: ")
    val accu_num2 = readInt()
    val index2 = account_number.indexOf(accu_num2)

    println("Please, enter the amount to withdraw: ")
    var debit_amount: Double = 0
    debit_amount = readDouble()

    if (current_balance(index2) - debit_amount >= 0)
      println("The current balance is less than the requested amount!!!")
    else {
      current_balance(index2) -= debit_amount
      println("Money withdrawn successfully"+
        "\nRemain balance is: " + current_balance(index2))
    }
  }
}

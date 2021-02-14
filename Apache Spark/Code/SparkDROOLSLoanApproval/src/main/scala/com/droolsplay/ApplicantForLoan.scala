package com.droolsplay

case class ApplicantForLoan(id: Int, firstName: String, lastName: String, requestAmount: Int, creditScore: Int) extends Serializable {

  private var approved = false

  def getId: Int = id

  def getFirstName: String = firstName

  def getLastName: String = lastName

  def getRequestAmount: Int = requestAmount

  def getCreditScore: Int = creditScore

  def isApproved: Boolean = approved

  def setApproved(_approved: Boolean): Unit = {
    approved = _approved
  }

}

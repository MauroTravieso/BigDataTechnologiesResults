package com.droolsplay.util

import com.droolsplay.ApplicantForLoan
import org.apache.spark.internal.Logging
import org.kie.api.{KieBase, KieServices}
import org.kie.internal.command.CommandFactory

object DroolUtil extends Logging {
  def loadRules: KieBase = {
    val kieServices = KieServices.Factory.get
    val kieContainer = kieServices.getKieClasspathContainer
    kieContainer.getKieBase
  }

  def applyRules(base: KieBase, applicant: ApplicantForLoan): ApplicantForLoan = {
    val session = base.newStatelessKieSession
    session.execute(CommandFactory.newInsert(applicant))
    logTrace("applyrules ->" + applicant)
    applicant
  }
}





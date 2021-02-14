mysql> SHOW DATABASES;

mysql> USE dbo;

mysql> SHOW TABLES;
+----------------------------+
| Tables_in_dbo              |
+----------------------------+
| course_data_external       |
| examschedule               |
| tblcentremaster            |
| tbldesignations            |
| tblemployees               |
| tblemployeetypes           |
| tbllocations               |
| tblpayemployeeparamdetails |
| tblpayemployees            |
| tblpaymaster               |
| tblservicestatus           |
| tblservicetypes            |
| tblstatemaster             |
+----------------------------+
13 rows in set (0.00 sec)

[1] mysql> SHOW CREATE TABLE tblemployees\G

CREATE TABLE `tblemployees` (
  `LetterNumber` varchar(25) DEFAULT NULL,
  `LetterDate` datetime DEFAULT NULL,
  `DOJ` datetime NOT NULL,
  `EmployeeNumber` int NOT NULL,
  `CentreCode` int NOT NULL,
  `BranchCode` int DEFAULT NULL,
  `CategoryCode` tinyint unsigned NOT NULL,
  `DepartmentCode` smallint DEFAULT NULL,
  `SectionCode` smallint DEFAULT NULL,
  `EmployeeType` tinyint unsigned NOT NULL,
  `ServiceType` tinyint unsigned NOT NULL,
  `ServiceStatus` tinyint unsigned NOT NULL,
  `OfficiatingDesignationCode` smallint DEFAULT NULL,
  `FatherName` varchar(30) DEFAULT NULL,
  `DOB` datetime DEFAULT NULL,
  `CertificateType` tinyint unsigned DEFAULT NULL,
  `CertificateNo` varchar(25) DEFAULT NULL,
  `CertificateDate` datetime DEFAULT NULL,
  `Age` tinyint unsigned DEFAULT NULL,
  `Sex` char(1) DEFAULT NULL,
  `LicenceNumber` varchar(25) DEFAULT NULL,
  `ExpiryDate` datetime DEFAULT NULL,
  `Name` varchar(50) DEFAULT NULL,
  `NickName` varchar(50) DEFAULT NULL,
  `MaritalStatus` tinyint unsigned DEFAULT NULL,
  `Religion` tinyint unsigned DEFAULT NULL,
  `Nationality` tinyint unsigned DEFAULT NULL,
  `ExtraCurricum` varchar(400) DEFAULT NULL,
  `MotherLanguage` tinyint unsigned DEFAULT NULL,
  `ApplicationNumber` int DEFAULT NULL,
  `ApplicationDate` datetime DEFAULT NULL,
  `LocationType` tinyint unsigned NOT NULL,
  `LocationCode` int DEFAULT NULL,
  `FunctionalDesignation` smallint NOT NULL,
  `DesignationCode` smallint NOT NULL,
  `IsActive` char(1) NOT NULL,
  `IsFDActive` tinyint(1) DEFAULT NULL,
  `ReportingToFD` smallint DEFAULT NULL,
  `DeputationLocationType` smallint DEFAULT NULL,
  `DeputationLocationCode` int DEFAULT NULL,
  `ConfirmDate` datetime DEFAULT NULL,
  `DivisionCode` tinyint unsigned NOT NULL,
  `SectorCode` smallint NOT NULL,
  `GodownCode` smallint DEFAULT NULL,
  `AreaCode` tinyint unsigned NOT NULL,
  `PANNumber` varchar(25) DEFAULT NULL,
  `IssueDate` datetime DEFAULT NULL,
  `JoiningBasic` decimal(12,2) DEFAULT NULL,
  `PresentBasic` decimal(12,2) DEFAULT NULL,
  `StatusCode` tinyint unsigned DEFAULT NULL,
  `IsMPBuffer` tinyint(1) DEFAULT NULL,
  `OwnResidence` tinyint(1) DEFAULT NULL,
  `TerminationStatus` tinyint(1) DEFAULT NULL,
  `IsSuspended` tinyint(1) DEFAULT NULL,
  `RetirementDate` datetime DEFAULT NULL,
  `SeqNo` int NOT NULL,
  `BloodGroup` varchar(10) DEFAULT NULL,
  `InActiveNNo` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


[2] mysql> SHOW CREATE TABLE course_data_external\G

CREATE TABLE `course_data_external` (
  `Institution` varchar(20) DEFAULT NULL,
  `Course_Number` varchar(20) DEFAULT NULL,
  `LaunchDate` date DEFAULT NULL,
  `CourseTitle` varchar(50) DEFAULT NULL,
  `Instructors` varchar(20) DEFAULT NULL,
  `Year` int DEFAULT NULL,
  `Participants` int DEFAULT NULL,
  `Certified` int DEFAULT NULL,
  `TotalCourseHours` int DEFAULT NULL,
  `MedianAge` int DEFAULT NULL,
  `Male` int DEFAULT NULL,
  `Female` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


[3] mysql> SHOW CREATE TABLE examschedule\G

CREATE TABLE `examschedule` (
  `ClassNo` int DEFAULT NULL,
  `DateFrom` datetime DEFAULT NULL,
  `DateTo` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


[4] mysql> SHOW CREATE TABLE tblcentremaster\G

CREATE TABLE `tblcentremaster` (
  `RefNoteNumber` char(25) DEFAULT NULL,
  `CentreCode` int NOT NULL,
  `CentreName` varchar(50) DEFAULT NULL,
  `StartDate` datetime NOT NULL,
  `DistrictCode` smallint DEFAULT NULL,
  `SectorCode` smallint DEFAULT NULL,
  `ZoneCode` smallint NOT NULL,
  `CentreCategory` smallint NOT NULL,
  `CentreType` varchar(50) DEFAULT NULL,
  `PFNumber` varchar(25) DEFAULT NULL,
  `StorageCapacity` int DEFAULT NULL,
  `LicenceNumber` varchar(25) DEFAULT NULL,
  `IssueDate` datetime NOT NULL,
  `AddressCode` smallint DEFAULT NULL,
  `AgreementCode` varchar(15) DEFAULT NULL,
  `CompanyCode` smallint NOT NULL,
  `DivisionCode` tinyint unsigned NOT NULL,
  `AreaCode` tinyint unsigned DEFAULT NULL,
  `LeafAvailability` varchar(10) DEFAULT NULL,
  `Accomodation` tinyint(1) DEFAULT NULL,
  `ESIApplicable` tinyint(1) DEFAULT NULL,
  `IsOwnCentre` tinyint(1) DEFAULT NULL,
  `ThumbAttendance` tinyint(1) DEFAULT NULL,
  `Period` tinyint unsigned DEFAULT NULL,
  `CentreSize` varchar(10) DEFAULT NULL,
  `PackingType` char(1) DEFAULT NULL,
  `RollerWiseBidiType` char(1) DEFAULT NULL,
  `CentreClosed` tinyint unsigned DEFAULT NULL,
  PRIMARY KEY (`CentreCode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


[5] mysql> SHOW CREATE TABLE tbldesignations\G

CREATE TABLE `tbldesignations` (
  `DesignationCode` smallint NOT NULL,
  `Description` varchar(100) DEFAULT NULL,
  `CategoryCode` tinyint unsigned NOT NULL,
  `ServiceType` tinyint unsigned NOT NULL,
  `EmployeeType` tinyint unsigned NOT NULL,
  `HigherDesgnCode` smallint DEFAULT NULL,
  `AppraisalForm` tinyint unsigned NOT NULL,
  PRIMARY KEY (`DesignationCode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


[6] mysql> SHOW CREATE TABLE tblemployeetypes\G

CREATE TABLE `tblemployeetypes` (
  `EmployeeType` tinyint unsigned NOT NULL,
  `Description` varchar(15) NOT NULL,
  PRIMARY KEY (`EmployeeType`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


[7] mysql> SHOW CREATE TABLE tbllocations\G

CREATE TABLE `tbllocations` (
  `LocationType` tinyint unsigned NOT NULL,
  `LocTypeName` varchar(100) NOT NULL,
  `LocationCode` int NOT NULL,
  `LocCodeName` varchar(100) NOT NULL,
  `HeadCentre` int DEFAULT NULL,
  PRIMARY KEY (`LocationType`,`LocationCode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


[8] mysql> SHOW CREATE TABLE tblpayemployeeparamdetails\G

CREATE TABLE `tblpayemployeeparamdetails` (
  `NoteNumber` varchar(25) NOT NULL,
  `EmployeeNumber` int NOT NULL,
  `ParamCode` varchar(6) NOT NULL,
  `TransValue` smallint DEFAULT NULL,
  `ActualAmount` decimal(12,2) DEFAULT NULL,
  `Amount` decimal(12,2) DEFAULT NULL,
  `EmployerShare` decimal(12,2) DEFAULT NULL,
  `PayType` char(1) DEFAULT NULL,
  `EffectiveFrom` datetime DEFAULT NULL,
  `CalculatedOn` decimal(15,2) DEFAULT NULL,
  `PersonServiceStatus` tinyint unsigned DEFAULT NULL,
  `ParamCalculationRate` decimal(15,2) DEFAULT NULL,
  `EarnedCalculatedOn` decimal(15,2) DEFAULT NULL,
  UNIQUE KEY `U_PayEmployeeparamDetails` (`NoteNumber`,`EmployeeNumber`,`ParamCode`,`EffectiveFrom`,`PersonServiceStatus`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


[9] mysql> SHOW CREATE TABLE tblpayemployees\G

CREATE TABLE `tblpayemployees` (
  `NoteNumber` varchar(25) NOT NULL,
  `EmployeeNumber` int NOT NULL,
  `LocationType` tinyint unsigned DEFAULT NULL,
  `LocationCode` int DEFAULT NULL,
  `GrossPay` decimal(12,2) DEFAULT NULL,
  `Deductions` decimal(12,2) DEFAULT NULL,
  `NetPay` decimal(12,2) DEFAULT NULL,
  `ActualGrossPay` decimal(12,2) DEFAULT NULL,
  `DesignationCode` smallint DEFAULT NULL,
  `Servicetype` tinyint unsigned DEFAULT NULL,
  `EmployeeType` tinyint unsigned DEFAULT NULL,
  `ServiceStatus` tinyint unsigned DEFAULT NULL,
  `CentreCode` int DEFAULT NULL,
  `TotalPaidDays` decimal(6,2) DEFAULT NULL,
  `LastPayAbsentDays` decimal(6,2) DEFAULT NULL,
  `TotalWorkedDays` decimal(6,2) DEFAULT NULL,
  `isPaid` tinyint(1) DEFAULT NULL,
  `ActualPaidDays` decimal(6,2) DEFAULT NULL,
  `ActualNet` decimal(12,2) DEFAULT NULL,
  `Arrers` decimal(10,2) DEFAULT NULL,
  `ArrersPaid` tinyint(1) DEFAULT NULL,
  `EffectiveFrom` datetime DEFAULT NULL,
  `EmpDays` decimal(5,2) DEFAULT NULL,
  `SPPEDays` decimal(5,2) DEFAULT NULL,
  `SPPEPdays` decimal(5,2) DEFAULT NULL,
  `WagePaymentNNO` varchar(25) DEFAULT NULL,
  `WagePaymentNoteNo` datetime DEFAULT NULL,
  `PaymentPeriodDays` decimal(6,2) DEFAULT NULL,
  `DaysAbsent` decimal(6,2) DEFAULT NULL,
  `DayString` varchar(200) DEFAULT NULL,
  `RollerBidi` int DEFAULT NULL,
  `PackerGoodBags` int DEFAULT NULL,
  `packerGoodBidis` int DEFAULT NULL,
  `PackerChatBags` int DEFAULT NULL,
  `PackerChatBidis` int DEFAULT NULL,
  UNIQUE KEY `U_PayEmployees` (`NoteNumber`,`EmployeeNumber`,`EffectiveFrom`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


[10] mysql> SHOW CREATE TABLE tblpaymaster\G

CREATE TABLE `tblpaymaster` (
  `NoteNumber` varchar(25) NOT NULL,
  `NoteDate` datetime DEFAULT NULL,
  `CentreCode` int DEFAULT NULL,
  `ParamCode` varchar(6) DEFAULT NULL,
  `Fromdate` datetime DEFAULT NULL,
  `ToDate` datetime DEFAULT NULL,
  `PayedServiceType` smallint DEFAULT NULL,
  `PayedEmployeeType` smallint DEFAULT NULL,
  `PayedServiceStatus` smallint DEFAULT NULL,
  `LocationType` tinyint unsigned DEFAULT NULL,
  `LocatonCode` int DEFAULT NULL,
  `StateCode` tinyint unsigned DEFAULT NULL,
  PRIMARY KEY (`NoteNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


[11] mysql> SHOW CREATE TABLE tblservicestatus\G

CREATE TABLE `tblservicestatus` (
  `ServiceStatus` tinyint unsigned NOT NULL,
  `Description` varchar(15) NOT NULL,
  PRIMARY KEY (`ServiceStatus`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


[12] mysql> SHOW CREATE TABLE tblservicetypes\G

CREATE TABLE `tblservicetypes` (
  `ServiceType` tinyint unsigned NOT NULL,
  `Description` varchar(15) NOT NULL,
  PRIMARY KEY (`ServiceType`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


[13] mysql> SHOW CREATE TABLE tblstatemaster\G

CREATE TABLE `tblstatemaster` (
  `StateCode` tinyint unsigned NOT NULL,
  `StateName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`StateCode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


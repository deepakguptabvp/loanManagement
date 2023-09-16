//package com.example.LoanApplication.entities;
//
//import javax.persistence.Entity; 
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//
//@Entity
//@Table(name="LOANPRODUCT")
//
//public class LoanProduct {
//	
//	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//
//	 public String bankName;
//	    public String loanProductName;
//	    public Double maxLoanAmount;
//	    public Integer tenure;
//	    public Double interest;
//	    public Double monthlyInstallment;
//
//
//		public LoanProduct(String bankName, String loanProductName, Double maxLoanAmount, Integer tenure, Double interest, Double monthlyInstallment) {
//	    
//	    	this.bankName = bankName;
//	    	this.loanProductName = loanProductName;
//	    	this.maxLoanAmount = maxLoanAmount;
//	    	this.tenure = tenure;
//	    	this.interest = interest;
//	    	this.monthlyInstallment = monthlyInstallment;
//	    }
//	    
//		 
//	    public LoanProduct() {
//			super();
//			// TODO Auto-generated constructor stub
//		}
//	  
//		public String getBankName() {
//	        return bankName;
//	    }
//
//	    public void setBankName(String bankName) {
//	        this.bankName = bankName;
//	    }
//
//	    public String getLoanProductName() {
//	        return loanProductName;
//	    }
//
//	    public void setLoanProductName(String loanProductName) {
//	        this.loanProductName = loanProductName;
//	    }
//
//	    public Double getMaxLoanAmount() {
//	        return maxLoanAmount;
//	    }
//
//
//	    public void setMaxLoanAmount(Double maxLoanAmount) {
//	        this.maxLoanAmount = maxLoanAmount;
//	    }
//
//
//	    public Integer getTenure() {
//	        return tenure;
//	    }
//
//	    public void setTenure(Integer tenure) {
//	        this.tenure = tenure;
//	    }
//
//	    public Double getInterest() {
//	        return interest;
//	    }
//
//	    public void setInterest(Double interest) {
//	        this.interest = interest;
//	    }
//
//	    public Double getMonthlyInstallment() {
//	        return monthlyInstallment;
//	    }
//
//	    public void setMonthlyInstallment(Double monthlyInstallment) {
//	        this.monthlyInstallment = monthlyInstallment;
//	    }
//
//		@Override
//		public String toString() {
//			return "LoanProduct [bankName=" + bankName + ", loanProductName=" + loanProductName + ", maxLoanAmount="
//					+ maxLoanAmount + ", tenure=" + tenure + ", interest=" + interest + ", monthlyInstallment="
//					+ monthlyInstallment + "]";
//		}
//	    
//	   
//
//}

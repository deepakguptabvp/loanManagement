//package com.example.LoanApplication.services;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.stereotype.Service;
//
//import com.example.LoanApplication.entities.Customer;
//import com.example.LoanApplication.entities.LoanProduct;
//
//
//@Service
//public class LoanService {
//
//	 public List<LoanProduct> checkEligibleLoanProducts(Customer details)   {
//			 
//			 
//			 throws ApplicationException {
// 
//	        if(details.getDesiredLoanAmount() > (12*details.getMonthlyIncome())) {
//	        	
//	            throw new ApplicationException("Customer Not Eligible for Loan");
//	        }
//	        
//	        List<LoanProduct>data = new ArrayList<LoanProduct>();
//	        
//	        if(details.getEmploymentType().length()>=4 && details.getEmploymentType().length()<=30)	{
//	            String employmentType=details.getEmploymentType();
//	            
//	            List<LoanProduct>product = new ArrayList<LoanProduct>();
//	            
//	            product = buildLoanProducts();
//	            
//	            for(int i=0;i<product.size();i++) {
//	            	
//	                if(product.get(i).getLoanProductName().contains(employmentType))  {
//	                    data.add(product.get(i));
//	                }
//	            }
//	        }
//	        return data;
//	    }
//
//	    private List<LoanProduct>buildLoanProducts(){
//	        List<LoanProduct>products=new ArrayList<LoanProduct>();
//	        LoanProduct product1=new LoanProduct();
//	        product1.setBankName("SBIBank");
//	        product1.setLoanProductName("Pre-Approved Personal Loan for Pensioner");
//	        product1.setMaxLoanAmount(500000.00);
//	        product1.setMonthlyInstallment(7000.00);
//	        product1.setTenure(24);
//	        product1.setInterest(16.40);
//	        products.add(product1);
//
//	        LoanProduct product2=new LoanProduct();
//	        product2.setBankName("PNBBank");
//	        product2.setLoanProductName(" Pre-Approved Education Loan for Student");
//	        product2.setMaxLoanAmount(1200000.00);
//	        product2.setMonthlyInstallment(11000.00);
//	        product2.setTenure(48);
//	        product2.setInterest(12.40);
//	        products.add(product2);
//
//	        LoanProduct product3=new LoanProduct();
//	        product3.setBankName("AxisBank");
//	        product3.setLoanProductName("Pre-Approved Personal Loan for Salaried");
//	        product3.setMaxLoanAmount(1000000.00);
//	        product3.setMonthlyInstallment(9000.00);
//	        product3.setTenure(36);
//	        product3.setInterest(15.40);
//	        products.add(product3);
//
//	        LoanProduct product4=new LoanProduct();
//	        product4.setBankName("ICICIBank");
//	        product4.setLoanProductName("Pre-Approved Personal Loan for Salaried");
//	        product4.setMaxLoanAmount(700000.00);
//	        product4.setMonthlyInstallment(8000.00);
//	        product4.setTenure(24);
//	        product4.setInterest(15.20);
//	        products.add(product4);
//
//	        LoanProduct product5=new LoanProduct();
//	        product5.setBankName("HDFCBank");
//	        product5.setLoanProductName("Pre-Approved Personal Loan for Self-Employed");
//	        product5.setMaxLoanAmount(2500000.00);
//	        product5.setMonthlyInstallment(34000.00);
//	        product5.setTenure(720);
//	        product5.setInterest(11.40);
//	        products.add(product5);
//
//	        return products;
//	    }
//
//			 
//	 }
//}
//
//

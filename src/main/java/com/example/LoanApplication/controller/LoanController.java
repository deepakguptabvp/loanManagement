//package com.example.LoanApplication.controller;
//import com.example.LoanApplication.services.LoanService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping(value = "/api/loanproduct", produces = "application/json")
//public class LoanController {
//
//	@Value("${message}")
//	private String message;
//
//	private final LoanService loanService;
//
//	@Autowired
//	public LoanController(LoanService loanService) {
//		this.loanService = loanService;
//	}
//	
//}
//
//    @RequestMapping(value = "/home", method = RequestMethod.GET)
//    public String showHomePage(Model model) {
//        Customer customerDetails = new Customer();
//        model.addAttribute("customerDetails", customerDetails);
//        return "loanEligibile";
//    }
//
//    @RequestMapping(value = "/eligibilityCheck", method = RequestMethod.POST)
//
//    @ModelAttribute
//    public String getLoanProducts(Model model, HttpServletRequest request, HttpServletResponse response,
//     @Validated Customer customerDetails, @NotNull BindingResult result) {
//        if (!result.hasErrors()) {
//            List<LoanProduct> data = new ArrayList<LoanProduct>();
//
//            data = loanService.checkEligibleLoanProducts(customerDetails);
//            if (data.isEmpty()) {
//                model.addAttribute("msg", "Sorry,no loan products matching your profile.");
//            } else {
//                model.addAttribute("data", data);
//                model.addAttribute("msg", "Congratulations.You are Eligible for the below Loan Products:");
//            }
//        }
//        return (result.hasErrors() ? "loanEligibility" : "results");
//    }
//
//    @ModelAttribute("cityList")
//    public List<String> getCities() {
//        List<String> cityList = new ArrayList<String>();
//        cityList.add("");
//        cityList.add("Delhi");
//        cityList.add("Chennai");
//        cityList.add("Mumbai");
//        cityList.add("Bangalore");
//        return cityList;
//    }
//
//    @ModelAttribute("employeeList")
//    public List<String> getEmploymentTypes() {
//        List<String> employeeList = new ArrayList<String>();
//        employeeList.add("");
//        employeeList.add("Salaried");
//        employeeList.add("Self-Employed");
//        employeeList.add("ContractualEmployment");
//        employeeList.add("Student");
//        employeeList.add("Pensioner");
//        return employeeList;
//    }
//
//    @ModelAttribute("genderList")
//    List<String> getGenderOptions() {
//        List<String> genderList = new ArrayList<String>();
//        genderList.add("Male");
//        genderList.add("Female");
//        return genderList;
//    }

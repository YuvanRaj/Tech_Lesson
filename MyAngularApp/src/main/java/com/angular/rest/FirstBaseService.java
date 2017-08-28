package com.angular.rest;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.angular.cfc.UserInformation;

@Path("/BaseRequest")
public class FirstBaseService {
	
	@Path("getName")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserInformation> getUserName() {			
		UserInformation userInfoObject= null;
		List<UserInformation> userInformationList = new ArrayList<UserInformation>(10);
		int i=0;
		while(i<10){
			userInfoObject = new UserInformation();
			userInfoObject.setName("Yuvaraj"+i);
			userInfoObject.setOrigin("Salem"+i);
			userInfoObject.setDestination("Chennai"+i);
			userInformationList.add(userInfoObject);
			i++;
		}	
		return userInformationList;
	}
	
	@Path("getRoot")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseObject getRoot(InputVO inputVO) {
		ResponseObject responseObject = new ResponseObject();
		PolynomialCalculator polynomialCalculator = new PolynomialCalculator();
		Double[] roots = polynomialCalculator.getSolutionForPolynomialEquation(inputVO.getRoot1(), inputVO.getRoot2(), inputVO.getRoot3());
		
		responseObject.setX1(roots[0]);
		responseObject.setX2(roots[1]);
		
		return responseObject;
	}
	
	@Path("getBookingInfo")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public List<BookingInfo> getBookingInfo(BookingVO mookingVO) {
		List<BookingInfo> bookingInfoList = new ArrayList<BookingInfo>();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1988);
		cal.set(Calendar.MONTH, Calendar.JANUARY);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		BookingInfo bookingInfo = null;
		for(int i=0;i<10;i++){
			bookingInfo = new BookingInfo();
			bookingInfo.setOrigin("HKHKG"+i);
			bookingInfo.setDestination("SGSIN"+i);
			bookingInfo.setArrivalDate(cal.getTime());
			bookingInfoList.add(bookingInfo);
		}
		return bookingInfoList;
	}

	@Path("getExpenses")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseObject getExpense(ExpenseVO expenseVOList) {
		ResponseObject responseObject = new ResponseObject();
		int expenseAmount = 0;
		/*for(ExpenseVO expenseVO : expenseVOList){
			expenseAmount += expenseVO.getLastName();
		}*/
		responseObject.setExpensedSum(expenseAmount);		
		return responseObject;
	}
}

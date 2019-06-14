package com.decepticons.assetManagement.util;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import com.decepticons.assetManagement.entity.DepartmentManager;
import com.decepticons.assetManagement.entity.Employee;

public class AssetManagementUtil {

	private static AssetManagementUtil objDF = new AssetManagementUtil();

	public static AssetManagementUtil getFormatter() {
		return objDF;
	}

	/**
	 * Format Date
	 * 
	 * @param strDate
	 * @return
	 */
	public Date formatDateString(String strDate) {
		System.out.println(" input Date " + strDate);
		try {
			// Date date=new SimpleDateFormat("yyyy-dd-mm").parse(strDate);

			DateFormat df = new SimpleDateFormat("yyyy-dd-mm");
			Date date = new Date(df.parse(strDate).getTime());
			return date;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * check if its a new user
	 * 
	 * @param e
	 * @return
	 */
	public boolean isNewUser(Employee e) {
		System.out.println(" isNewSUer : " + e.getId() + e.getUserName());
		if (e.getId() > 0) {
			return false;
		}
		return true;
	}

	/**
	 * generate userName
	 */

	public String generateUserName(Employee e, int iCurrentNoOfEmp) {
		String lastName = e.getLastname();
		String firstName = e.getFirstname();

		int userid = iCurrentNoOfEmp + 1;

		String userName = firstName.charAt(0) + (lastName.length() >= 3 ? lastName.substring(0, 2) : lastName).toLowerCase() + userid;

		return userName;
	}
	public List<Employee> availableManager (List<Employee> emp, List<DepartmentManager> man){
		for(DepartmentManager m : man) {
	public List<Employee> availableManager(List<Employee> emp, List<DepartmentManager> man) {
		for (DepartmentManager m : man) {
			if (emp.contains(m.getDeptEmpId())) {
				emp.remove(m.getDeptEmpId());
			}
		}
		return emp;
	}
}

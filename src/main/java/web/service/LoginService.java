package web.service;

/**
 * Business logic to handle login functions.
 * 
 * @author Ahsan.
 */
public class LoginService { 

	/**
	 * Static method returns true for successful login, false otherwise.
	 * @param username
	 * @param password
	 * @param dob Date of birth in format mm/dd/yyyy
	 * @return
	 */
	
	
	
	
		public static boolean login(String username, String password, String dob) {
			if ("ahsan".equals(username) && "ahsan_pass".equals(password) && "1993-05-22".equals(dob)) {
		        return true;
		}
		return false;
	}
	
	
}

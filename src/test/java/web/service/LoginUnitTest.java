package web.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LoginUnitTest {
	// Equivalence Classes test cases
	@Test
	public void testValidUsername() {
	    assertTrue(LoginService.login("ahsan", "ahsan_pass", "1993-05-22"));
	}
	@Test
	public void testEmptyUsername() {
		assertFalse(LoginService.login("", "ahsan_pass", "05/22/1993"));
	}

	@Test 
	public void testEmptyPassword() {
		assertFalse(LoginService.login("ahsan", "", "1996-07-27"));
	}

	@Test
	public void testEmptyDOB() {
		assertFalse(LoginService.login("ahsan", "ahsan_pass", ""));
	}

	@Test
	public void testNullUsername() {
		assertFalse(LoginService.login(null, "ahsan_pass", "1996-07-27"));
	}

	@Test
	public void testNullPassword() {
		assertFalse(LoginService.login("ahsan", null, "1996-07-27"));
	}

	@Test
	public void testNullDOB() {
		assertFalse(LoginService.login("ahsan", "ahsan_pass", null));
	}

	@Test
	public void testWrongUsername() {
		assertFalse(LoginService.login("john", "ahsan_pass", "05/22/1993"));
	}

	@Test
	public void testWrongPassword() {
		assertFalse(LoginService.login("ahsan", "password123", "05/22/1993"));
	}

	@Test
	public void testWrongDOB() {
		assertFalse(LoginService.login("ahsan", "ahsan_pass", "05/22/1999"));
	}

	@Test
	public void testAllCredentialsIncorrect() {
		assertFalse(LoginService.login("john", "password", "05/22/1991"));
	}
	// Boundary Value Analysis test cases
	@Test
    public void testUsernameJustBefore() {
        assertFalse(LoginService.login("ahsamo", "ahsan_pass", "05/22/1993"));
    }

    @Test
    public void testUsernameJustAfter() {
        assertFalse(LoginService.login("ahsap", "ahsan_pass", "05/22/1993"));
    }

    @Test
    public void testPasswordJustBefore() {
        assertFalse(LoginService.login("ahsan", "ahsan_pas", "05/22/1993"));
    }

    @Test
    public void testPasswordJustAfter() {
        assertFalse(LoginService.login("ahsan", "ahsan_passo", "05/22/1993"));
    }

    @Test
    public void testDOBJustBefore() {
        assertFalse(LoginService.login("ahsan", "ahsan_pass", "05/21/1993"));
    }

    @Test
    public void testDOBJustAfter() {
        assertFalse(LoginService.login("ahsan", "ahsan_pass", "05/23/1993"));
    }
}

package ilike.socnet;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ilike.TestData;

/**
 * Tests on Authenticator, a class to authenticate users
 * 
 * @author José Paulo Leal <zp@dcc.fc.up.pt>
 */
public class AuthenticatorTest extends TestData {
	
	Authenticator authenticator; 
	
	@Before
	public void setUp() throws Exception {
		authenticator  = new Authenticator();
	}

	/**
	 * Test user registration. Users can be registered only once 
	 */
	@Test
	public void testRegister() {
		assertTrue("User can be registered",authenticator.register(USER1_ID, PASSWORD1));
		assertFalse("User cannot be registered again",authenticator.register(USER1_ID, PASSWORD1));
		assertFalse("User cannot be registered again",authenticator.register(USER1_ID, PASSWORD2));
		
		assertTrue("User can be registered",authenticator.register(USER2_ID, PASSWORD2));
		assertFalse("User cannot be registered again",authenticator.register(USER2_ID, PASSWORD1));
		assertFalse("User cannot be registered again",authenticator.register(USER2_ID, PASSWORD2));
	}

	/**
	 * Check that users are authenticated only after registered
	 * and only with same password they were registered 
	 */
	@Test
	public void testAuthenticate() {
		assertFalse("User not registered yet",authenticator.authenticate(USER1_ID, PASSWORD1));
		assertFalse("User not registered yet",authenticator.authenticate(USER1_ID, PASSWORD2));
		
		authenticator.register(USER1_ID, PASSWORD1);
		
		assertTrue("Password is correct",authenticator.authenticate(USER1_ID, PASSWORD1));
		assertFalse("Password is wrong",authenticator.authenticate(USER1_ID, PASSWORD2));
		
		assertFalse("Password is wrong",authenticator.authenticate(USER2_ID, PASSWORD1));
		assertFalse("User not registered yet",authenticator.authenticate(USER2_ID, PASSWORD2));
		
		authenticator.register(USER2_ID, PASSWORD2);
		
		assertTrue("Password is correct",authenticator.authenticate(USER2_ID, PASSWORD2));
		assertFalse("Password is wrong",authenticator.authenticate(USER2_ID, PASSWORD1));
	}

	/**
	 * Check that password can be changed only if user was registered
	 * and if old password is correct 
	 */
	@Test
	public void testUpdatePassword() {
		
		assertFalse("Password is wrong",authenticator.updatePassword(USER1_ID, PASSWORD1,PASSWORD2));
		
		authenticator.register(USER1_ID, PASSWORD1);
		
		assertFalse("Wrong password, cannot update",authenticator.updatePassword(USER1_ID, PASSWORD2,PASSWORD1));
		assertTrue("Right password, should udpate",authenticator.updatePassword(USER1_ID, PASSWORD1,PASSWORD2));
		assertFalse("Wrong password, cannot update",authenticator.updatePassword(USER1_ID, PASSWORD1,PASSWORD2));		
	}

}

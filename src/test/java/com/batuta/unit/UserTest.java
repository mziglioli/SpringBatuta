package com.batuta.unit;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.batuta.model.User;
import com.batuta.service.UserService;

public class UserTest {
	private UserService userService;
	private User user;

	@Before
	public void setupMock() {
		user = mock(User.class);
		userService = mock(UserService.class);
	}

	@Test
	public void testMockCreation() {
		assertNotNull(user);
		assertNotNull(userService);
	}
}

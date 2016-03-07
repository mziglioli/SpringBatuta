package com.batuta.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.batuta.model.User;
import com.batuta.service.UserService;

public class UserAnnotationTest {
	
	@Mock
	private UserService userService;
	@Mock
	private User user;

	
    @Before
    public void setupMock() {
       MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testMockCreation(){
        assertNotNull(user);
        assertNotNull(userService);
    }
    
    @Test
    public void findAllUsers() {
        when(userService.getQtdUsers()).thenReturn(30L);
        assertEquals(30,userService.getQtdUsers().longValue());
    }
}

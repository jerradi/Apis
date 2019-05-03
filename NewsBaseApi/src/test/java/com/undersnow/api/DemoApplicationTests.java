package com.undersnow.api;

 
import static org.junit.Assert.*;

import org.junit.Test;

 
 
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
        assertEquals(1, 1);
        assertNotEquals(-1, 2);
        
	}
	
	@Test
	public void boolVals() {
        assertEquals(Boolean.valueOf("True"), true);

        assertEquals(Boolean.valueOf("TrUe"), true);

        assertEquals(Boolean.valueOf("1"), false);
        
	}


}

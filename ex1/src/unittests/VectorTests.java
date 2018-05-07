package unittests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import primitives.Vector;

public class VectorTests {
	
	@Test
	public void testAdd() {
		Vector v = new Vector(5,-5,10);
		Vector c = new Vector(-5,5,-10);
		Vector d = v.add(c);
		assertEquals(d.length(),0);
		
	}
	
	@Test
	public void testNormalize(){
		Vector v = new Vector(3.5,1.5,1.9);
		v.normalize();
		assertEquals(1 ,v.length());
		v = new Vector(0,0,0);
		try {
			v.normalize();
			fail("Didn't throw divide by zero exception!");
		} catch (ArithmeticException e) {
			assertTrue(true);
		}
	}

}

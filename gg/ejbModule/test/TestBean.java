package test;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class TestBean
 */
@Stateless
public class TestBean implements TestBeanRemote {
	
	/**
	 * Biznis logika ktora vrati rozsireny textovy retazec
	 */
    public String testMe(String input) {
    	return "tested " + input;
    }


}

package test;

import javax.ejb.Remote;

@Remote
public interface TestBeanRemote {
	
	public String testMe(String input);

}

package test;

import javax.ejb.Remote;

@Remote
public interface TestBeanRemote {
	
	public String testMe(String input);
	public String test1(String input);
	public int test2(int id);

}

package backend1.app.exception;

public class myexception extends Exception{
String msg="ID not found";
	
	public myexception(String msg) {
		this.msg=msg;
	}
	@Override
	public String toString() {
		return msg;
	}
	
}

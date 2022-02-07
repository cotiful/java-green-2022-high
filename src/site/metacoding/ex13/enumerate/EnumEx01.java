package site.metacoding.ex13.enumerate;

interface Direction{ //인터페이스를 작성하면 ,public static final이 생략돼 있
	String LEFT ="Left";
	String RIGHT ="Right";
}
public class EnumEx01 {
	
	public static void add(String direction) {
		//"Left","Right"
		if(direction.equals("Left")||direction.equals("Right")) {
			System.out.println("very well");
		}else {
			System.out.println("very bad");
		}
	}
	public static void main(String[] args) {
		add(Direction.LEFT);
		
		
	}

}

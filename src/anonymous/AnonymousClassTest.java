package anonymous;

interface Test{
    public void go(String name);		
}
	
public class AnonymousClassTest {
	
    public static void main(String[] args) {
		
        //익명객체 test 
        Test test = new Test(){
            public void go(String name){
                System.out.println(name + " GO! GO!");
            }
        };
        test.go("aaa");
        test.go("bbb");
    }

}


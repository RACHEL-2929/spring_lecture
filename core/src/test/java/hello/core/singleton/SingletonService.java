package hello.core.singleton;

public class SingletonService {

    // 객체가 딱 하나만 만들어짐
    private static SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }
    
    private SingletonService() {}

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}

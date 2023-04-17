package hello.core.singleton;

public class SingletonService {
    
    private static final SingletonService instance = new SingletonService();
    
    public static SingletonService getInstance(){
        return instance;
    }

    //외부에서 new 키워드 통해 객체 생성불가 -> private 으로 만들었기 때문
    private SingletonService(){
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
    
}

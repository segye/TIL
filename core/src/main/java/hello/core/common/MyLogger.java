package hello.core.common;


import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value = "request",proxyMode = ScopedProxyMode.TARGET_CLASS) //request scope로 지정 HTTP 요청 당 하나씩 생성 요청 끝나는 시점에 소멸
public class MyLogger {

    private String uuid; //uuid로 다른 http 요청과 구분 가능
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message){
        System.out.println("[" + uuid +"]"+"["+requestURL+"] "+message);
    }

    @PostConstruct //빈 생성되는 시점
    public void init(){
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid +"] request scope bean create:"+ this);

    }

    @PreDestroy //빈 소멸되는 시점
    public void close(){ 
        System.out.println("[" + uuid +"] request scope bean close:"+ this);
    }
}

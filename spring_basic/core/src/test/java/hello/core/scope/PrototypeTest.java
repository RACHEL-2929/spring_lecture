package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import static org.assertj.core.api.Assertions.assertThat;

public class PrototypeTest {

    /*
    * prototype은 한 번 생성 후 스프링 컨테이너에서 관리하지 않음
    * 그래서 클라이언트가 요청할 때마다 새로운 빈을 생성
    * 그래서 prototypeBean1과 prototypeBean2는 같지 않음
    * 즉, 스프링 컨테이너가 생성과 의존관계 주입, 초기화까지만 관여하고, 더는 관리 하지않음
    * 따라서 프로토타입 빈은 스프링 컨테이너가 종료될 때 @PreDestory 같은 종료 메서드가 실행되지 않음
    * */

    @Test
    void prototypeBeanFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        System.out.println("find prototypeBean1");
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        System.out.println("find prototypeBean2");
        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
        System.out.println("prototypeBean1 = " + prototypeBean1);
        System.out.println("prototypeBean2 = " + prototypeBean2);

        assertThat(prototypeBean1).isNotSameAs(prototypeBean2);


/*        prototypeBean1.destroy();
        prototypeBean2.destroy();*/
        /* 이처럼 수동으로 닫아줘야 한다. */
        ac.close();
    }


    @Scope("prototype")
    static class PrototypeBean{

        @PostConstruct
        public void init(){
            System.out.println("PrototypeBean.init");
        }

        @PreDestroy
        public void destroy(){
            System.out.println("PrototypeBean.destroy");
        }

    }
}

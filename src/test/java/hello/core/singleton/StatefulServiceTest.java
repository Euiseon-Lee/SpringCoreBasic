package hello.core.singleton;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        //싱글톤 방식은 여러 클라이언트가 하나의 같은 객체 인스턴스를 공유하기 때문에
        //싱글톤 객체는 상태를 유지(stateful)하게 설계하면 안된다
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //ThreadA: 사용자A가 10000원 주문
        int userAPrice = statefulService1.order("userA", 10000);
        //ThreadB: 사용자B가 20000원 주문
        int userBPrice = statefulService1.order("userB", 20000);

        //ThreadA: 사용자A 주믄 금액 조회
//        int price = statefulService1.getPrice();
//        System.out.println("price = " + price);     //<에러> 20000 출력됨

        System.out.println("userAPrice = " + userAPrice);    //정상출력
//        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}